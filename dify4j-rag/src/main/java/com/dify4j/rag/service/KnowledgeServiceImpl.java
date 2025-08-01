package com.dify4j.rag.service;

import com.dify4j.api.common.Page;
import com.dify4j.api.constant.ApiKeyType;
import com.dify4j.api.idm.ApiKey;
import com.dify4j.api.idm.ApiKeyService;
import com.dify4j.api.idm.DefaultApiKey;
import com.dify4j.api.knowledge.Knowledge;
import com.dify4j.api.knowledge.KnowledgeService;
import com.dify4j.rag.mapper.KnowledgeMapper;
import com.dify4j.utils.PageUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 知识库服务实现类
 */
@Service
public class KnowledgeServiceImpl implements KnowledgeService {

    @Autowired
    private KnowledgeMapper knowledgeMapper;

    @Autowired
    private ApiKeyService apiKeyService;

    /**
     * 创建知识库
     *
     * @param knowledge 知识库实体
     * @return 创建的知识库ID
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String createKnowledge(Knowledge knowledge) {
        // 生成ID
        if (!StringUtils.hasText(knowledge.getId())) {
            knowledge.setId(UUID.randomUUID().toString().replace("-", ""));
        }

        // 设置默认值
        if (!StringUtils.hasText(knowledge.getProvider())) {
            knowledge.setProvider("vendor");
        }

        if (!StringUtils.hasText(knowledge.getPermission())) {
            knowledge.setPermission("only_me");
        }

        if (!StringUtils.hasText(knowledge.getEmbeddingModel())) {
            knowledge.setEmbeddingModel("text-embedding-ada-002");
        }

        if (!StringUtils.hasText(knowledge.getEmbeddingModelProvider())) {
            knowledge.setEmbeddingModelProvider("openai");
        }

        if (knowledge.getBuiltInFieldEnabled() == null) {
            knowledge.setBuiltInFieldEnabled(false);
        }

        // 设置创建和更新时间
        LocalDateTime now = LocalDateTime.now();
        knowledge.setCreatedAt(now);
        knowledge.setUpdatedAt(now);

        // 插入数据库
        knowledgeMapper.insert(knowledge);

        return knowledge.getId();
    }

    /**
     * 更新知识库
     *
     * @param knowledge 知识库实体
     * @return 是否更新成功
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateKnowledge(Knowledge knowledge) {
        // 设置更新时间
        knowledge.setUpdatedAt(LocalDateTime.now());

        knowledgeMapper.update(knowledge);
    }

    /**
     * 删除知识库
     *
     * @param id 知识库ID
     * @return 是否删除成功
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteKnowledgeById(String id) {
        knowledgeMapper.deleteById(id);
    }

    /**
     * 批量删除知识库
     *
     * @param ids 知识库ID列表
     * @return 是否删除成功
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteKnowledgeByIds(List<String> ids) {
        knowledgeMapper.deleteByIds(ids);
    }

    /**
     * 根据ID获取知识库
     *
     * @param id 知识库ID
     * @return 知识库实体
     */
    @Override
    public Knowledge getKnowledgeById(String id) {
        return knowledgeMapper.selectById(id);
    }


    /**
     * 分页查询知识库
     *
     * @param tenantId   租户ID
     * @param queryParam 查询条件
     * @param pageNum    分页参数
     * @param pageSize   每页数量
     * @return 分页结果
     */
    @Override
    public Page<Knowledge> getKnowledgeListByPage(String tenantId, Map<String, Object> queryParam, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        List<Knowledge> knowledges = knowledgeMapper.selectList(tenantId, queryParam);

        return PageUtil.convert(knowledges);
    }

    /**
     * 检查知识库名称是否存在
     *
     * @param name      知识库名称
     * @param tenantId  租户ID
     * @param excludeId 排除的知识库ID
     * @return 是否存在
     */
    @Override
    public boolean checkNameExists(String name, String tenantId, String excludeId) {
        return knowledgeMapper.checkNameExists(name, tenantId, excludeId) > 0;
    }

    @Override
    public List<ApiKey> getApiKeys(String currentTenantId) {
        return apiKeyService.getApiKeys(currentTenantId, ApiKeyType.KNOWLEDGE, null);
    }

    @Override
    public ApiKey createApiKey(String currentTenantId) {
        ApiKey apiKey = new DefaultApiKey();
        apiKey.setTenantId(currentTenantId);
        apiKey.setType(ApiKeyType.KNOWLEDGE);
        apiKey.setCreatedAt(LocalDateTime.now());
        return apiKeyService.createApiKey(apiKey);
    }

    @Override
    public void deleteApiKey(String currentTenantId, String apikeyId) {
        apiKeyService.deleteApiKeyById(apikeyId);
    }
}
