package com.dify4j.idm.entity;

import com.dify4j.api.idm.ApiKey;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * API密钥实体
 *
 * @author Cgy
 */
@Data
public class ApiKeyEntity implements ApiKey {

    /**
     * API密钥ID
     */
    private String id;

    /**
     * 应用ID
     */
    private String appId;

    /**
     * 密钥类型
     */
    private String type;

    /**
     * 密钥令牌
     */
    private String token;

    /**
     * 最后使用时间
     */
    private LocalDateTime lastUsedAt;

    /**
     * 创建时间
     */
    private LocalDateTime createdAt;

    /**
     * 租户ID
     */
    private String tenantId;
}
