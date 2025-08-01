/*
 * Copyright 2025-2028 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.dify4j.api;


import com.dify4j.api.idm.TenantService;
import com.dify4j.api.idm.UserService;
import com.dify4j.api.knowledge.KnowledgeService;

/**
 * Dify4j服务
 *
 * <p>
 * 所有对外服务都通过此接口获取
 */
public class Dify4jServiceImpl implements Dify4jService {

    private final UserService userService;
    private final TenantService tenantService;
    private final KnowledgeService knowledgeService;

    public Dify4jServiceImpl(UserService userService, TenantService tenantService,
                             KnowledgeService knowledgeService) {
        this.userService = userService;
        this.tenantService = tenantService;
        this.knowledgeService = knowledgeService;
    }

    @Override
    public UserService getUserService() {
        return userService;
    }

    @Override
    public TenantService getTenantService() {
        return tenantService;
    }

    @Override
    public KnowledgeService getKnowledgeService() {
        return knowledgeService;
    }
}
