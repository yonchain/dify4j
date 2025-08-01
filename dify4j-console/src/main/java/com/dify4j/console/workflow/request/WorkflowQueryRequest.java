package com.dify4j.console.workflow.request;

import com.dify4j.web.request.PageRequest;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 工作流查询请求DTO
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(description = "工作流查询请求")
public class WorkflowQueryRequest extends PageRequest {

    /**
     * 搜索关键词
     */
    @Schema(description = "搜索关键词")
    private String keyword;

    /**
     * 工作流类型
     */
    @Schema(description = "工作流类型")
    private String type;

}
