package com.dify4j.console.workflow.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * 工作流创建/更新请求
 */
@Data
@Schema(description = "工作流创建/更新请求")
public class WorkflowRequest {

    /**
     * 工作流类型
     */
    @Schema(description = "工作流类型")
    @NotBlank(message = "工作流类型不能为空")
    private String type;

    /**
     * 工作流版本号
     */
    @Schema(description = "工作流版本")
    @NotBlank(message = "工作流版本不能为空")
    private String version;

    /**
     * 工作流图定义，JSON格式
     */
    @Schema(description = "工作流图定义(JSON)")
    @NotBlank(message = "工作流图定义不能为空")
    private String graph;

    /**
     * 工作流特性配置，JSON格式
     */
    @Schema(description = "工作流特性配置(JSON)")
    @NotBlank(message = "工作流特性配置不能为空")
    private String features;

    /**
     * 环境变量配置，JSON格式
     */
    @Schema(description = "环境变量配置(JSON)")
    @NotBlank(message = "环境变量配置不能为空")
    private String environmentVariables;

    /**
     * 会话变量配置，JSON格式
     */
    @Schema(description = "会话变量配置(JSON)")
    @NotBlank(message = "会话变量配置不能为空")
    private String conversationVariables;

    /**
     * 工作流标记名称
     */
    @Schema(description = "标记名称")
    @NotBlank(message = "标记名称不能为空")
    @Size(max = 100, message = "标记名称长度不能超过100个字符")
    private String markedName;

    /**
     * 工作流标记备注
     */
    @Schema(description = "标记备注")
    @Size(max = 500, message = "标记备注长度不能超过500个字符")
    private String markedComment;
}
