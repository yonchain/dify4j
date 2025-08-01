package com.dify4j.api.workflow;

import com.dify4j.api.common.Page;

import java.util.Map;

/**
 * 工作流服务接口
 *
 * @author Cgy
 */
public interface WorkflowService {

    /**
     * 根据ID获取工作流
     *
     * @param id 工作流ID
     * @return 工作流对象
     */
    Workflow getWorkflowById(String id);

    /**
     * 分页查询工作流
     *
     * @param tenantId   租户ID
     * @param queryParam 查询参数
     * @param pageNum    页码
     * @param pageSize   每页大小
     * @return 分页结果
     */
    Page<Workflow> pageWorkflows(String tenantId, Map<String, Object> queryParam, int pageNum, int pageSize);

    /**
     * 创建工作流
     *
     * @param workflow 工作流对象
     * @return 工作流ID
     */
    String createWorkflow(Workflow workflow);

    /**
     * 更新工作流
     *
     * @param workflow 工作流对象
     */
    void updateWorkflow(Workflow workflow);

    /**
     * 删除工作流
     *
     * @param id 工作流ID
     */
    void deleteWorkflowById(String id);

    /**
     * 根据应用ID删除工作流
     *
     * @param appId 应用ID
     */
    void deleteWorkflowByAppId(String appId);
}
