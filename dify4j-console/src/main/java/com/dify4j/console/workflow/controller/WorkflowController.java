package com.dify4j.console.workflow.controller;

import com.dify4j.api.common.Page;
import com.dify4j.api.workflow.DefaultWorkflow;
import com.dify4j.api.workflow.Workflow;
import com.dify4j.api.workflow.WorkflowService;
import com.dify4j.console.BaseController;
import com.dify4j.console.workflow.request.WorkflowQueryRequest;
import com.dify4j.console.workflow.request.WorkflowRequest;
import com.dify4j.console.workflow.response.WorkflowResponse;
import com.dify4j.web.response.ApiResponse;
import com.dify4j.web.response.PageResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 工作流管理控制器
 *
 * @author Cgy
 * @since 1.0.0
 */
@Tag(name = "工作流管理", description = "工作流相关接口")
@RestController
@RequestMapping("/workflows")
public class WorkflowController extends BaseController {

    @Autowired
    private WorkflowService workflowService;

    /**
     * 获取工作流详情
     * <p>
     * 根据工作流ID查询工作流详细信息，如果工作流不存在则抛出异常
     * </p>
     *
     * @param id 工作流ID，不能为空
     * @return 工作流详细信息响应对象
     * @throws IllegalArgumentException 当指定ID的工作流不存在时抛出
     * @see WorkflowResponse
     */
    @Operation(summary = "获取工作流详情", description = "根据ID查询工作流")
    @GetMapping("/{id}")
    public WorkflowResponse getWorkflowById(@Parameter(description = "工作流ID") @PathVariable String id) {
        Workflow workflow = workflowService.getWorkflowById(id);
        if (workflow == null) {
            throw new IllegalArgumentException("工作流不存在");
        }
        return responseFactory.createWorkflowResponse(workflow);
    }

    /**
     * 分页查询工作流
     * <p>
     * 根据查询条件分页获取工作流列表，支持按关键字和类型过滤
     * 查询结果按照创建时间降序排列
     * </p>
     *
     * @param request 工作流查询请求参数，包含分页信息和过滤条件
     * @return 工作流分页数据响应对象
     * @see WorkflowQueryRequest
     * @see PageResponse
     */
    @Operation(summary = "分页查询工作流", description = "根据条件查询工作流列表，支持分页")
    @GetMapping
    public PageResponse<WorkflowResponse> pageWorkflow(@Valid WorkflowQueryRequest request) {
        String tenantId = this.getCurrentTenantId();

        Map<String, Object> queryParam = new HashMap<>();
        queryParam.put("keyword", request.getKeyword());
        queryParam.put("type", request.getType());

        Page<Workflow> workflows = workflowService.pageWorkflows(tenantId, queryParam,
                request.getPage(), request.getLimit());

        return responseFactory.createWorkflowPageResponse(workflows);
    }

    /**
     * 创建工作流
     * <p>
     * 根据请求参数创建新的工作流，自动生成工作流ID
     * 设置当前租户ID和创建者ID
     * </p>
     *
     * @param request 工作流创建请求参数，包含工作流的基本信息和配置
     * @return 创建成功的工作流详细信息响应对象
     * @see WorkflowRequest
     * @see WorkflowResponse
     */
    @Operation(summary = "创建工作流", description = "创建新的工作流")
    @PostMapping
    public WorkflowResponse createWorkflow(@Valid @RequestBody WorkflowRequest request) {
        Workflow workflow = new DefaultWorkflow();
        workflow.setId(UUID.randomUUID().toString());
        workflow.setTenantId(this.getCurrentTenantId());
        workflow.setCreatedBy(this.getCurrentUserId());

        //从请求中填充工作流信息
        populateWorkflowFromRequest(workflow, request);

        workflowService.createWorkflow(workflow);

        return responseFactory.createWorkflowResponse(workflowService.getWorkflowById(workflow.getId()));
    }

