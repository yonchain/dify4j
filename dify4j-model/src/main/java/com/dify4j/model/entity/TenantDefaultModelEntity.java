package com.dify4j.model.entity;

import com.dify4j.api.model.TenantDefaultModel;

import java.time.LocalDateTime;

/**
 * 默认模型实体类
 *
 * @author Craft
 * @since 1.0.0
 */
public class TenantDefaultModelEntity implements TenantDefaultModel {

    /**
     * 默认模型ID
     */
    private String id;

    /**
     * 租户ID
     */
    private String tenantId;

    /**
     * 提供商名称
     */
    private String providerName;

    /**
     * 模型名称
     */
    private String modelName;

    /**
     * 模型类型
     */
    private String modelType;

    /**
     * 创建时间
     */
    private LocalDateTime createdAt;

    /**
     * 更新时间
     */
    private LocalDateTime updatedAt;

    /**
     * 获取默认模型ID
     *
     * @return 默认模型ID
     */
    public String getId() {
        return id;
    }

    /**
     * 设置默认模型ID
     *
     * @param id 默认模型ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取租户ID
     *
     * @return 租户ID
     */
    public String getTenantId() {
        return tenantId;
    }

    /**
     * 设置租户ID
     *
     * @param tenantId 租户ID
     */
    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    /**
     * 获取提供商名称
     *
     * @return 提供商名称
     */
    public String getProviderName() {
        return providerName;
    }

    /**
     * 设置提供商名称
     *
     * @param providerName 提供商名称
     */
    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    /**
     * 获取模型名称
     *
     * @return 模型名称
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * 设置模型名称
     *
     * @param modelName 模型名称
     */
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    /**
     * 获取模型类型
     *
     * @return 模型类型
     */
    public String getModelType() {
        return modelType;
    }

    /**
     * 设置模型类型
     *
     * @param modelType 模型类型
     */
    public void setModelType(String modelType) {
        this.modelType = modelType;
    }

    /**
     * 获取创建时间
     *
     * @return 创建时间
     */
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * 设置创建时间
     *
     * @param createdAt 创建时间
     */
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * 获取更新时间
     *
     * @return 更新时间
     */
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    /**
     * 设置更新时间
     *
     * @param updatedAt 更新时间
     */
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }


}
