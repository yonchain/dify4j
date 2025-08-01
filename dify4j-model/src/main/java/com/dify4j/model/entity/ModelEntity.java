package com.dify4j.model.entity;

import com.dify4j.api.model.Model;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 模型实体类
 *
 * @author chengy
 * @since 1.0.0
 */
@Data
public class ModelEntity implements Model {
    /**
     * 主键ID
     */
    private String id;

    /**
     * 租户ID
     */
    private String tenantId;

    /**
     * 提供商名称
     */
    private String providerName;

    /**
     * 模型名称
     */
    private String modelName;

    /**
     * 模型类型
     */
    private String modelType;

    /**
     * 加密配置
     */
    private String encryptedConfig;

    /**
     * 是否有效
     */
    private Boolean isValid;

    /**
     * 创建时间
     */
    private LocalDateTime createdAt;

    /**
     * 更新时间
     */
    private LocalDateTime updatedAt;

}
