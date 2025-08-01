package com.dify4j.api.knowledge;

import java.time.LocalDateTime;

public class DefaultKnowledge implements Knowledge {

    /**
     * 知识库ID
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
     * 提供者
     */
    private String provider;

    /**
     * 权限
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
     * 嵌入模型
     */
    private String embeddingModel;

    /**
     * 嵌入模型提供者
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
     * 是否启用内置字段
     */
    private Boolean builtInFieldEnabled;

    /**
     * 获取知识库ID
     *
     * @return 知识库ID
     */
    public String getId() {
        return id;
    }

    /**
     * 设置知识库ID
     *
     * @param id 知识库ID
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
     * 获取知识库名称
     *
     * @return 知识库名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置知识库名称
     *
     * @param name 知识库名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取知识库描述
     *
     * @return 知识库描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置知识库描述
     *
     * @param description 知识库描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取提供者
     *
     * @return 提供者
     */
    public String getProvider() {
        return provider;
    }

    /**
     * 设置提供者
     *
     * @param provider 提供者
     */
    public void setProvider(String provider) {
        this.provider = provider;
    }

    /**
     * 获取权限
     *
     * @return 权限
     */
    public String getPermission() {
        return permission;
    }

    /**
     * 设置权限
     *
     * @param permission 权限
     */
    public void setPermission(String permission) {
        this.permission = permission;
    }

    /**
     * 获取数据源类型
     *
     * @return 数据源类型
     */
    public String getDataSourceType() {
        return dataSourceType;
    }

    /**
     * 设置数据源类型
     *
     * @param dataSourceType 数据源类型
     */
    public void setDataSourceType(String dataSourceType) {
        this.dataSourceType = dataSourceType;
    }

    /**
     * 获取索引技术
     *
     * @return 索引技术
     */
    public String getIndexingTechnique() {
        return indexingTechnique;
    }

    /**
     * 设置索引技术
     *
     * @param indexingTechnique 索引技术
     */
    public void setIndexingTechnique(String indexingTechnique) {
        this.indexingTechnique = indexingTechnique;
    }

    /**
     * 获取索引结构
     *
     * @return 索引结构
     */
    public String getIndexStruct() {
        return indexStruct;
    }

    /**
     * 设置索引结构
     *
     * @param indexStruct 索引结构
     */
    public void setIndexStruct(String indexStruct) {
        this.indexStruct = indexStruct;
    }

    /**
     * 获取创建人ID
     *
     * @return 创建人ID
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * 设置创建人ID
     *
     * @param createdBy 创建人ID
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
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
     * 获取更新人ID
     *
     * @return 更新人ID
     */
    public String getUpdatedBy() {
        return updatedBy;
    }

    /**
     * 设置更新人ID
     *
     * @param updatedBy 更新人ID
     */
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
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

    /**
     * 获取嵌入模型
     *
     * @return 嵌入模型
     */
    public String getEmbeddingModel() {
        return embeddingModel;
    }

    /**
     * 设置嵌入模型
     *
     * @param embeddingModel 嵌入模型
     */
    public void setEmbeddingModel(String embeddingModel) {
        this.embeddingModel = embeddingModel;
    }

    /**
     * 获取嵌入模型提供者
     *
     * @return 嵌入模型提供者
     */
    public String getEmbeddingModelProvider() {
        return embeddingModelProvider;
    }

    /**
     * 设置嵌入模型提供者
     *
     * @param embeddingModelProvider 嵌入模型提供者
     */
    public void setEmbeddingModelProvider(String embeddingModelProvider) {
        this.embeddingModelProvider = embeddingModelProvider;
    }

    /**
     * 获取集合绑定ID
     *
     * @return 集合绑定ID
     */
    public String getCollectionBindingId() {
        return collectionBindingId;
    }

    /**
     * 设置集合绑定ID
     *
     * @param collectionBindingId 集合绑定ID
     */
    public void setCollectionBindingId(String collectionBindingId) {
        this.collectionBindingId = collectionBindingId;
    }

    /**
     * 获取检索模型
     *
     * @return 检索模型
     */
    public String getRetrievalModel() {
        return retrievalModel;
    }

    /**
     * 设置检索模型
     *
     * @param retrievalModel 检索模型
     */
    public void setRetrievalModel(String retrievalModel) {
        this.retrievalModel = retrievalModel;
    }

    /**
     * 获取是否启用内置字段
     *
     * @return 是否启用内置字段
     */
    public Boolean getBuiltInFieldEnabled() {
        return builtInFieldEnabled;
    }

    /**
     * 设置是否启用内置字段
     *
     * @param builtInFieldEnabled 是否启用内置字段
     */
    public void setBuiltInFieldEnabled(Boolean builtInFieldEnabled) {
        this.builtInFieldEnabled = builtInFieldEnabled;
    }

}
