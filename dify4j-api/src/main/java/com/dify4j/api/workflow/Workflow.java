package com.dify4j.api.workflow;

import java.time.LocalDateTime;

/**
 * 工作流模型类
 *
 * @author Cgy
 */
public interface Workflow {

    /**
     * 获取主键ID
     *
     * @return 主键ID
     */
    String getId();

    /**
     * 设置主键ID
     *
     * @param id 主键ID
     */
    void setId(String id);

    /**
     * 获取租户ID
     *
     * @return 租户ID
     */
    String getTenantId();

    /**
     * 设置租户ID
     *
     * @param tenantId 租户ID
     */
    void setTenantId(String tenantId);

    /**
     * 获取应用ID
     *
     * @return 应用ID
     */
    String getAppId();

    /**
     * 设置应用ID
     *
     * @param appId 应用ID
     */
    void setAppId(String appId);

    /**
     * 获取工作流类型
     *
     * @return 工作流类型
     */
    String getType();

    /**
     * 设置工作流类型
     *
     * @param type 工作流类型
     */
    void setType(String type);

    /**
     * 获取版本号
     *
     * @return 版本号
     */
    String getVersion();

    /**
     * 设置版本号
     *
     * @param version 版本号
     */
    void setVersion(String version);

    /**
     * 获取工作流图数据
     *
     * @return 工作流图数据
     */
    String getGraph();

    /**
     * 设置工作流图数据
     *
     * @param graph 工作流图数据
     */
    void setGraph(String graph);

    /**
     * 获取功能特性
     *
     * @return 功能特性
     */
    String getFeatures();

    /**
     * 设置功能特性
     *
     * @param features 功能特性
     */
    void setFeatures(String features);

    /**
     * 获取创建人ID
     *
     * @return 创建人ID
     */
    String getCreatedBy();

    /**
     * 设置创建人ID
     *
     * @param createdBy 创建人ID
     */
    void setCreatedBy(String createdBy);

    /**
     * 获取创建时间
     *
     * @return 创建时间
     */
    LocalDateTime getCreatedAt();

    /**
     * 设置创建时间
     *
     * @param createdAt 创建时间
     */
    void setCreatedAt(LocalDateTime createdAt);

    /**
     * 获取更新人ID
     *
     * @return 更新人ID
     */
    String getUpdatedBy();

    /**
     * 设置更新人ID
     *
     * @param updatedBy 更新人ID
     */
    void setUpdatedBy(String updatedBy);

    /**
     * 获取更新时间
     *
     * @return 更新时间
     */
    LocalDateTime getUpdatedAt();

    /**
     * 设置更新时间
     *
     * @param updatedAt 更新时间
     */
    void setUpdatedAt(LocalDateTime updatedAt);

    /**
     * 获取环境变量
     *
     * @return 环境变量
     */
    String getEnvironmentVariables();

    /**
     * 设置环境变量
     *
     * @param environmentVariables 环境变量
     */
    void setEnvironmentVariables(String environmentVariables);

    /**
     * 获取会话变量
     *
     * @return 会话变量
     */
    String getConversationVariables();

    /**
     * 设置会话变量
     *
     * @param conversationVariables 会话变量
     */
    void setConversationVariables(String conversationVariables);

    /**
     * 获取标记名称
     *
     * @return 标记名称
     */
    String getMarkedName();

    /**
     * 设置标记名称
     *
     * @param markedName 标记名称
     */
    void setMarkedName(String markedName);

    /**
     * 获取标记备注
     *
     * @return 标记备注
     */
    String getMarkedComment();

    /**
     * 设置标记备注
     *
     * @param markedComment 标记备注
     */
    void setMarkedComment(String markedComment);
}
