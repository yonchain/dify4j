package com.dify4j.console.app.controller;

import com.dify4j.api.app.AppService;
import com.dify4j.api.idm.ApiKey;
import com.dify4j.console.BaseController;
import com.dify4j.console.idm.response.ApiKeyResponse;
import com.dify4j.web.response.ApiResponse;
import com.dify4j.web.response.ListResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 应用API密钥控制器
 *
 * @author Cgy
 * @since 2024-01-20
 */
@RestController
@RequestMapping("/apps")
@Tag(name = "应用API密钥", description = "应用API密钥相关接口")
public class AppApikeyController extends BaseController {

    @Autowired
    private AppService appService;

    /**
     * 查询应用API密钥列表
     *
     * @param appId 应用ID
     * @return 应用api密钥列表
     */
    @GetMapping("/{appId}/api-keys")
    @Operation(summary = "查询应用api密钥列表", description = "根据应用id获取应用列表")
    public ListResponse<ApiKeyResponse> getAppApiKeys(@Parameter(description = "应用ID") @PathVariable String appId) {
        List<ApiKey> apiKeys = appService.getAppApiKeys(appId);
        return this.responseFactory.createApiKeysResponse(apiKeys);
    }

    /**
     * 创建应用API密钥
     *
     * @param appId 应用ID
     * @return 创建新的创建密钥
     */
    @PostMapping("/{appId}/api-keys")
    @Operation(summary = "创建应用API密钥", description = "创建新的创建密钥")
    public ApiKeyResponse createApp(@Parameter(description = "应用ID") @PathVariable String appId) {
        ApiKey apiKey = appService.createAppApiKey(this.getCurrentTenantId(), appId);
        return responseFactory.createApiKeyResponse(apiKey);
    }

    /**
     * 删除应用密钥
     *
     * @param apikeyId 应用ID
     * @return 空响应
     */
    @DeleteMapping("/{appId}/api-keys/{apikeyId}")
    @Operation(summary = "删除应用API密钥", description = "根据密钥ID删除应用密钥")
    public ApiResponse<Void> deleteAppById(@Parameter(description = "应用id") @PathVariable String appId,
                                           @Parameter(description = "密钥id") @PathVariable String apikeyId) {
        appService.deleteAppApiKey(appId, apikeyId);
        return ApiResponse.success();
    }

}
