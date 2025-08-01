package com.dify4j.console.workflow.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * 工作流响应
 */
@Data
@Schema(description = "工作流响应")
public class WorkflowResponse {

    /**
     * 工作流ID
     */
    @Schema(description = "工作流ID")
    private String id;

    /**
     * 租户ID
     */
    @Schema(description = "租户ID")
    private String tenantId;

    /**
     * 应用ID
     */
    @Schema(description = "应用ID")
    private String appId;

    /**
     * 工作流类型
     */
    @Schema(description = "工作流类型")
    private String type;

    /**
     * 工作流版本
     */
    @Schema(description = "工作流版本")
    private String version;

    /**
     * 工作流图定义，JSON格式
     */
    @Schema(description = "工作流图定义(JSON)")
    private String graph;

    /**
     * 工作流特性配置，JSON格式
     */
    @Schema(description = "工作流特性配置(JSON)")
    private String features;

    /**
     * 创建人ID
     */
    @Schema(description = "创建人ID")
    private String createdBy;

    /**
     * 创建时间
     */
    @Schema(description = "创建时间")
    private LocalDateTime createdAt;

    /**
     * 更新人ID
     */
    @Schema(description = "更新人ID")
    private String updatedBy;

    /**
     * 更新时间
     */
    @Schema(description = "更新时间")
    private LocalDateTime updatedAt;

    /**
     * 环境变量配置，JSON格式
     */
    @Schema(description = "环境变量配置(JSON)")
    private String environmentVariables;

    /**
     * 会话变量配置，JSON格式
     */
    @Schema(description = "会话变量配置(JSON)")
    private String conversationVariables;

    /**
     * 标记名称
     */
    @Schema(description = "标记名称")
    private String markedName;

    /**
     * 标记备注
     */
    @Schema(description = "标记备注")
    private String markedComment;
}
