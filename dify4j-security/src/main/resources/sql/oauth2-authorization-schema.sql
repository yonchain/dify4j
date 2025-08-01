/*
IMPORTANT:
    If using PostgreSQL, update ALL columns defined with 'blob' to 'text',
    as PostgreSQL does not support the 'blob' data type.
*/
CREATE TABLE dify4j_oauth2_authorization (
                                             id varchar(100) NOT NULL PRIMARY KEY,
                                             registered_client_id varchar(100) NOT NULL,
                                             principal_name varchar(200) NOT NULL,
                                             authorization_grant_type varchar(100) NOT NULL,
                                             authorized_scopes varchar(1000),
                                             attributes text,
                                             state varchar(500),

    -- 授权码相关字段
                                             authorization_code_value text,
                                             authorization_code_issued_at timestamp,
                                             authorization_code_expires_at timestamp,
                                             authorization_code_metadata text,

    -- 访问令牌相关字段
                                             access_token_value text,
                                             access_token_issued_at timestamp,
                                             access_token_expires_at timestamp,
                                             access_token_metadata text,
                                             access_token_type varchar(100),
                                             access_token_scopes varchar(1000),

    -- OIDC ID令牌相关字段
                                             oidc_id_token_value text,
                                             oidc_id_token_issued_at timestamp,
                                             oidc_id_token_expires_at timestamp,
                                             oidc_id_token_metadata text,

    -- 刷新令牌相关字段
                                             refresh_token_value text,
                                             refresh_token_issued_at timestamp,
                                             refresh_token_expires_at timestamp,
                                             refresh_token_metadata text,

    -- 用户码相关字段(设备流)
                                             user_code_value text,
                                             user_code_issued_at timestamp,
                                             user_code_expires_at timestamp,
                                             user_code_metadata text,

    -- 设备码相关字段
                                             device_code_value text,
                                             device_code_issued_at timestamp,
                                             device_code_expires_at timestamp,
                                             device_code_metadata text
);

-- 添加索引提高查询性能
CREATE INDEX idx_dify4j_auth_registered_client_id ON dify4j_oauth2_authorization(registered_client_id);
CREATE INDEX idx_dify4j_auth_principal_name ON dify4j_oauth2_authorization(principal_name);
CREATE INDEX idx_dify4j_auth_state ON dify4j_oauth2_authorization(state);
CREATE INDEX idx_dify4j_auth_expires ON dify4j_oauth2_authorization(access_token_expires_at);

-- PostgreSQL 注释（使用单独的COMMENT语句）
COMMENT ON TABLE dify4j_oauth2_authorization IS 'OAuth2 授权信息存储表';
COMMENT ON COLUMN dify4j_oauth2_authorization.id IS '主键ID';
COMMENT ON COLUMN dify4j_oauth2_authorization.registered_client_id IS '注册客户端ID';
COMMENT ON COLUMN dify4j_oauth2_authorization.principal_name IS '授权主体名称';
COMMENT ON COLUMN dify4j_oauth2_authorization.authorization_grant_type IS '授权类型(如authorization_code)';
COMMENT ON COLUMN dify4j_oauth2_authorization.authorized_scopes IS '已授权范围(逗号分隔)';
COMMENT ON COLUMN dify4j_oauth2_authorization.attributes IS '授权属性(JSON格式)';
COMMENT ON COLUMN dify4j_oauth2_authorization.state IS '状态值(用于防CSRF)';
COMMENT ON COLUMN dify4j_oauth2_authorization.authorization_code_value IS '授权码值';
COMMENT ON COLUMN dify4j_oauth2_authorization.authorization_code_issued_at IS '授权码签发时间';
COMMENT ON COLUMN dify4j_oauth2_authorization.authorization_code_expires_at IS '授权码过期时间';
COMMENT ON COLUMN dify4j_oauth2_authorization.authorization_code_metadata IS '授权码元数据';
COMMENT ON COLUMN dify4j_oauth2_authorization.access_token_value IS '访问令牌值';
COMMENT ON COLUMN dify4j_oauth2_authorization.access_token_issued_at IS '访问令牌签发时间';
COMMENT ON COLUMN dify4j_oauth2_authorization.access_token_expires_at IS '访问令牌过期时间';
COMMENT ON COLUMN dify4j_oauth2_authorization.access_token_metadata IS '访问令牌元数据';
COMMENT ON COLUMN dify4j_oauth2_authorization.access_token_type IS '令牌类型(如Bearer)';
COMMENT ON COLUMN dify4j_oauth2_authorization.access_token_scopes IS '访问令牌范围';
COMMENT ON COLUMN dify4j_oauth2_authorization.oidc_id_token_value IS 'OIDC ID令牌值';
COMMENT ON COLUMN dify4j_oauth2_authorization.oidc_id_token_issued_at IS 'ID令牌签发时间';
COMMENT ON COLUMN dify4j_oauth2_authorization.oidc_id_token_expires_at IS 'ID令牌过期时间';
COMMENT ON COLUMN dify4j_oauth2_authorization.oidc_id_token_metadata IS 'ID令牌元数据';
COMMENT ON COLUMN dify4j_oauth2_authorization.refresh_token_value IS '刷新令牌值';
COMMENT ON COLUMN dify4j_oauth2_authorization.refresh_token_issued_at IS '刷新令牌签发时间';
COMMENT ON COLUMN dify4j_oauth2_authorization.refresh_token_expires_at IS '刷新令牌过期时间';
COMMENT ON COLUMN dify4j_oauth2_authorization.refresh_token_metadata IS '刷新令牌元数据';
COMMENT ON COLUMN dify4j_oauth2_authorization.user_code_value IS '用户码值';
COMMENT ON COLUMN dify4j_oauth2_authorization.user_code_issued_at IS '用户码签发时间';
COMMENT ON COLUMN dify4j_oauth2_authorization.user_code_expires_at IS '用户码过期时间';
COMMENT ON COLUMN dify4j_oauth2_authorization.user_code_metadata IS '用户码元数据';
COMMENT ON COLUMN dify4j_oauth2_authorization.device_code_value IS '设备码值';
COMMENT ON COLUMN dify4j_oauth2_authorization.device_code_issued_at IS '设备码签发时间';
COMMENT ON COLUMN dify4j_oauth2_authorization.device_code_expires_at IS '设备码过期时间';
COMMENT ON COLUMN dify4j_oauth2_authorization.device_code_metadata IS '设备码元数据';
