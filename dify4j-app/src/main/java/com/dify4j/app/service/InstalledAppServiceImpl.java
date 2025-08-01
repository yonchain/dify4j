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

import com.dify4j.api.app.InstalledApp;
import com.dify4j.api.app.InstalledAppService;
import com.dify4j.api.common.Page;
import com.dify4j.app.entity.InstalledAppEntity;
import com.dify4j.app.mapper.InstalledAppMapper;
import com.dify4j.utils.PageUtil;
import com.github.pagehelper.PageHelper;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * 已安装应用服务实现类
 *
 * @author Craft
 * @since 2024-07-24
 */
@Service
public class InstalledAppServiceImpl implements InstalledAppService {

    /**
     * 已安装应用存储
     */
    @Resource
    private InstalledAppMapper installedAppMapper;


    @Override
    public InstalledApp getInstalledAppById(String id) {
        return installedAppMapper.selectById(id);
    }

    @Override
    public Page<InstalledApp> getInstalledAppsByPage(String tenantId, Map<String, Object> queryParam, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        List<InstalledApp> installedApps = installedAppMapper.selectList(tenantId, queryParam);
        
        return PageUtil.convert(installedApps);
    }

    @Override
    public List<InstalledApp> getInstalledAppsByTenantId(String tenantId) {
        return installedAppMapper.selectByTenantId(tenantId);
    }

    @Override
    public InstalledApp createInstalledApp(InstalledApp installedApp) {
        if (installedApp.getId() == null) {
            installedApp.setId(UUID.randomUUID().toString());
        }
        
        if (installedApp.getCreatedAt() == null) {
            installedApp.setCreatedAt(LocalDateTime.now());
        }
        
        if (installedApp.getLastUsedAt() == null) {
            installedApp.setLastUsedAt(LocalDateTime.now());
        }
        
        if (installedApp.getIsPinned() == null) {
            installedApp.setIsPinned(false);
        }
        
        // 如果没有指定位置，则放在最后
        if (installedApp.getPosition() == null) {
            List<InstalledApp> tenantApps = getInstalledAppsByTenantId(installedApp.getTenantId());
            int maxPosition = tenantApps.stream()
                    .filter(app -> app.getPosition() != null)
                    .mapToInt(InstalledApp::getPosition)
                    .max()
                    .orElse(0);
            installedApp.setPosition(maxPosition + 1);
        }

        installedAppMapper.insert(installedApp);
        return installedApp;
    }

    @Override
    public InstalledApp updateInstalledApp(InstalledApp installedApp) {

        installedAppMapper.update( installedApp);
        return installedApp;
    }

    @Override
    public void deleteInstalledAppById(String id) {
        installedAppMapper.deleteById(id);
    }

    @Override
    public void deleteInstalledAppByIds(List<String> ids) {
        ids.forEach(this::deleteInstalledAppById);
    }

    @Override
    public void updateLastUsedAt(String id) {
        InstalledApp app = getInstalledAppById(id);
        if (app != null) {
            app.setLastUsedAt(LocalDateTime.now());
            updateInstalledApp(app);
        }
    }

    @Override
    public InstalledApp updatePinStatus(String id, boolean isPinned) {
        InstalledApp app = getInstalledAppById(id);
        if (app != null) {
            app.setIsPinned(isPinned);
            return updateInstalledApp(app);
        }
        return null;
    }

    @Override
    public InstalledApp updatePosition(String id, int position) {
        InstalledApp app = getInstalledAppById(id);
        if (app != null) {
            app.setPosition(position);
            return updateInstalledApp(app);
        }
        return null;
    }
}
