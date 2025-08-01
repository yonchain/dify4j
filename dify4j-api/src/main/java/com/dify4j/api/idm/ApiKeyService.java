package com.dify4j.api.idm;


import java.util.List;
import java.util.Map;

/**
 * API密钥服务接口
 *
 * @author Cgy
 */
public interface ApiKeyService {

    /**
     * 查询API密钥列表
     *
     * @param tenantId   租户ID
     * @param type       密钥类型
     * @param queryParam 查询参数
     * @return API密钥列表
     */
    List<ApiKey> getApiKeys(String tenantId, String type, Map<String, Object> queryParam);

    /**
     * 创建API密钥
     *
     * @param apiKey API密钥信息
     * @return 创建的API密钥
     */
    ApiKey createApiKey(ApiKey apiKey);

    /**
     * 删除API密钥
     *
     * @param id API密钥ID
     */
    void deleteApiKeyById(String id);

}
