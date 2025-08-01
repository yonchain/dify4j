package com.dify4j.console.knowledge.request;

import com.dify4j.web.request.PageRequest;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * 查询知识库请求
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "查询知识库请求")
public class KnowledgeQueryRequest extends PageRequest {

    /**
     * 关键字
     */
    @Schema(description = "关键字", example = "关键字")
    private String keyword;
}
