package com.dify4j.console.knowledge.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.UUID;

/**
 * 更新知识库请求
 */
@Data
@Schema(description = "更新知识库请求")
public class KnowledgeUpdateRequest {

    /**
     * 知识库名称
     */
    @NotBlank(message = "知识库名称不能为空")
    @Schema(description = "知识库名称", example = "示例知识库", required = true)
    private String name;

    /**
     * 描述
     */
    @Schema(description = "描述", example = "这是一个示例知识库")
    private String description;

    /**
     * 提供者
     */
    @Schema(description = "提供者", example = "vendor")
    private String provider;

    /**
     * 权限
     */
    @Schema(description = "权限", example = "only_me")
    private String permission;

    /**
     * 数据源类型
     */
    @Schema(description = "数据源类型", example = "file")
    private String dataSourceType;

    /**
     * 索引技术
     */
    @Schema(description = "索引技术", example = "faiss")
    private String indexingTechnique;

    /**
     * 索引结构
     */
    @Schema(description = "索引结构")
    private String indexStruct;

    /**
     * 嵌入模型
     */
    @Schema(description = "嵌入模型", example = "text-embedding-ada-002")
    private String embeddingModel;

    /**
     * 嵌入模型提供者
     */
    @Schema(description = "嵌入模型提供者", example = "openai")
    private String embeddingModelProvider;

    /**
     * 集合绑定ID
     */
    @Schema(description = "集合绑定ID")
    private UUID collectionBindingId;

    /**
     * 检索模型
     */
    @Schema(description = "检索模型")
    private String retrievalModel;

    /**
     * 是否启用内置字段
     */
    @Schema(description = "是否启用内置字段", example = "false")
    private Boolean builtInFieldEnabled;
}
