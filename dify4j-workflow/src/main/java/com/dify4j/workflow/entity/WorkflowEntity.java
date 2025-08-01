package com.dify4j.workflow.entity;

import com.dify4j.api.workflow.Workflow;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 工作流实体类
 *
 * @author Cgy
 */
@Data
public class WorkflowEntity implements Workflow {

    /**
     * 主键ID
     */
    private String id;

    /**
     * 租户ID
     */
    private String tenantId;

    /**
     * 应用ID
     */
    private String appId;

    /**
     * 工作流类型
     */
    private String type;

    /**
     * 版本号
     */
    private String version;

    /**
     * 工作流图数据
     */
    private String graph;

    /**
     * 功能特性
     */
    private String features;

    /**
     * 创建人ID
     */
    private String createdBy;

    /**
     * 创建时间
     */
    private LocalDateTime createdAt;

    /**
     * 更新人ID
     */
    private String updatedBy;

    /**
     * 更新时间
     */
    private LocalDateTime updatedAt;

    /**
     * 环境变量
     */
    private String environmentVariables;

    /**
     * 会话变量
     */
    private String conversationVariables;

    /**
     * 标记名称
     */
    private String markedName;

    /**
     * 标记备注
     */
    private String markedComment;
}
