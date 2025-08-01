package com.dify4j.rag.mapper;

import com.dify4j.api.knowledge.Knowledge;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 知识库Mapper接口
 */
@Mapper
public interface KnowledgeMapper {

    /**
     * 根据ID查询知识库
     *
     * @param id 知识库ID
     * @return 知识库实体
     */
    Knowledge selectById(@Param("id") String id);

    /**
     * 根据条件查询知识库列表
     *
     * @param tenantId 租户ID
     * @param params   查询条件
     * @return 知识库列表
     */
    List<Knowledge> selectList(@Param("tenantId") String tenantId, @Param("params") Map<String, Object> params);

    /**
     * 检查知识库名称是否存在
     *
     * @param name      知识库名称
     * @param tenantId  租户ID
     * @param excludeId 排除的知识库ID
     * @return 符合条件的记录数
     */
    int checkNameExists(@Param("name") String name, @Param("tenantId") String tenantId, @Param("excludeId") String excludeId);

    /**
     * 插入知识库记录
     *
     * @param knowledge 知识库实体
     * @return 影响的行数
     */
    int insert(Knowledge knowledge);

    /**
     * 更新知识库记录
     *
     * @param knowledge 知识库实体
     * @return 影响的行数
     */
    int update(Knowledge knowledge);

    /**
     * 根据ID删除知识库
     *
     * @param id 知识库ID
     * @return 影响的行数
     */
    int deleteById(@Param("id") String id);

    /**
     * 批量删除知识库
     *
     * @param ids 知识库ID列表
     * @return 影响的行数
     */
    int deleteByIds(@Param("ids") List<String> ids);

}
