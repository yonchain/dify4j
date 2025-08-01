package com.dify4j.rag.entity;

import com.dify4j.api.knowledge.Knowledge;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 知识库实体类
 */
@Data
public class KnowledgeEntity implements Knowledge {
    /**
     * 主键ID
     */
    private String id;

    /**
     * 租户ID
     */
    private String tenantId;

    /**
     * 知识库名称
     */
    private String name;

    /**
     * 知识库描述
     */
    private String description;

    /**
     * 提供者，默认为vendor
     */
    private String provider;

    /**
     * 权限，默认为only_me
     */
    private String permission;

    /**
     * 数据源类型
     */
    private String dataSourceType;

    /**
     * 索引技术
     */
    private String indexingTechnique;

    /**
     * 索引结构
     */
    private String indexStruct;

    /**
     * 创建者
     */
    private String createdBy;

    /**
     * 创建时间
     */
    private LocalDateTime createdAt;

    /**
     * 更新者
     */
    private String updatedBy;

    /**
     * 更新时间
     */
    private LocalDateTime updatedAt;

    /**
     * 嵌入模型，默认为text-embedding-ada-002
     */
    private String embeddingModel;

    /**
     * 嵌入模型提供者，默认为openai
     */
    private String embeddingModelProvider;

    /**
     * 集合绑定ID
     */
    private String collectionBindingId;

    /**
     * 检索模型
     */
    private String retrievalModel;

    /**
     * 内置字段启用标志，默认为false
     */
    private Boolean builtInFieldEnabled;

}
