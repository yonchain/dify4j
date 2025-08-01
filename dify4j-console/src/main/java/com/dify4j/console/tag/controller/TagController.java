package com.dify4j.console.tag.controller;

import com.dify4j.api.common.Page;
import com.dify4j.api.tag.DefaultTag;
import com.dify4j.api.tag.Tag;
import com.dify4j.console.BaseController;
import com.dify4j.console.tag.request.TagRequest;
import com.dify4j.console.tag.request.TagQueryRequest;
import com.dify4j.console.tag.response.TagResponse;
import com.dify4j.api.tag.TagService;
import com.dify4j.web.response.ApiResponse;
import com.dify4j.web.response.PageResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 标签控制器
 *
 * @author Cgy
 * @since 1.0.0
 */
@RestController
@RequestMapping("/tags")
public class TagController extends BaseController {

    @Autowired
    private TagService tagService;

    /**
     * 获取标签
     *
     * @param id 标签ID
     * @return 标签信息
     */
    @Operation(summary = "获取标签详情", description = "根据ID获取标签详细信息")
    @GetMapping("/{id}")
    public TagResponse getTagById(@Parameter(description = "标签ID") @PathVariable String id) {
        Tag tag = tagService.getTagById(id);
        if (tag == null) {
            throw new RuntimeException("标签不存在");
        }
        // 转换为响应对象
        return responseFactory.createTagResponse(tag);
    }


    /**
     * 分页查询标签
     *
     * @param request 查询条件
     * @return 分页结果
     */
    @Operation(summary = "分页查询标签", description = "根据条件分页查询标签列表")
    @GetMapping
    public PageResponse<TagResponse> pageTags(@Parameter(description = "查询条件") @Valid TagQueryRequest request) {
        // 构建查询条件
        Map<String, Object> queryParam = new HashMap<>();
        queryParam.put("type", request.getType());

        // 分页查询
        Page<Tag> tags = tagService.pageTags(this.getCurrentTenantId(), queryParam, request.getPage(), request.getLimit());

        // 转换为响应对象
        return responseFactory.createTagPageResponse(tags);
    }


    /**
     * 创建标签
     *
     * @param request 创建标签请求
     * @return 创建的标签
     */
    @Operation(summary = "创建标签", description = "创建一个新的标签")
    @PostMapping
    public TagResponse createTag(@Parameter(description = "标签创建请求") @Valid @RequestBody TagRequest request) {
        String tenantId = this.getCurrentTenantId();

        // 创建标签
        Tag tag = new DefaultTag();
        tag.setId(UUID.randomUUID().toString());
        tag.setTenantId(tenantId);
        tag.setType(request.getType());
        tag.setName(request.getName());
        tag.setCreatedBy(this.getCurrentUserId());
        tag.setCreatedAt(LocalDateTime.now());
        tagService.createTag(tag);

        // 转换为响应对象
        tag = tagService.getTagById(tag.getId());
        return responseFactory.createTagResponse(tag);
    }


    /**
     * 更新标签
     *
     * @param id      标签ID
     * @param request 更新标签请求
     * @return 更新后的标签
     */
    @Operation(summary = "更新标签", description = "根据指定ID的标签信息")
    @PutMapping("/{id}")
    public ApiResponse<Void> updateTag(@Parameter(description = "标签ID") @PathVariable String id,
                                       @Valid @RequestBody TagRequest request) {
        // 获取标签
        Tag tag = tagService.getTagById(id);
        if (tag == null) {
            throw new RuntimeException("标签不存在");
        }

        // 更新标签
        if (request.getType() != null) {
            tag.setType(request.getType());
        }
        if (request.getName() != null) {
            tag.setName(request.getName());
        }

        tagService.updateTag(tag);

        // 转换为响应对象
        return ApiResponse.success();
    }

    /**
     * 删除标签
     *
     * @param id 标签ID
     * @return 是否删除成功
     */
    @Operation(summary = "删除标签", description = "根据指定ID删除标签")
    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteTagById(@Parameter(description = "标签ID") @PathVariable String id) {
        tagService.deleteTagById(id);
        return ApiResponse.success();
    }

    /**
     * 批量删除标签
     *
     * @param ids 标签ID列表
     * @return 是否删除成功
     */
    @Operation(summary = "批量删除标签", description = "根据指定ID批量删除标签")
    @DeleteMapping
    public ApiResponse<Void> deleteTagByIds(@RequestBody List<String> ids) {
        tagService.deleteTagByIds(ids);
        return ApiResponse.success();
    }
}
