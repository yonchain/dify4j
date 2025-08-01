package com.dify4j.console.idm.controller;

import com.dify4j.web.response.ApiResponse;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 登录控制器
 *
 * @author Cgy
 */
@RestController
@RequestMapping
public class LoginController {


    /**
     * 退出登录
     *
     * @return ApiResponse<Void>
     */
    @DeleteMapping("/auth/logout")
    public ApiResponse<Void> logout() {
        return ApiResponse.success();
    }
}

