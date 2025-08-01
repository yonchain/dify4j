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

package com.dify4j.api.idm;

import java.time.LocalDateTime;

/**
 * API密钥接口
 *
 * @author Cgy
 */
public interface ApiKey {

    /**
     * 获取API密钥ID
     *
     * @return API密钥ID
     */
    String getId();

    /**
     * 设置API密钥ID
     *
     * @param id API密钥ID
     */
    void setId(String id);

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
     * 获取密钥类型
     *
     * @return 密钥类型
     */
    String getType();

    /**
     * 设置密钥类型
     *
     * @param type 密钥类型
     */
    void setType(String type);

    /**
     * 获取密钥令牌
     *
     * @return 密钥令牌
     */
    String getToken();

    /**
     * 设置密钥令牌
     *
     * @param token 密钥令牌
     */
    void setToken(String token);

    /**
     * 获取最后使用时间
     *
     * @return 最后使用时间
     */
    LocalDateTime getLastUsedAt();

    /**
     * 设置最后使用时间
     *
     * @param lastUsedAt 最后使用时间
     */
    void setLastUsedAt(LocalDateTime lastUsedAt);

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
}
