package com.dify4j.console.knowledge.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * 知识库请求
 */
@Data
@Schema(description = "知识库请求")
public class KnowledgeRequest {

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
     * 权限
     */
    private String permission;

}
