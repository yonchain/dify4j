package com.dify4j.console.app.request;

import com.dify4j.web.request.PageRequest;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 已安装应用查询请求
 *
 * @author Craft
 * @since 2024-07-24
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "已安装应用查询请求")
public class InstalledAppQueryRequest extends PageRequest {

    /**
     * 应用名称
     * 模糊匹配查询
     */
    @Schema(description = "应用名称")
    private String name;

    /**
     * 应用模式
     * 精确匹配查询
     * 可选值：chat, completion, workflow等
     */
    @Schema(description = "应用模式")
    private String mode;
}
