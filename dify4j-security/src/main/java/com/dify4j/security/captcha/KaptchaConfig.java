package com.dify4j.security.captcha;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class KaptchaConfig {

   /* @Bean
    public DefaultKaptcha softColorKaptcha() {
        DefaultKaptcha kaptcha = new DefaultKaptcha();
        Properties props = new Properties();

        props.setProperty("kaptcha.border", "no");
        props.setProperty("kaptcha.image.width", "140");
        props.setProperty("kaptcha.image.height", "50");

        // 字母数字组合
        props.setProperty("kaptcha.textproducer.char.string", "ABCDEFGHJKLMNPQRSTUVWXYZ23456789");
        props.setProperty("kaptcha.textproducer.char.length", "4");

        // 柔和字体颜色
        props.setProperty("kaptcha.textproducer.font.names", "Georgia, serif");
        props.setProperty("kaptcha.textproducer.font.size", "34");
        props.setProperty("kaptcha.textproducer.font.color", "72,119,142"); // 蓝灰色

        // 柔和背景渐变
        props.setProperty("kaptcha.background.clear.from", "240,248,255"); // 爱丽丝蓝
        props.setProperty("kaptcha.background.clear.to", "230,240,250"); // 更浅的蓝色

        // 轻微干扰
        props.setProperty("kaptcha.noise.impl", "com.google.code.kaptcha.impl.DefaultNoise");
        props.setProperty("kaptcha.noise.color", "200,220,240"); // 浅蓝色噪点

        kaptcha.setConfig(new Config(props));
        return kaptcha;
    }*/
}