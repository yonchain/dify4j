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

import java.util.List;
import java.util.Map;

/**
 * 模型服务接口
 *
 * @author chengy
 * @since 1.0.0
 */
public interface ModelService {

    /**
     * 根据ID获取模型
     *
     * @param id 模型ID
     * @return 模型DTO
     */
    Model getModelById(String id);

    /**
     * 获取模型列表
     *
     * @param tenantId     租户ID
     * @param providerName 提供商名称
     * @return 模型列表
     */
    List<Model> getModels(String tenantId, String providerName);

    /**
     * 分页获取模型列表
     *
     * @param tenantId   租户ID
     * @param queryParam 查询参数
     * @param pageNum    页码
     * @param pageSize   每页大小
     * @return 模型分页列表
     */
    Page<Model> pageModels(String tenantId, Map<String, Object> queryParam, int pageNum, int pageSize);

    /**
     * 创建模型
     *
     * @param model 模型信息
     * @return 创建的模型
     */
    String createModel(Model model);

    /**
     * 更新模型
     *
     * @param model 模型信息
     * @return 更新后的模型
     */
    void updateModel(Model model);

    /**
     * 删除模型
     *
     * @param id 模型ID
     * @return 是否删除成功
     */
    void deleteModel(String id);


    /**
     * 根据ID获取模型提供商
     *
     * @param providerId 模型提供商ID
     * @return 模型提供商实体
     */
    ModelProvider getProviderById(String providerId);

    /**
     * 分页查询模型提供商
     *
     * @param tenantId   租户ID
     * @param queryParam 查询参数
     * @param pageNum    页码
     * @param pageSize   每页条数
     * @return 分页结果
     */
    Page<ModelProvider> pageProviders(String tenantId, Map<String, Object> queryParam, int pageNum, int pageSize);

    /**
     * 获取模型提供商列表
     *
     * @param tenantId 租户ID
     * @return 模型提供商列表
     */
    List<ModelProvider> getProvidersByTenantId(String tenantId);

    /**
     * 创建模型提供商
     *
     * @param modelProvider 模型提供商
     * @return 创建的模型提供商
     */
    void createProvider(ModelProvider modelProvider);

    /**
     * 更新模型提供商
     *
     * @param modelProvider 模型提供商
     */
    void updateProvider(ModelProvider modelProvider);

    /**
     * 删除模型提供商
     *
     * @param providerId 模型提供商ID
     */
    void deleteProvider(String providerId);

    /**
     * 设置默认模型
     *
     * @param tenantId      租户ID
     * @param defaultModels 默认模型
     */
    void setDefaultModels(String tenantId, List<TenantDefaultModel> defaultModels);

    /**
     * 获取默认模型
     *
     * @param tenantId 租户ID
     * @return 默认模型
     */
    List<TenantDefaultModel> getDefaultModels(String tenantId);

    /**
     * 获取默认模型
     *
     * @param tenantId  租户ID
     * @param modelType 模型类型
     * @return 默认模型
     */
    TenantDefaultModel getDefaultModels(String tenantId, String modelType);
}
