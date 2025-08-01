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
public interface Dify4jService {

    /**
     * 获取用户服务
     *
     * @return 用户服务
     */
    UserService getUserService();

    /**
     * 获取租户服务
     *
     * @return 租户服务
     */
    TenantService getTenantService();

    /**
     * 获取知识库服务
     *
     * @return 知识库服务
     */
    KnowledgeService getKnowledgeService();
}
