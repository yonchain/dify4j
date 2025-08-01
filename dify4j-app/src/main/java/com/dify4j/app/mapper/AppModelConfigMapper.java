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

import com.dify4j.app.entity.AppModelConfigEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 应用模型配置Mapper接口
 * <p>
 * 提供应用模型配置相关的数据库操作方法，包括查询、新增、修改和删除
 * </p>
 *
 * @author Craft
 * @since 1.0.0
 */
@Mapper
public interface AppModelConfigMapper {

    /**
     * 根据ID查询应用模型配置
     *
     * @param id 应用模型配置ID
     * @return 应用模型配置实体
     */
    AppModelConfigEntity selectById(@Param("id") String id);

    /**
     * 根据应用ID查询应用模型配置
     *
     * @param appId 应用ID
     * @return 应用模型配置实体
     */
    AppModelConfigEntity selectByAppId(@Param("appId") String appId);

    /**
     * 查询应用模型配置列表
     * <p>
     * 支持根据应用ID、提供商、模型ID和提示类型进行筛选
     * </p>
     *
     * @param appId      应用ID，可选
     * @param provider   提供商，可选
     * @param modelId    模型ID，可选
     * @param promptType 提示类型，可选
     * @return 应用模型配置列表
     */
    List<AppModelConfigEntity> selectList(@Param("appId") String appId,
                                          @Param("provider") String provider,
                                          @Param("modelId") String modelId,
                                          @Param("promptType") String promptType);

    /**
     * 插入应用模型配置
     *
     * @param entity 应用模型配置实体
     * @return 影响的行数
     */
    int insert(AppModelConfigEntity entity);

    /**
     * 根据ID更新应用模型配置
     *
     * @param entity 应用模型配置实体
     * @return 影响的行数
     */
    int updateById(AppModelConfigEntity entity);

    /**
     * 根据ID删除应用模型配置
     *
     * @param id 应用模型配置ID
     * @return 影响的行数
     */
    int deleteById(@Param("id") String id);

    /**
     * 根据应用ID删除应用模型配置
     *
     * @param appId 应用ID
     * @return 影响的行数
     */
    int deleteByAppId(@Param("appId") String appId);

    /**
     * 批量删除应用模型配置
     *
     * @param ids ID列表
     * @return 影响的行数
     */
    int deleteBatchIds(@Param("list") List<String> ids);
}
