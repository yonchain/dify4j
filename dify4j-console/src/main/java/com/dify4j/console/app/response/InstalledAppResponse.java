package com.dify4j.console.app.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 已安装应用响应
 *
 * @author Craft
 * @since 2024-07-24
 */
@Data
@Schema(description = "已安装应用响应")
public class InstalledAppResponse {

    /**
     * 已安装应用ID
     */
    @Schema(description = "已安装应用ID")
    private String id;

    /**
     * 租户ID
     */
    @Schema(description = "租户ID")
    private String tenantId;

    /**
     * 应用ID
     */
    @Schema(description = "应用ID")
    private String appId;

    /**
     * 应用所有者租户ID
     */
    @Schema(description = "应用所有者租户ID")
    private String appOwnerTenantId;

    /**
     * 位置
     */
    @Schema(description = "位置")
    private Integer position;

    /**
     * 是否置顶
     */
    @Schema(description = "是否置顶")
    private Boolean isPinned;

    /**
     * 最后使用时间
     */
    @Schema(description = "最后使用时间")
    private LocalDateTime lastUsedAt;

    /**
     * 创建时间
     */
    @Schema(description = "创建时间")
    private LocalDateTime createdAt;

    /**
     * 应用详情
     */
    @Schema(description = "应用详情")
    private AppResponse app;

}