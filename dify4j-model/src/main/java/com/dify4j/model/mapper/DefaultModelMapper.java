package com.dify4j.model.mapper;

import com.dify4j.api.model.TenantDefaultModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 默认模型Mapper接口
 *
 * @author Craft
 * @since 1.0.0
 */
@Mapper
public interface DefaultModelMapper {


    /**
     * 根据租户ID查询默认模型
     *
     * @param tenantId 租户ID
     * @return 默认模型对象
     */
    TenantDefaultModel selectByTenantId(@Param("tenantId") String tenantId);

    /**
     * 查询默认模型列表
     *
     * @param tenantId   租户ID
     * @return 默认模型列表
     */
    List<TenantDefaultModel> selectListByTenantId(@Param("tenantId") String tenantId);

    /**
     * 插入默认模型
     *
     * @param TenantDefaultModel 默认模型对象
     * @return 影响行数
     */
    int insert(TenantDefaultModel TenantDefaultModel);

    /**
     * 更新默认模型
     *
     * @param TenantDefaultModel 默认模型对象
     * @return 影响行数
     */
    int update(TenantDefaultModel TenantDefaultModel);

    /**
     * 批量保存默认模型
     *
     * @param modelList 默认模型列表
     * @return 影响行数
     */
    int batchInsert(List<TenantDefaultModel> modelList);

    /**
     * 根据ID删除默认模型
     *
     * @param id 默认模型ID
     * @return 影响行数
     */
    int deleteById(@Param("id") String id);

    /**
     * 根据租户ID删除默认模型
     *
     * @param tenantId 租户ID
     * @return 影响行数
     */
    int deleteByTenantId(@Param("tenantId") String tenantId);

    /**
     * 根据租户ID和模型类型查询默认模型
     *
     * @param tenantId  租户ID
     * @param modelType 模型类型
     * @return 默认模型对象
     */
    TenantDefaultModel selectOne(@Param("tenantId") String tenantId,@Param("modelType") String modelType);
}
