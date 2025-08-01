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
package com.dify4j.app.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 应用模型配置实体类
 * <p>
 * 对应数据库表 app_model_configs，存储应用的模型配置信息
 * 包括模型提供商、模型ID、配置参数、提示词设置等
 * </p>
 *
 * @author Craft
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class AppModelConfigEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private String id;

    /**
     * 应用ID
     */
    private String appId;

    /**
     * 模型提供商
     */
    private String provider;

    /**
     * 模型ID
     */
    private String modelId;

    /**
     * 配置参数（JSON格式）
     */
    private Object configs;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;

    /**
     * 开场白
     */
    private String openingStatement;

    /**
     * 建议问题
     */
    private String suggestedQuestions;

    /**
     * 回答后的建议问题
     */
    private String suggestedQuestionsAfterAnswer;

    /**
     * 更多类似内容
     */
    private String moreLikeThis;

    /**
     * 模型
     */
    private String model;

    /**
     * 用户输入表单
     */
    private String userInputForm;

    /**
     * 预设提示词
     */
    private String prePrompt;

    /**
     * 代理模式
     */
    private String agentMode;

    /**
     * 语音转文本配置
     */
    private String speechToText;

    /**
     * 敏感词回避配置
     */
    private String sensitiveWordAvoidance;

    /**
     * 检索资源配置
     */
    private String retrieverResource;

    /**
     * 数据集查询变量
     */
    private String datasetQueryVariable;

    /**
     * 提示类型，默认为simple
     */
    private String promptType;

    /**
     * 聊天提示配置
     */
    private String chatPromptConfig;

    /**
     * 补全提示配置
     */
    private String completionPromptConfig;

    /**
     * 数据集配置
     */
    private String datasetConfigs;

    /**
     * 外部数据工具
     */
    private String externalDataTools;

    /**
     * 文件上传配置
     */
    private String fileUpload;

    /**
     * 文本转语音配置
     */
    private String textToSpeech;

    /**
     * 创建人ID
     */
    private String createdBy;

    /**
     * 更新人ID
     */
    private String updatedBy;
}
