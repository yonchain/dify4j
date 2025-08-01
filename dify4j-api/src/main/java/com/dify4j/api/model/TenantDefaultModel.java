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

package com.dify4j.api.model;

import java.time.LocalDateTime;

/**
 * 默认模型实体类
 *
 * @author Craft
 * @since 1.0.0
 */
public interface TenantDefaultModel {

    /**
     * 默认模型ID
     */
    String getId();

    /**
     * 设置默认模型ID
     * @param id 默认模型ID
     */
    void setId(String id);

    /**
     * 租户ID
     */
    String getTenantId();

    /**
     * 设置租户ID
     * @param tenantId 租户ID
     */
    void setTenantId(String tenantId);

    /**
     * 提供商名称
     */
    String getProviderName();

    /**
     * 设置提供商名称
     * @param providerName 提供商名称
     */
    void setProviderName(String providerName);

    /**
     * 模型名称
     */
    String getModelName();

    /**
     * 设置模型名称
     * @param modelName 模型名称
     */
    void setModelName(String modelName);

    /**
     * 模型类型
     */
    String getModelType();

    /**
     * 设置模型类型
     * @param modelType 模型类型
     */
    void setModelType(String modelType);

    /**
     * 创建时间
     */
    LocalDateTime getCreatedAt();

    /**
     * 设置创建时间
     * @param createdAt 创建时间
     */
    void setCreatedAt(LocalDateTime createdAt);

    /**
     * 更新时间
     */
    LocalDateTime getUpdatedAt();

    /**
     * 设置更新时间
     * @param updatedAt 更新时间
     */
    void setUpdatedAt(LocalDateTime updatedAt);
}
