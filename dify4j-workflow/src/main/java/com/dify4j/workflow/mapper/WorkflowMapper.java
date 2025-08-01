package com.dify4j.workflow.mapper;

import com.dify4j.api.workflow.Workflow;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 工作流数据访问接口
 *
 * @author Cgy
 */
@Mapper
public interface WorkflowMapper {

    /**
     * 根据ID查询工作流
     *
     * @param id 工作流ID
     * @return 工作流实体
     */
    Workflow selectById(@Param("id") String id);

    /**
     * 查询工作流列表
     *
     * @param tenantId 租户ID
     * @param params   查询参数
     * @return 工作流列表
     */
    List<Workflow> selectList(@Param("tenantId") String tenantId, @Param("params") Map<String, Object> params);

    /**
     * 插入工作流记录
     *
     * @param workflow 工作流实体
     * @return 影响行数
     */
    int insert(Workflow workflow);

    /**
     * 根据ID更新工作流
     *
     * @param workflow 工作流实体
     * @return 影响行数
     */
    int updateById(Workflow workflow);

    /**
     * 根据ID删除工作流
     *
     * @param id 工作流ID
     * @return 影响行数
     */
    int deleteById(@Param("id") String id);

    /**
     * 根据应用ID删除工作流
     *
     * @param appId 应用ID
     * @return 影响行数
     */
    int deleteByAppId(@Param("appId") String appId);
}
