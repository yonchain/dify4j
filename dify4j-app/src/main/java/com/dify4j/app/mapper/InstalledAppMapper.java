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
package com.dify4j.app.mapper;

import com.dify4j.api.app.InstalledApp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * 已安装应用数据访问接口
 *
 * @author Craft
 * @since 2024-07-24
 */
@Mapper
public interface InstalledAppMapper {

    /**
     * 根据ID查询已安装应用
     *
     * @param id 已安装应用ID
     * @return 已安装应用
     */
    InstalledApp selectById(@Param("id") String id);

    /**
     * 分页查询已安装应用
     *
     * @param tenantId   租户ID
     * @param params 查询参数
     * @return 已安装应用列表
     */
    List<InstalledApp> selectList(@Param("tenantId") String tenantId, @Param("params") Map<String, Object> params);


    /**
     * 根据租户ID查询已安装应用
     *
     * @param tenantId 租户ID
     * @return 已安装应用列表
     */
    List<InstalledApp> selectByTenantId(@Param("tenantId") String tenantId);

    /**
     * 插入已安装应用
     *
     * @param installedApp 已安装应用
     * @return 影响行数
     */
    int insert(InstalledApp installedApp);

    /**
     * 更新已安装应用
     *
     * @param installedApp 已安装应用
     * @return 影响行数
     */
    int update(InstalledApp installedApp);

    /**
     * 更新已安装应用最后使用时间
     *
     * @param id         已安装应用ID
     * @param lastUsedAt 最后使用时间
     * @return 影响行数
     */
    int updateLastUsedAt(@Param("id") String id, @Param("lastUsedAt") LocalDateTime lastUsedAt);

    /**
     * 更新已安装应用置顶状态
     *
     * @param id       已安装应用ID
     * @param isPinned 是否置顶
     * @return 影响行数
     */
    int updatePinStatus(@Param("id") String id, @Param("isPinned") boolean isPinned);

    /**
     * 更新已安装应用位置
     *
     * @param id       已安装应用ID
     * @param position 位置
     * @return 影响行数
     */
    int updatePosition(@Param("id") String id, @Param("position") int position);

    /**
     * 根据ID删除已安装应用
     *
     * @param id 已安装应用ID
     * @return 影响行数
     */
    int deleteById(@Param("id") String id);

    /**
     * 批量删除已安装应用
     *
     * @param ids 已安装应用ID列表
     * @return 影响行数
     */
    int deleteByIds(@Param("ids") List<String> ids);

    /**
     * 根据应用ID删除已安装应用
     *
     * @param appId 应用ID
     * @return 影响行数
     */
    void deleteByAppId(String appId);
}