    /**
     * 更新工作流
     * <p>
     * 根据工作流ID更新工作流信息，如果工作流不存在则抛出异常
     * 自动设置更新者ID为当前用户ID
     * </p>
     *
     * @param id 要更新的工作流ID，不能为空
     * @param request 工作流更新请求参数，包含需要更新的字段
     * @return API响应对象，表示操作成功或失败
     * @throws IllegalArgumentException 当指定ID的工作流不存在时抛出
     * @see WorkflowRequest
     * @see ApiResponse
     */
    @Operation(summary = "更新工作流", description = "根据ID更新工作流信息")
    @PutMapping("/{id}")
    public ApiResponse<Void> updateWorkflow(@Parameter(description = "工作流ID") @PathVariable String id,
                                           @Valid @RequestBody WorkflowRequest request) {
        Workflow workflow = workflowService.getWorkflowById(id);
        if (workflow == null) {
            throw new IllegalArgumentException("工作流不存在");
        }

        workflow.setUpdatedBy(this.getCurrentUserId());

        //从请求中填充工作流信息
        populateWorkflowFromRequest(workflow, request);

        workflowService.updateWorkflow(workflow);

        return ApiResponse.success();
    }

    /**
     * 删除工作流
     * <p>
     * 根据工作流ID删除工作流，如果工作流不存在则抛出异常
     * </p>
     *
     * @param id 要删除的工作流ID，不能为空
     * @return API响应对象，表示操作成功或失败
     * @throws IllegalArgumentException 当指定ID的工作流不存在时抛出
     * @see ApiResponse
     */
    @Operation(summary = "删除工作流")
    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteWorkflow(@Parameter(description = "工作流ID") @PathVariable String id) {
        Workflow existingWorkflow = workflowService.getWorkflowById(id);
        if (existingWorkflow == null) {
            throw new IllegalArgumentException("工作流不存在");
        }

        workflowService.deleteWorkflowById(id);
        return ApiResponse.success();
    }

    /**
     * 从请求对象中填充工作流实体信息
     * <p>
     * 该方法将WorkflowRequest对象中的非空字段值复制到Workflow实体对象中，
     * 仅当请求字段值非空时才会更新对应的工作流字段。
     * </p>
     *
     * @param workflow 要填充的工作流实体对象，不能为null
     * @param request 包含工作流数据的请求对象，不能为null
     * @see Workflow
     * @see WorkflowRequest
     */
    private void populateWorkflowFromRequest(Workflow workflow, WorkflowRequest request) {
        if (StringUtils.isNotBlank(request.getType())) {
            // 设置工作流类型，如对话式、流程式等
            workflow.setType(request.getType());
        }
        if (StringUtils.isNotBlank(request.getVersion())) {
            // 设置工作流版本号，用于版本控制和兼容性管理
            workflow.setVersion(request.getVersion());
        }
        if (StringUtils.isNotBlank(request.getGraph())) {
            // 设置工作流图定义，包含节点和连接的JSON结构
            workflow.setGraph(request.getGraph());
        }
        if (StringUtils.isNotBlank(request.getFeatures())) {
            // 设置工作流特性配置，包含工作流行为和功能选项
            workflow.setFeatures(request.getFeatures());
        }
        if (StringUtils.isNotBlank(request.getEnvironmentVariables())) {
            // 设置环境变量配置，用于工作流执行环境的参数设置
            workflow.setEnvironmentVariables(request.getEnvironmentVariables());
        }
        if (StringUtils.isNotBlank(request.getConversationVariables())) {
            // 设置会话变量配置，用于工作流执行过程中的对话状态管理
            workflow.setConversationVariables(request.getConversationVariables());
        }
        if (StringUtils.isNotBlank(request.getMarkedName())) {
            // 设置工作流标记名称，用于标识和检索工作流
            workflow.setMarkedName(request.getMarkedName());
        }
        if (StringUtils.isNotBlank(request.getMarkedComment())) {
            // 设置工作流标记备注，用于描述工作流的用途和特点
            workflow.setMarkedComment(request.getMarkedComment());
        }
    }
}
