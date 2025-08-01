package com.dify4j.console.app.controller;

import com.dify4j.api.app.App;
import com.dify4j.api.app.AppService;
import com.dify4j.api.app.InstalledApp;
import com.dify4j.api.app.InstalledAppService;
import com.dify4j.api.common.Page;
import com.dify4j.api.idm.CurrentUser;
import com.dify4j.console.BaseController;
import com.dify4j.console.app.request.InstalledAppQueryRequest;
import com.dify4j.console.app.response.InstalledAppResponse;
import com.dify4j.api.exception.Dify4jResourceNotFoundException;
import com.dify4j.web.response.PageResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 已安装应用控制器
 *
 * @author Craft
 * @since 2024-07-24
 */
@RestController
@RequestMapping("/installed-apps")
@Tag(name = "已安装应用管理", description = "已安装应用相关接口")
public class InstalledAppController extends BaseController {

    @Autowired
    private InstalledAppService installedAppService;

    @Autowired
    private AppService appService;

    /**
     * 根据ID获取已安装应用详情
     *
     * @param id 已安装应用ID
     * @return 已安装应用详情响应
     */
    @GetMapping("/{id}")
    @Operation(summary = "获取已安装应用详情", description = "根据已安装应用ID获取已安装应用的详细信息")
    public InstalledAppResponse getInstalledAppById(@Parameter(description = "已安装应用ID") @PathVariable String id) {
        InstalledApp installedApp = installedAppService.getInstalledAppById(id);
        if (installedApp == null) {
            throw new Dify4jResourceNotFoundException("已安装应用不存在");
        }
        InstalledAppResponse response = responseFactory.createInstalledAppResponse(installedApp);

        // 获取应用详情
        App app = appService.getAppById(installedApp.getAppId());
        if (app != null) {
            response.setApp(responseFactory.createAppResponse(app));
        }

        return response;
    }

    /**
     * 分页查询已安装应用列表
     *
     * @param request 查询请求参数
     * @return 分页已安装应用列表
     */
    @GetMapping
    @Operation(summary = "分页查询已安装应用列表", description = "根据查询条件分页获取已安装应用列表")
    public PageResponse<InstalledAppResponse> pageInstalledApps(InstalledAppQueryRequest request) {
        CurrentUser currentUser = this.getCurrentUser();

        // 构建查询参数
        Map<String, Object> queryParam = new HashMap<>();
        //应用名称
        if (StringUtils.hasText(request.getName())){
            queryParam.put("name", request.getName());
        }
        //应用类型
        if (StringUtils.hasText(request.getMode())){
            queryParam.put("mode", request.getMode());
        }
        // 不是超级管理员只查所属角色应用
        if (!currentUser.isSuperAdmin()) {
            queryParam.put("roleIds", currentUser.getRoleIds());
        }

        Page<InstalledApp> installedApps = installedAppService.getInstalledAppsByPage(currentUser.getTenantId(), queryParam, request.getPage(), request.getLimit());

        PageResponse<InstalledAppResponse> response = responseFactory.createInstalledAppPageResponse(installedApps);

        // 填充应用详情
        response.getData().forEach(installedAppResponse -> {
            App app = appService.getAppById(installedAppResponse.getAppId());
            if (app == null) {
                throw new Dify4jResourceNotFoundException("应用不存在");
            }
            installedAppResponse.setApp(responseFactory.createAppResponse(app));
        });

        return response;
    }

}
