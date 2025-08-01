package com.dify4j.console.knowledge.controller;

import com.dify4j.api.idm.ApiKey;
import com.dify4j.api.knowledge.KnowledgeService;
import com.dify4j.console.BaseController;
import com.dify4j.console.idm.response.ApiKeyResponse;
import com.dify4j.web.response.ApiResponse;
import com.dify4j.web.response.ListResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 知识库API密钥控制器
 *
 * @author Cgy
 * @since 2024-01-20
 */
@RestController
@RequestMapping("/knowledges")
@Tag(name = "知识库API密钥", description = "知识库API密钥相关接口")
public class KnowledgeApikeyController extends BaseController {

    @Autowired
    private KnowledgeService knowledgeService;

    /**
     * 查询知识库API密钥列表
     *
     * @return 知识库API密钥列表
     */
    @GetMapping("/api-keys")
    @Operation(summary = "查询知识库API密钥列表", description = "根据当前租户获取知识库列表")
    public ListResponse<ApiKeyResponse> getApiKeys() {
        List<ApiKey> apiKeys = knowledgeService.getApiKeys(this.getCurrentTenantId());
        return this.responseFactory.createApiKeysResponse(apiKeys);
    }


    /**
     * 创建密钥
     *
     * @return 创建新的创建密钥
     */
    @PostMapping("/api-keys")
    @Operation(summary = "创建密钥", description = "创建新的创建密钥")
    public ApiKeyResponse createApiKey() {
        ApiKey apiKey = knowledgeService.createApiKey(this.getCurrentTenantId());
        return responseFactory.createApiKeyResponse(apiKey);
    }

    /**
     * 删除知识库密钥
     *
     * @param apikeyId 知识库ID
     * @return 空响应
     */
    @DeleteMapping("/api-keys/{apikeyId}")
    @Operation(summary = "删除知识库密钥", description = "根据密钥ID删除知识库密钥")
    public ApiResponse<Void> deleteApiKey(@Parameter(description = "知识库ID") @PathVariable String apikeyId) {
        knowledgeService.deleteApiKey(this.getCurrentTenantId(), apikeyId);
        return ApiResponse.success();
    }

}
