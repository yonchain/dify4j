package com.dify4j.api.workflow;

import java.time.LocalDateTime;

/**
 * 工作流模型类
 *
 * @author Cgy
 */
public class DefaultWorkflow implements Workflow {

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

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getGraph() {
        return graph;
    }

    public void setGraph(String graph) {
        this.graph = graph;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getEnvironmentVariables() {
        return environmentVariables;
    }

    public void setEnvironmentVariables(String environmentVariables) {
        this.environmentVariables = environmentVariables;
    }

    public String getConversationVariables() {
        return conversationVariables;
    }

    public void setConversationVariables(String conversationVariables) {
        this.conversationVariables = conversationVariables;
    }

    public String getMarkedName() {
        return markedName;
    }

    public void setMarkedName(String markedName) {
        this.markedName = markedName;
    }

    public String getMarkedComment() {
        return markedComment;
    }

    public void setMarkedComment(String markedComment) {
        this.markedComment = markedComment;
    }
}
