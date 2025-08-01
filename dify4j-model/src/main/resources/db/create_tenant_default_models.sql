-- 创建租户默认模型关系表
CREATE TABLE IF NOT EXISTS tenant_default_models (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    tenant_id UUID NOT NULL,
    model_id UUID NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT NOW(),
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT NOW(),
    CONSTRAINT fk_tenant_default_models_model FOREIGN KEY (model_id) REFERENCES provider_models(id) ON DELETE CASCADE,
    CONSTRAINT uk_tenant_default_models_tenant UNIQUE (tenant_id)
);

-- 添加索引
CREATE INDEX IF NOT EXISTS idx_tenant_default_models_tenant_id ON tenant_default_models(tenant_id);
CREATE INDEX IF NOT EXISTS idx_tenant_default_models_model_id ON tenant_default_models(model_id);

COMMENT ON TABLE tenant_default_models IS '租户默认模型关系表';
COMMENT ON COLUMN tenant_default_models.id IS '主键ID';
COMMENT ON COLUMN tenant_default_models.tenant_id IS '租户ID';
COMMENT ON COLUMN tenant_default_models.model_id IS '模型ID';
COMMENT ON COLUMN tenant_default_models.created_at IS '创建时间';
COMMENT ON COLUMN tenant_default_models.updated_at IS '更新时间';
