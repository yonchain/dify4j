/*
 * Copyright (c) 2024 Dify4j
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.dify4j.app.service;

import com.dify4j.api.app.App;
import com.dify4j.api.app.DefaultInstalledApp;
import com.dify4j.api.app.InstalledApp;
import com.dify4j.api.common.Page;
import com.dify4j.api.constant.ApiKeyType;
import com.dify4j.api.app.AppMode;
import com.dify4j.api.exception.Dify4jException;
import com.dify4j.api.exception.Dify4jIllegalStateException;
import com.dify4j.api.idm.*;
import com.dify4j.app.entity.AppModelConfigEntity;
import com.dify4j.app.mapper.AppMapper;
import com.dify4j.api.app.AppService;
import com.dify4j.app.mapper.AppModelConfigMapper;
import com.dify4j.app.mapper.AppRoleMapper;
import com.dify4j.app.mapper.InstalledAppMapper;
import com.dify4j.utils.Assert;
import com.dify4j.utils.PageUtil;
import com.github.pagehelper.PageHelper;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.*;

/**
 * 应用服务实现类
 *
 * @author Cgy
 * @since 2024-01-20
 */
@Service
public class AppServiceImpl implements AppService {

    @Autowired
    private AppMapper appMapper;

    @Autowired
    private ApiKeyService apiKeyService;

    @Autowired
    private AppRoleMapper appRoleMapper;

    @Autowired
    private InstalledAppMapper installedAppMapper;

    @Autowired
    private AppModelConfigMapper appModelConfigMapper;

    @Autowired
    private RoleService roleService;

    @Override
    public App getAppById(String id) {
        return appMapper.selectById(id);
    }

