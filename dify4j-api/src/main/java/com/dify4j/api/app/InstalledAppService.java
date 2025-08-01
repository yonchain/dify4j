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

import com.dify4j.api.common.Page;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 已安装应用服务接口
 *
 * @author Craft
 * @since 2024-07-24
 */
public interface InstalledAppService {

    /**
     * 根据ID获取已安装应用
     *
     * @param id 已安装应用ID
     * @return 已安装应用
     */
    InstalledApp getInstalledAppById(String id);

    /**
     * 分页获取已安装应用列表
     *
     * @param tenantId   租户ID
     * @param queryParam 查询参数
     * @param pageNum       页码
     * @param pageSize      每页数量
     * @return 分页已安装应用列表
     */
    Page<InstalledApp> getInstalledAppsByPage(String tenantId, Map<String, Object> queryParam, int pageNum, int pageSize);

    /**
     * 获取租户的所有已安装应用
     *
     * @param tenantId 租户ID
     * @return 已安装应用列表
     */
    List<InstalledApp> getInstalledAppsByTenantId(String tenantId);

    /**
     * 创建已安装应用
     *
     * @param installedApp 已安装应用
     * @return 创建的已安装应用
     */
    InstalledApp createInstalledApp(InstalledApp installedApp);

    /**
     * 更新已安装应用
     *
     * @param installedApp 已安装应用
     * @return 更新后的已安装应用
     */
    InstalledApp updateInstalledApp(InstalledApp installedApp);

    /**
     * 根据ID删除已安装应用
     *
     * @param id 已安装应用ID
     */
    void deleteInstalledAppById(String id);

    /**
     * 批量删除已安装应用
     *
     * @param ids 已安装应用ID列表
     */
    void deleteInstalledAppByIds(List<String> ids);

    /**
     * 更新应用最后使用时间
     *
     * @param id 已安装应用ID
     */
    void updateLastUsedAt(String id);

    /**
     * 更新应用置顶状态
     *
     * @param id       已安装应用ID
     * @param isPinned 是否置顶
     * @return 更新后的已安装应用
     */
    InstalledApp updatePinStatus(String id, boolean isPinned);

    /**
     * 更新应用位置
     *
     * @param id       已安装应用ID
     * @param position 位置
     * @return 更新后的已安装应用
     */
    InstalledApp updatePosition(String id, int position);
}
