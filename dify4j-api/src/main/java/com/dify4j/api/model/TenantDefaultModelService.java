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

import com.dify4j.api.common.Page;

/**
 * 默认模型服务接口
 *
 * @author Craft
 * @since 1.0.0
 */
public interface TenantDefaultModelService {

    /**
     * 分页查询默认模型
     *
     * @param current      当前页码
     * @param size         每页记录数
     * @param tenantId     租户ID
     * @param providerName 提供商名称
     * @param modelName    模型名称
     * @param modelType    模型类型
     * @return 默认模型分页数据
     */
    Page<TenantDefaultModel> page(int current, int size, String tenantId, String providerName, String modelName, String modelType);

    /**
     * 创建默认模型
     *
     * @param tenantId     租户ID
     * @param providerName 提供商名称
     * @param modelName    模型名称
     * @param modelType    模型类型
     * @return 创建的默认模型
     */
    TenantDefaultModel create(String tenantId, String providerName, String modelName, String modelType);

    /**
     * 更新默认模型
     *
     * @param id           默认模型ID
     * @param tenantId     租户ID
     * @param providerName 提供商名称
     * @param modelName    模型名称
     * @param modelType    模型类型
     * @return 更新后的默认模型
     */
    TenantDefaultModel update(String id, String tenantId, String providerName, String modelName, String modelType);

    /**
     * 删除默认模型
     *
     * @param id       默认模型ID
     * @param tenantId 租户ID
     */
    void delete(String id, String tenantId);

    /**
     * 获取默认模型详情
     *
     * @param id       默认模型ID
     * @param tenantId 租户ID
     * @return 默认模型详情
     */
    TenantDefaultModel get(String id, String tenantId);
}
