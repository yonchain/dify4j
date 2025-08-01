package com.dify4j.console.knowledge.controller;

import com.dify4j.api.common.Page;
import com.dify4j.api.exception.Dify4jException;
import com.dify4j.api.exception.Dify4jIllegalStateException;
import com.dify4j.api.knowledge.DefaultKnowledge;
import com.dify4j.api.knowledge.Knowledge;
import com.dify4j.api.knowledge.KnowledgeService;
import com.dify4j.console.BaseController;
import com.dify4j.console.knowledge.request.KnowledgeQueryRequest;
import com.dify4j.console.knowledge.request.KnowledgeRequest;
import com.dify4j.console.knowledge.response.KnowledgeResponse;
import com.dify4j.web.response.ApiResponse;
import com.dify4j.web.response.PageResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 知识库管理控制器
 */
@Tag(name = "知识库管理", description = "知识库相关接口")
@RestController
@RequestMapping("/datasets")
public class KnowledgeController extends BaseController {

    @Autowired
    private KnowledgeService knowledgeService;


    @Operation(summary = "获取知识库详情")
    @GetMapping("/{id}")
    public KnowledgeResponse getKnowledgeById(@Parameter(description = "知识库ID") @PathVariable String id) {
        Knowledge knowledge = getKnowledgeFromRequest(id);
        return responseFactory.createKnowledgeResponse(knowledge);
    }

    @Operation(summary = "分页查询知识库")
    @GetMapping
    public PageResponse<KnowledgeResponse> pageKnowledge(KnowledgeQueryRequest request) {
        String tenantId = this.getCurrentTenantId();

        Map<String, Object> queryParam = new HashMap<>();
        queryParam.put("keyword", request.getKeyword());

        Page<Knowledge> knowledges = knowledgeService.getKnowledgeListByPage(tenantId, queryParam, request.getPage(), request.getLimit());
        return responseFactory.createKnowledgePageResponse(knowledges);
    }


    @Operation(summary = "创建知识库")
    @PostMapping
    public KnowledgeResponse createKnowledge(@Valid @RequestBody KnowledgeRequest request) {
        Knowledge knowledge = new DefaultKnowledge();
        knowledge.setId(UUID.randomUUID().toString());
        knowledge.setTenantId(this.getCurrentTenantId());
        knowledge.setCreatedBy(this.getCurrentUserId());
        knowledge.setUpdatedBy(this.getCurrentUserId());

        //从请求获取数据填充
        populateKnowledgeFromRequest(knowledge, request);

        // 创建知识库
        knowledgeService.createKnowledge(knowledge);

        return responseFactory.createKnowledgeResponse(knowledgeService.getKnowledgeById(knowledge.getId()));
    }

    @Operation(summary = "更新知识库")
    @PutMapping("/{id}")
    public ApiResponse<Void> updateKnowledge(@Parameter(description = "知识库ID") @PathVariable String id,
                                             @Valid @RequestBody KnowledgeRequest request) {

        Knowledge knowledge = getKnowledgeFromRequest(id);

        // 检查知识库名称是否已存在（排除当前知识库）
        if (knowledgeService.checkNameExists(request.getName(), knowledge.getTenantId(), id)) {
            throw new IllegalArgumentException("知识库名称已存在");
        }

        // 设置更新者ID，实际项目中应从当前登录用户中获取
        knowledge.setUpdatedBy(this.getCurrentUserId());

        //从请求获取数据填充
        populateKnowledgeFromRequest(knowledge, request);

        // 更新知识库
        knowledgeService.updateKnowledge(knowledge);

        return ApiResponse.success();
    }

    @Operation(summary = "删除知识库")
    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteKnowledge(@Parameter(description = "知识库ID") @PathVariable String id) {
        Knowledge knowledge = getKnowledgeFromRequest(id);

        //删除
        knowledgeService.deleteKnowledgeById(knowledge.getId());

        return ApiResponse.success();
    }

    @Operation(summary = "批量删除知识库")
    @DeleteMapping
    public ApiResponse<Void> deleteKnowledgeByIds(@Parameter(description = "知识库ID列表") @RequestBody List<String> ids) {
        knowledgeService.deleteKnowledgeByIds(ids);
        return ApiResponse.success();
    }

    /**
     * 根据ID获取知识库
     *
     * @param id ID
     * @return 知识库
     * @throws Dify4jException 当知识库不存在时抛出异常
     */
    private Knowledge getKnowledgeFromRequest(String id) {
        Knowledge knowledge = knowledgeService.getKnowledgeById(id);
        if (knowledge == null) {
            throw new Dify4jIllegalStateException("知识库不存在");
        }
        return knowledge;
    }

    /**
     * 从请求中填充知识库信息
     *
     * @param knowledge 知识库信息
     * @param request   请求信息
     */
    private void populateKnowledgeFromRequest(Knowledge knowledge, KnowledgeRequest request) {

        // 设置知识库名称
        String name = request.getName();
        if (StringUtils.isNotBlank(name)) {
            knowledge.setName(name);
        }

        // 设置知识库描述
        String description = request.getDescription();
        if (StringUtils.isNotBlank(description)) {
            knowledge.setDescription(description);
        }
/*
        // 设置提供者
        String provider = request.getProvider();
        if (StringUtils.isNotBlank(provider)) {
            knowledge.setProvider(provider);
        }

        // 设置权限
        String permission = request.getPermission();
        if (StringUtils.isNotBlank(permission)) {
            knowledge.setPermission(permission);
        }

        // 设置数据源类型
        String dataSourceType = request.getDataSourceType();
        if (StringUtils.isNotBlank(dataSourceType)) {
            knowledge.setDataSourceType(dataSourceType);
        }

        // 设置索引技术
        String indexingTechnique = request.getIndexingTechnique();
        if (StringUtils.isNotBlank(indexingTechnique)) {
            knowledge.setIndexingTechnique(indexingTechnique);
        }

        // 设置索引结构
        String indexStruct = request.getIndexStruct();
        if (StringUtils.isNotBlank(indexStruct)) {
            knowledge.setIndexStruct(indexStruct);
        }

        // 设置嵌入模型
        String embeddingModel = request.getEmbeddingModel();
        if (StringUtils.isNotBlank(embeddingModel)) {
            knowledge.setEmbeddingModel(embeddingModel);
        }

        // 设置嵌入模型提供者
        String embeddingModelProvider = request.getEmbeddingModelProvider();
        if (StringUtils.isNotBlank(embeddingModelProvider)) {
            knowledge.setEmbeddingModelProvider(embeddingModelProvider);
        }

        // 设置集合绑定ID
        String collectionBindingId = request.getCollectionBindingId();
        if (StringUtils.isNotBlank(collectionBindingId)) {
            knowledge.setCollectionBindingId(collectionBindingId);
        }

        // 设置检索模型
        String retrievalModel = request.getRetrievalModel();
        if (StringUtils.isNotBlank(retrievalModel)) {
            knowledge.setRetrievalModel(retrievalModel);
        }

        // 设置是否启用内置字段
        Boolean builtInFieldEnabled = request.getBuiltInFieldEnabled();
        if (builtInFieldEnabled != null) {
            knowledge.setBuiltInFieldEnabled(builtInFieldEnabled);
        }*/
    }
}