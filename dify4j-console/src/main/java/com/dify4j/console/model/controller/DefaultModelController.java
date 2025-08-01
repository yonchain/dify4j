package com.dify4j.console.model.controller;

import com.dify4j.api.model.DefaultTenantDefaultModel;
import com.dify4j.api.model.ModelService;
import com.dify4j.api.model.TenantDefaultModel;
import com.dify4j.console.BaseController;
import com.dify4j.console.ResponseFactory;
import com.dify4j.console.model.request.TenantDefaultModelRequest;
import com.dify4j.console.model.response.TenantDefaultModelResponse;
import com.dify4j.utils.IdUtil;
import com.dify4j.web.response.ApiResponse;
import com.dify4j.web.response.ListResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 默认模型控制器
 *
 * @author Craft
 * @since 1.0.0
 */
@RestController
@RequestMapping("/default-models")
@Tag(name = "默认模型管理", description = "默认模型管理相关接口")
public class DefaultModelController extends BaseController {

    @Autowired
    private ModelService modelService;

    @Autowired
    private ResponseFactory responseFactory;

    /**
     * 查询当前租户默认模型
     *
     * @return 默认模型分页数据
     */
    @GetMapping
    @Operation(summary = "查询默认模型", description = "查询当前租户默认模型")
    public ListResponse<TenantDefaultModelResponse> getDefaultModels() {
        List<TenantDefaultModel> defaultModels = modelService.getDefaultModels(this.getCurrentTenantId());
        return responseFactory.createDefaultModeListResponse(defaultModels);
    }

    /**
     * 创建默认模型
     *
     * @param requests 创建请求
     * @return 创建结果
     */
    @PostMapping
    @Operation(summary = "创建默认模型", description = "创建新的默认模型")
    public ApiResponse<Boolean> save(@RequestBody List<TenantDefaultModelRequest> requests) {
        String tenantId = this.getCurrentTenantId();
        modelService.setDefaultModels(tenantId,requests.stream()
                .map(request -> {
                    TenantDefaultModel defaultModel = new DefaultTenantDefaultModel();
                    defaultModel.setTenantId(tenantId);
                    defaultModel.setProviderName(request.getProviderName());
                    defaultModel.setModelName(request.getModelName());
                    defaultModel.setModelType(request.getModelType());
                    defaultModel.setId(IdUtil.generateId());
                    defaultModel.setCreatedAt(LocalDateTime.now());
                    defaultModel.setUpdatedAt(LocalDateTime.now());
                    return defaultModel;
                })
                .toList());
        return ApiResponse.success();
    }

}
