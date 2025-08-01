package com.dify4j.idm.service;

import com.dify4j.api.idm.ApiKey;
import com.dify4j.api.idm.ApiKeyService;
import com.dify4j.idm.mapper.ApiKeyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * API密钥服务实现类
 *
 * @author Cgy
 */
@Service
public class ApiKeyServiceImpl implements ApiKeyService {

    @Autowired
    private ApiKeyMapper apiKeyMapper;

    @Override
    public List<ApiKey> getApiKeys(String tenantId, String type, Map<String, Object> queryParam) {
        return apiKeyMapper.selectList(tenantId, type, queryParam);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ApiKey createApiKey(ApiKey apiKey) {
        String token = apiKey.getToken();
        if (token == null || token.isEmpty()) {
            apiKey.setToken(apiKey.getType() + "-" + UUID.randomUUID());
        }
        if (apiKey.getId() == null) {
            apiKey.setId(UUID.randomUUID().toString());
        }
        if (apiKey.getCreatedAt() == null) {
            apiKey.setCreatedAt(LocalDateTime.now());
        }
        apiKeyMapper.insert(apiKey);
        return apiKey;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteApiKeyById(String id) {
        apiKeyMapper.deleteById(id);
    }

}
