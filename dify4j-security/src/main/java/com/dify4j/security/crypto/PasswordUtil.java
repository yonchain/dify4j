package com.dify4j.security.crypto;

import com.dify4j.api.exception.Dify4jException;
import com.dify4j.api.exception.Dify4jIllegalStateException;
import com.dify4j.api.security.Password;
import io.micrometer.common.util.StringUtils;

public class PasswordUtil {

    // 标识
    private static final String FLAG = "dify";

    public static String encode(String password, String salt) {
        return encode(new Password(password, salt));
    }

    public static String encode(Password difyPassword) {
        String password = difyPassword.getPassword();
        if (StringUtils.isBlank(password)) {
            throw new Dify4jIllegalStateException("密码不能为空");
        }
        String salt = difyPassword.getSalt();
        if (StringUtils.isBlank(salt)) {
            throw new Dify4jIllegalStateException("盐值不能为空");
        }
        return FLAG + ":" + password + ":" + salt;
    }


    public static Password decode(String password) {
        // 格式：dify:password:salt
        if (StringUtils.isBlank(password)) {
            throw new Dify4jIllegalStateException("密码不能为空");
        }
        String[] split = password.split(":");
        if (split.length != 3 || !FLAG.equals(split[0])) {
            throw new Dify4jIllegalStateException("密码格式不正确");
        }
        password = split[1];
        String salt = split[2];
        return new Password(password, salt);
    }
}
