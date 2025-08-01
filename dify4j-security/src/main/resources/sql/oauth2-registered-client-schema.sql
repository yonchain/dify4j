-- 创建 OAuth2 注册客户端表
CREATE TABLE dify4j_oauth2_registered_client (
                                                 id varchar(100) NOT NULL,                          -- 客户端唯一标识符
                                                 client_id varchar(100) NOT NULL,                   -- OAuth2 客户端ID
                                                 client_id_issued_at timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL, -- 客户端ID发布时间
                                                 client_secret varchar(200) DEFAULT NULL,           -- 客户端密钥（可为空）
                                                 client_secret_expires_at timestamp DEFAULT NULL,   -- 客户端密钥过期时间（可为空）
                                                 client_name varchar(200) NOT NULL,                 -- 客户端名称
                                                 client_authentication_methods varchar(1000) NOT NULL, -- 客户端认证方法（JSON格式）
                                                 authorization_grant_types varchar(1000) NOT NULL,  -- 授权类型（JSON格式）
                                                 redirect_uris varchar(1000) DEFAULT NULL,          -- 重定向URI列表（JSON格式，可为空）
                                                 post_logout_redirect_uris varchar(1000) DEFAULT NULL, -- 登出后重定向URI列表（JSON格式，可为空）
                                                 scopes varchar(1000) NOT NULL,                     -- 客户端授权范围（JSON格式）
                                                 client_settings varchar(2000) NOT NULL,            -- 客户端设置（JSON格式）
                                                 token_settings varchar(2000) NOT NULL,             -- 令牌设置（JSON格式）
                                                 PRIMARY KEY (id)                                   -- 主键约束
);

-- 添加表注释
COMMENT ON TABLE dify4j_oauth2_registered_client IS 'OAuth2 注册客户端信息表，存储OAuth2客户端的配置和凭证';

-- 添加列注释
COMMENT ON COLUMN dify4j_oauth2_registered_client.id IS '客户端记录的唯一标识符';
COMMENT ON COLUMN dify4j_oauth2_registered_client.client_id IS 'OAuth2协议中的客户端ID，用于客户端身份识别';
COMMENT ON COLUMN dify4j_oauth2_registered_client.client_id_issued_at IS '客户端ID的发布时间';
COMMENT ON COLUMN dify4j_oauth2_registered_client.client_secret IS '客户端密钥，用于客户端认证';
COMMENT ON COLUMN dify4j_oauth2_registered_client.client_secret_expires_at IS '客户端密钥的过期时间，NULL表示永不过期';
COMMENT ON COLUMN dify4j_oauth2_registered_client.client_name IS '客户端的显示名称';
COMMENT ON COLUMN dify4j_oauth2_registered_client.client_authentication_methods IS '客户端支持的认证方法列表，JSON格式，如["client_secret_basic", "client_secret_post"]';
COMMENT ON COLUMN dify4j_oauth2_registered_client.authorization_grant_types IS '客户端支持的授权类型列表，JSON格式，如["authorization_code", "refresh_token"]';
COMMENT ON COLUMN dify4j_oauth2_registered_client.redirect_uris IS '授权成功后允许重定向的URI列表，JSON格式';
COMMENT ON COLUMN dify4j_oauth2_registered_client.post_logout_redirect_uris IS '用户登出后允许重定向的URI列表，JSON格式';
COMMENT ON COLUMN dify4j_oauth2_registered_client.scopes IS '客户端允许请求的授权范围列表，JSON格式';
COMMENT ON COLUMN dify4j_oauth2_registered_client.client_settings IS '客户端配置参数，JSON格式，包含如需要用户同意、PKCE要求等设置';
COMMENT ON COLUMN dify4j_oauth2_registered_client.token_settings IS '令牌配置参数，JSON格式，包含如令牌有效期、刷新令牌有效期等设置';