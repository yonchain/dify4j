/*
 * Copyright 2025-2028 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.dify4j.api.knowledge;


import java.time.LocalDateTime;

/**
 * 知识库接口
 */
public interface Knowledge {

    /**
     * 获取知识库ID
     *
     * @return 知识库ID
     */
    String getId();

    /**
     * 设置知识库ID
     *
     * @param id 知识库ID
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
     * 获取知识库名称
     *
     * @return 知识库名称
     */
    String getName();

    /**
     * 设置知识库名称
     *
     * @param name 知识库名称
     */
    void setName(String name);

    /**
     * 获取知识库描述
     *
     * @return 知识库描述
     */
    String getDescription();

    /**
     * 设置知识库描述
     *
     * @param description 知识库描述
     */
    void setDescription(String description);

    /**
     * 获取提供者
     *
     * @return 提供者
     */
    String getProvider();

    /**
     * 设置提供者
     *
     * @param provider 提供者
     */
    void setProvider(String provider);

    /**
     * 获取权限
     *
     * @return 权限
     */
    String getPermission();

    /**
     * 设置权限
     *
     * @param permission 权限
     */
    void setPermission(String permission);

    /**
     * 获取数据源类型
     *
     * @return 数据源类型
     */
    String getDataSourceType();

    /**
     * 设置数据源类型
     *
     * @param dataSourceType 数据源类型
     */
    void setDataSourceType(String dataSourceType);

    /**
     * 获取索引技术
     *
     * @return 索引技术
     */
    String getIndexingTechnique();

    /**
     * 设置索引技术
     *
     * @param indexingTechnique 索引技术
     */
    void setIndexingTechnique(String indexingTechnique);

    /**
     * 获取索引结构
     *
     * @return 索引结构
     */
    String getIndexStruct();

    /**
     * 设置索引结构
     *
     * @param indexStruct 索引结构
     */
    void setIndexStruct(String indexStruct);

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
     * 获取嵌入模型
     *
     * @return 嵌入模型
     */
    String getEmbeddingModel();

    /**
     * 设置嵌入模型
     *
     * @param embeddingModel 嵌入模型
     */
    void setEmbeddingModel(String embeddingModel);

    /**
     * 获取嵌入模型提供者
     *
     * @return 嵌入模型提供者
     */
    String getEmbeddingModelProvider();

    /**
     * 设置嵌入模型提供者
     *
     * @param embeddingModelProvider 嵌入模型提供者
     */
    void setEmbeddingModelProvider(String embeddingModelProvider);

    /**
     * 获取集合绑定ID
     *
     * @return 集合绑定ID
     */
    String getCollectionBindingId();

    /**
     * 设置集合绑定ID
     *
     * @param collectionBindingId 集合绑定ID
     */
    void setCollectionBindingId(String collectionBindingId);

    /**
     * 获取检索模型
     *
     * @return 检索模型
     */
    String getRetrievalModel();

    /**
     * 设置检索模型
     *
     * @param retrievalModel 检索模型
     */
    void setRetrievalModel(String retrievalModel);

    /**
     * 获取是否启用内置字段
     *
     * @return 是否启用内置字段
     */
    Boolean getBuiltInFieldEnabled();

    /**
     * 设置是否启用内置字段
     *
     * @param builtInFieldEnabled 是否启用内置字段
     */
    void setBuiltInFieldEnabled(Boolean builtInFieldEnabled);


}