    @Override
    public Page<App> getAppsByPage(String tenantId, Map<String, Object> queryParam, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        List<App> apps = appMapper.selectList(tenantId, queryParam);

        return PageUtil.convert(apps);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createApp(App app) {

        //默认默认值
        app.setApiRph(0);
        app.setApiRpm(0);
        app.setEnableSite(true);
        app.setEnableApi(true);

        //如果为空则设置默认值
        if (StringUtils.isBlank(app.getIconType())) {
            app.setIconType("emoji");
        }
        if (app.getDescription() == null) {
            //dify数据库设置不能为空，只能设置空字符串
            app.setDescription("");
        }

        AppModelConfigEntity appModelConfig = null;

        //工作流模式
        if (AppMode.WORKFLOW.getValue().equals(app.getMode())) {
            //TODO 待补充逻辑
        }
        // 文本生成应用模式
        else if (AppMode.COMPLETION.getValue().equals(app.getMode())) {
            // 设置默认模型配置
            appModelConfig = new AppModelConfigEntity();
            appModelConfig.setId(UUID.randomUUID().toString());
            appModelConfig.setModel("{\n" +
                    "                \"provider\": \"openai\",\n" +
                    "                \"name\": \"gpt-4o\",\n" +
                    "                \"mode\": \"chat\",\n" +
                    "                \"completion_params\": {}\n" +
                    "            }");
            appModelConfig.setUserInputForm("[\n" +
                    "                    {\n" +
                    "                        \"paragraph\": {\n" +
                    "                            \"label\": \"Query\",\n" +
                    "                            \"variable\": \"query\",\n" +
                    "                            \"required\": true,\n" +
                    "                            \"default\": \"\"\n" +
                    "                        }\n" +
                    "                    }\n" +
                    "                ]");
            appModelConfig.setPrePrompt("{{query}}");
            app.setAppModelConfigId(appModelConfig.getId());
        }
        // 聊天应用模式
        else if (AppMode.CHAT.getValue().equals(app.getMode())) {
            // 设置默认模型配置
            appModelConfig = new AppModelConfigEntity();
            appModelConfig.setId(UUID.randomUUID().toString());
            appModelConfig.setModel("{\n" +
                    "                \"provider\": \"openai\",\n" +
                    "                \"name\": \"gpt-4o\",\n" +
                    "                \"mode\": \"chat\",\n" +
                    "                \"completion_params\": {}\n" +
                    "            }");
            app.setAppModelConfigId(appModelConfig.getId());
        }
        //聊天工作流模式
        else if (AppMode.ADVANCED_CHAT.getValue().equals(app.getMode())) {
            //TODO 待补充逻辑
        }
        //聊天机器人模式
        else if (AppMode.AGENT_CHAT.getValue().equals(app.getMode())) {
            // 设置默认模型配置
            appModelConfig = new AppModelConfigEntity();
            appModelConfig.setId(UUID.randomUUID().toString());
            appModelConfig.setModel("{\n" +
                    "                \"provider\": \"openai\",\n" +
                    "                \"name\": \"gpt-4o\",\n" +
                    "                \"mode\": \"chat\",\n" +
                    "                \"completion_params\": {}\n" +
                    "            }");
            app.setAppModelConfigId(appModelConfig.getId());
        } else {
            throw new Dify4jIllegalStateException("应用模式不支持");
        }

        LocalDateTime now = LocalDateTime.now();
        app.setCreatedAt(now);
        app.setUpdatedAt(now);

        //保存应用
        appMapper.insert(app);

        //保存模型配置
        if (appModelConfig != null) {
            appModelConfig.setAppId(app.getId());
            appModelConfig.setPromptType("simple");
            appModelConfig.setCreatedAt(now);
            appModelConfig.setUpdatedAt(now);
            appModelConfigMapper.insert(appModelConfig);
        }

        //创建应用安装信息
        InstalledApp installedApp = new DefaultInstalledApp();
        installedApp.setId(UUID.randomUUID().toString());
        installedApp.setAppId(app.getId());
        installedApp.setTenantId(app.getTenantId());
        installedApp.setAppOwnerTenantId(app.getTenantId());
        installedApp.setCreatedAt(now);
        installedApp.setPosition(0);
        installedApp.setIsPinned(false);
        installedAppMapper.insert(installedApp);

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createApp(App app, List<String> roleIds) {
        //创建应用
        this.createApp(app);

        //保存应用关联的角色
        if (!CollectionUtils.isEmpty(roleIds)) {
            this.saveAppRoles(app.getId(), roleIds);
        }

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateApp(App app) {
        app.setUpdatedAt(LocalDateTime.now());
        appMapper.update(app);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateApp(App app, List<String> roleIds) {
        //更新应用信息
        this.updateApp(app);

        //保存角色
        if (!CollectionUtils.isEmpty(roleIds)) {
            this.saveAppRoles(app.getId(), roleIds);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteAppById(String id) {
        //删除应用模型配置
        appModelConfigMapper.deleteByAppId(id);
        //删除应用安装信息
        installedAppMapper.deleteByAppId(id);
        //删除应用角色
        appRoleMapper.deleteByAppId(id);
        //删除应用
        appMapper.deleteById(id);
    }

    @Override
    public List<ApiKey> getAppApiKeys(String appId) {
        Map<String, Object> queryParam = new HashMap<>();
        queryParam.put("appId", appId);
        return apiKeyService.getApiKeys(null, ApiKeyType.APP, queryParam);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ApiKey createAppApiKey(String tenantId, String appId) {
        ApiKey apiKey = new DefaultApiKey();
        apiKey.setTenantId(tenantId);
        apiKey.setAppId(appId);
        apiKey.setType(ApiKeyType.APP);
        apiKey.setCreatedAt(LocalDateTime.now());
        return apiKeyService.createApiKey(apiKey);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteAppApiKey(String appId, String apikeyId) {
        apiKeyService.deleteApiKeyById(apikeyId);
    }

    @Override
    public List<Role> getAppRoles(String appId) {
        List<Role> roles = appRoleMapper.selectRoleByAppId(appId);
        //如果应用没有关联角色，则返回默认角色(Dify默认所有默认角色都可以访问应用)
        if (CollectionUtils.isEmpty(roles)) {
            App app = getAppById(appId);
            Assert.notNull(app, "应用不存在");
            roles = roleService.getSystemRoles(app.getTenantId());
        }
        return roles;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveAppRoles(String appId, List<String> roleIds) {
        Assert.notEmpty(roleIds, "角色不能为空");
        Assert.hasText(appId, "应用不能为空");
        //先根据应用id删除所有角色
        appRoleMapper.deleteByAppId(appId);

        //再根据应用id和角色id批量插入
        appRoleMapper.batchInsert(appId, roleIds);
    }

}
