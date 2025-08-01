/*
 * Copyright (c) 2024 Dify4j
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.dify4j.app.entity;

import com.dify4j.api.app.InstalledApp;

import java.time.LocalDateTime;

/**
 * 已安装应用实体类
 *
 * @author Craft
 * @since 2024-07-24
 */
public class InstalledAppEntity implements InstalledApp {

    /**
     * 已安装应用ID
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
     * 应用所有者租户ID
     */
    private String appOwnerTenantId;

    /**
     * 位置
     */
    private Integer position;

    /**
     * 是否置顶
     */
    private Boolean isPinned;

    /**
     * 最后使用时间
     */
    private LocalDateTime lastUsedAt;

    /**
     * 创建时间
     */
    private LocalDateTime createdAt;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getTenantId() {
        return tenantId;
    }

    @Override
    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    @Override
    public String getAppId() {
        return appId;
    }

    @Override
    public void setAppId(String appId) {
        this.appId = appId;
    }

    @Override
    public String getAppOwnerTenantId() {
        return appOwnerTenantId;
    }

    @Override
    public void setAppOwnerTenantId(String appOwnerTenantId) {
        this.appOwnerTenantId = appOwnerTenantId;
    }

    @Override
    public Integer getPosition() {
        return position;
    }

    @Override
    public void setPosition(Integer position) {
        this.position = position;
    }

    @Override
    public Boolean getIsPinned() {
        return isPinned;
    }

    @Override
    public void setIsPinned(Boolean isPinned) {
        this.isPinned = isPinned;
    }

    @Override
    public LocalDateTime getLastUsedAt() {
        return lastUsedAt;
    }

    @Override
    public void setLastUsedAt(LocalDateTime lastUsedAt) {
        this.lastUsedAt = lastUsedAt;
    }

    @Override
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
