package com.dify4j.api.knowledge;


import com.dify4j.api.common.Page;
import com.dify4j.api.idm.ApiKey;

import java.util.List;
import java.util.Map;

/**
 * 知识库服务接口
 */
public interface KnowledgeService {

    /**
     * 根据ID获取知识库
     *
     * @param id 知识库ID
     * @return 知识库信息
     */
    Knowledge getKnowledgeById(String id);

    /**
     * 分页查询知识库
     *
     * @param tenantId   租户ID
     * @param queryParam 查询条件
     * @param pageNum    分页参数
     * @param pageSize   每页数量
     * @return 分页结果
     */
    Page<Knowledge> getKnowledgeListByPage(String tenantId, Map<String, Object> queryParam, int pageNum, int pageSize);

    /**
     * 创建知识库
     *
     * @param knowledge 知识库信息
     * @return 创建的知识库id
     */
    String createKnowledge(Knowledge knowledge);

    /**
     * 更新知识库
     *
     * @param knowledge 知识库信息
     */
    void updateKnowledge(Knowledge knowledge);

    /**
     * 根据ID删除知识库
     *
     * @param id 知识库ID
     */
    void deleteKnowledgeById(String id);

    /**
     * 批量删除知识库
     *
     * @param ids 知识库ID列表
     */
    void deleteKnowledgeByIds(List<String> ids);

    /**
     * 检查知识库名称是否存在
     *
     * @param name      知识库名称
     * @param tenantId  租户ID
     * @param excludeId 排除的知识库ID
     * @return 是否存在
     */
    boolean checkNameExists(String name, String tenantId, String excludeId);

    /**
     * 获取租户下的所有知识库API密钥
     *
     * @param currentTenantId 当前租户ID
     * @return API密钥列表
     */
    List<ApiKey> getApiKeys(String currentTenantId);

    /**
     * 创建租户下的知识库API密钥
     *
     * @param currentTenantId 当前租户ID
     * @return API密钥
     */
    ApiKey createApiKey(String currentTenantId);

    /**
     * 删除租户下的知识库API密钥
     *
     * @param currentTenantId 当前租户ID
     * @param apikeyId        API密钥ID
     */
    void deleteApiKey(String currentTenantId, String apikeyId);
}
