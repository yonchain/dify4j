package com.dify4j.model.service;

import com.dify4j.api.common.Page;
import com.dify4j.api.model.Model;
import com.dify4j.api.model.ModelProvider;
import com.dify4j.api.model.ModelService;
import com.dify4j.api.model.TenantDefaultModel;
import com.dify4j.model.mapper.DefaultModelMapper;
import com.dify4j.model.mapper.ModelMapper;
import com.dify4j.model.mapper.ModelProviderMapper;
import com.dify4j.utils.PageUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 模型服务实现类
 *
 * @author chengy
 * @since 1.0.0
 */
@Service
public class ModelServiceImpl implements ModelService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ModelProviderMapper modelProviderMapper;

    @Autowired
    private DefaultModelMapper defaultModelMapper;

    @Override
    public Model getModelById(String id) {
        return modelMapper.selectById(id);
    }

    @Override
    public List<Model> getModels(String tenantId, String providerName) {
        Map<String, Object> queryParam = new HashMap<>();
        queryParam.put("providerName", providerName);
        return modelMapper.selectList(tenantId, queryParam);
    }

    @Override
    public Page<Model> pageModels(String tenantId, Map<String, Object> queryParam, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        //分页查询
        List<Model> models = modelMapper.selectList(tenantId, queryParam);

        return PageUtil.convert(models);
    }

    @Override
    public String createModel(Model model) {
        modelMapper.insert(model);
        return model.getId();
    }

    @Override
    public void updateModel(Model model) {
        modelMapper.update(model);
    }

    @Override
    public void deleteModel(String id) {
        modelMapper.deleteById(id);
    }

    @Override
    public ModelProvider getProviderById(String providerId) {
        return modelProviderMapper.selectById(providerId);
    }

    @Override
    public Page<ModelProvider> pageProviders(String tenantId, Map<String, Object> queryParam, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        queryParam.put("isValid", true);

        //分页查询
        List<ModelProvider> models = modelProviderMapper.selectList(tenantId, queryParam);

        return PageUtil.convert(models);
    }

    @Override
    public List<ModelProvider> getProvidersByTenantId(String tenantId) {
        Map<String, Object> queryParam = new HashMap<>();
        queryParam.put("isValid", true);
        return modelProviderMapper.selectList(tenantId, queryParam);
    }

    @Override
    public void createProvider(ModelProvider modelProvider) {

        modelProvider.setCreatedAt(LocalDateTime.now());

        modelProviderMapper.insert(modelProvider);
    }

    @Override
    public void updateProvider(ModelProvider modelProvider) {
        modelProviderMapper.update(modelProvider);
    }

    @Override
    public void deleteProvider(String providerId) {
        modelProviderMapper.deleteById(providerId);
    }

    @Override
    public void setDefaultModels(String tenantId, List<TenantDefaultModel> defaultModels) {
        // 先清除该租户的所有默认模型
        defaultModelMapper.deleteByTenantId(tenantId);
        // 设置新的默认模型
        defaultModelMapper.batchInsert(defaultModels);
    }

    @Override
    public List<TenantDefaultModel> getDefaultModels(String tenantId) {
        return defaultModelMapper.selectListByTenantId(tenantId);
    }

    @Override
    public TenantDefaultModel getDefaultModels(String tenantId, String modelType) {
        return defaultModelMapper.selectOne(tenantId, modelType);
    }


}
