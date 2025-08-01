package com.dify4j.workflow.service;

import com.dify4j.api.common.Page;
import com.dify4j.api.workflow.Workflow;
import com.dify4j.api.workflow.WorkflowService;
import com.dify4j.utils.PageUtil;
import com.dify4j.workflow.mapper.WorkflowMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;

/**
 * 工作流服务实现类
 *
 * @author Cgy
 */
@Service
public class WorkflowServiceImpl implements WorkflowService {

    @Autowired
    private WorkflowMapper workflowMapper;

    @Override
    public Workflow getWorkflowById(String id) {
        return workflowMapper.selectById(id);
    }

    @Override
    public Page<Workflow> pageWorkflows(String tenantId, Map<String, Object> queryParam, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        
        //分页查询
        List<Workflow> workflows = workflowMapper.selectList(tenantId, queryParam);

        return PageUtil.convert(workflows);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String createWorkflow(Workflow workflow) {
        if (workflow.getId() == null) {
            workflow.setId(UUID.randomUUID().toString());
        }

        LocalDateTime now = LocalDateTime.now();
        if (workflow.getCreatedAt() == null) {
            workflow.setCreatedAt(now);
        }
        if (workflow.getUpdatedAt() == null) {
            workflow.setUpdatedAt(now);
        }

        workflowMapper.insert(workflow);

        return workflow.getId();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateWorkflow(Workflow workflow) {
        workflow.setUpdatedAt(LocalDateTime.now());
        workflowMapper.updateById(workflow);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteWorkflowById(String id) {
        workflowMapper.deleteById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteWorkflowByAppId(String appId) {
        workflowMapper.deleteByAppId(appId);
    }
}
