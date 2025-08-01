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
import com.dify4j.api.idm.ApiKey;
import com.dify4j.api.idm.Role;

import java.util.List;
import java.util.Map;


/**
 * 应用服务接口
 *
 * @author Cgy
 * @since 1.0.0
 */
public interface AppService {

    /**
     * 通过ID查询应用
     *
     * @param id 应用ID
     * @return 应用信息
     */
    App getAppById(String id);

    /**
     * 分页查询应用列表
     *
     * @param tenantId   租户ID
     * @param queryParam 查询参数
     * @param pageNum    页码
     * @param pageSize   每页大小
     * @return 分页应用列表
     */
    Page<App> getAppsByPage(String tenantId, Map<String, Object> queryParam, int pageNum, int pageSize);

    /**
     * 新增应用
     *
     * @param app 应用信息
     */
    void createApp(App app);

    /**
     * 新增应用
     *
     * @param app     应用信息
     * @param roleIds 角色ID列表
     */
    void createApp(App app, List<String> roleIds);

    /**
     * 修改应用
     *
     * @param app 应用信息
     */
    void updateApp(App app);

    /**
     * 修改应用
     *
     * @param app     应用信息
     * @param roleIds 角色ID列表
     */
    void updateApp(App app, List<String> roleIds);

    /**
     * 通过ID删除应用
     *
     * @param id 应用ID
     */
    void deleteAppById(String id);

    /**
     * 获取应用API密钥列表
     *
     * @param appId 应用ID
     * @return 应用API密钥列表
     */
    List<ApiKey> getAppApiKeys(String appId);

    /**
     * 创建应用API密钥
     *
     * @param tenantId 租户id
     * @param appId    应用id
     * @return 创建的API密钥
     */
    ApiKey createAppApiKey(String tenantId, String appId);

    /**
     * 删除应用API密钥
     *
     * @param appId    应用id
     * @param apikeyId API密钥id
     */
    void deleteAppApiKey(String appId, String apikeyId);

    /**
     * 获取应用关联的角色
     *
     * @param appId 应用ID
     * @return 角色列表
     */
    List<Role> getAppRoles(String appId);

    /**
     * 批量保存应用角色关联
     *
     * @param appId   应用ID
     * @param roleIds 角色ID列表
     */
    void saveAppRoles(String appId, List<String> roleIds);

}
