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

package com.dify4j.api.app;

import java.time.LocalDateTime;

/**
 * 已安装应用实体类
 *
 * @author Craft
 * @since 2024-07-24
 */
public interface InstalledApp {

    /**
     * 获取已安装应用ID
     *
     * @return 已安装应用ID
     */
    String getId();

    /**
     * 设置已安装应用ID
     *
     * @param id 已安装应用ID
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
     * 获取应用所有者租户ID
     *
     * @return 应用所有者租户ID
     */
    String getAppOwnerTenantId();

    /**
     * 设置应用所有者租户ID
     *
     * @param appOwnerTenantId 应用所有者租户ID
     */
    void setAppOwnerTenantId(String appOwnerTenantId);

    /**
     * 获取位置
     *
     * @return 位置
     */
    Integer getPosition();

    /**
     * 设置位置
     *
     * @param position 位置
     */
    void setPosition(Integer position);

    /**
     * 获取是否置顶
     *
     * @return 是否置顶
     */
    Boolean getIsPinned();

    /**
     * 设置是否置顶
     *
     * @param isPinned 是否置顶
     */
    void setIsPinned(Boolean isPinned);

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
}
