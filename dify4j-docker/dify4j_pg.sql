-- 先删除有外键约束的表
DROP TABLE IF EXISTS dify4j_menu_role;
DROP TABLE IF EXISTS dify4j_app_role;
DROP TABLE IF EXISTS api_keys;
DROP TABLE IF EXISTS dify4j_oauth2_authorization;

-- 然后删除被引用的表
DROP TABLE IF EXISTS dify4j_menu;
DROP TABLE IF EXISTS dify4j_role;
DROP TABLE IF EXISTS dify4j_role_group;
DROP TABLE IF EXISTS dify4j_oauth2_registered_client;

DROP TABLE IF EXISTS dify4j_role_group;
CREATE TABLE dify4j_role_group (
                                   id UUID PRIMARY KEY,
                                   tenant_id UUID,
                                   name VARCHAR(255) NOT NULL,
                                   created_by UUID NOT NULL,
                                   created_at TIMESTAMP NOT NULL,
                                   updated_by UUID,
                                   updated_at TIMESTAMP
);

COMMENT ON TABLE dify4j_role_group IS '角色分组表';
COMMENT ON COLUMN dify4j_role_group.id IS '主键ID';
COMMENT ON COLUMN dify4j_role_group.tenant_id IS '租户ID';
COMMENT ON COLUMN dify4j_role_group.name IS '角色分组名称';
COMMENT ON COLUMN dify4j_role_group.created_by IS '创建者ID';
COMMENT ON COLUMN dify4j_role_group.created_at IS '创建时间';
COMMENT ON COLUMN dify4j_role_group.updated_by IS '更新者ID';
COMMENT ON COLUMN dify4j_role_group.updated_at IS '更新时间';



drop table if exists dify4j_menu_role;
CREATE TABLE dify4j_menu_role (
                                  id UUID PRIMARY KEY,
                                  menu_id UUID NOT NULL,
                                  role_id UUID NOT NULL,
                                  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

COMMENT ON TABLE dify4j_menu_role IS '菜单角色关联表';
COMMENT ON COLUMN dify4j_menu_role.id IS '主键ID';
COMMENT ON COLUMN dify4j_menu_role.menu_id IS '菜单ID';
COMMENT ON COLUMN dify4j_menu_role.role_id IS '角色ID';
COMMENT ON COLUMN dify4j_menu_role.created_at IS '创建时间';

-- 创建索引
CREATE INDEX idx_menu_role_menu_id ON dify4j_menu_role(menu_id);
CREATE INDEX idx_menu_role_role_id ON dify4j_menu_role(role_id);

DROP TABLE if exists dify4j_oauth2_registered_client;
CREATE TABLE dify4j_oauth2_registered_client (
                                                 id VARCHAR(255) PRIMARY KEY,
                                                 client_id VARCHAR(255) NOT NULL,
                                                 client_id_issued_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                                 client_secret VARCHAR(255),
                                                 client_secret_expires_at TIMESTAMP,
                                                 client_name VARCHAR(255) NOT NULL,
                                                 client_authentication_methods TEXT,
                                                 authorization_grant_types TEXT,
                                                 redirect_uris TEXT,
                                                 post_logout_redirect_uris TEXT,
                                                 scopes TEXT,
                                                 client_settings TEXT,
                                                 token_settings TEXT
);

COMMENT ON TABLE dify4j_oauth2_registered_client IS 'OAuth2客户端注册表';
COMMENT ON COLUMN dify4j_oauth2_registered_client.id IS '主键ID';
COMMENT ON COLUMN dify4j_oauth2_registered_client.client_id IS '客户端ID';
COMMENT ON COLUMN dify4j_oauth2_registered_client.client_id_issued_at IS '客户端ID发布时间';
COMMENT ON COLUMN dify4j_oauth2_registered_client.client_secret IS '客户端密钥';
COMMENT ON COLUMN dify4j_oauth2_registered_client.client_secret_expires_at IS '客户端密钥过期时间';
COMMENT ON COLUMN dify4j_oauth2_registered_client.client_name IS '客户端名称';
COMMENT ON COLUMN dify4j_oauth2_registered_client.client_authentication_methods IS '客户端认证方法';
COMMENT ON COLUMN dify4j_oauth2_registered_client.authorization_grant_types IS '授权类型';
COMMENT ON COLUMN dify4j_oauth2_registered_client.redirect_uris IS '重定向URI';
COMMENT ON COLUMN dify4j_oauth2_registered_client.post_logout_redirect_uris IS '登出后重定向URI';
COMMENT ON COLUMN dify4j_oauth2_registered_client.scopes IS '作用域';
COMMENT ON COLUMN dify4j_oauth2_registered_client.client_settings IS '客户端设置';
COMMENT ON COLUMN dify4j_oauth2_registered_client.token_settings IS '令牌设置';

-- 创建索引
CREATE INDEX idx_oauth2_client_id ON dify4j_oauth2_registered_client(client_id);

/*
 Navicat Premium Dump SQL

 Source Server         : 发财服务器-Dify
 Source Server Type    : PostgreSQL
 Source Server Version : 150013 (150013)
 Source Host           : 42.194.189.63:5432
 Source Catalog        : dify
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 150013 (150013)
 File Encoding         : 65001

 Date: 24/07/2025 22:25:00
*/


-- ----------------------------
-- Table structure for dify4j_menu
-- ----------------------------
DROP TABLE IF EXISTS "public"."dify4j_menu";
CREATE TABLE "public"."dify4j_menu" (
                                        "id" uuid NOT NULL,
                                        "parent_id" uuid,
                                        "weight" int4,
                                        "name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
                                        "path" varchar(255) COLLATE "pg_catalog"."default",
                                        "sort_order" int4 DEFAULT 0,
                                        "menu_type" varchar(50) COLLATE "pg_catalog"."default" NOT NULL,
                                        "is_link" bool DEFAULT false,
                                        "is_iframe" bool DEFAULT false,
                                        "is_keep_alive" bool DEFAULT false,
                                        "icon" varchar(255) COLLATE "pg_catalog"."default",
                                        "en_name" varchar(255) COLLATE "pg_catalog"."default",
                                        "is_affix" bool DEFAULT false,
                                        "title" varchar(255) COLLATE "pg_catalog"."default",
                                        "is_hide" bool DEFAULT false,
                                        "permission" varchar(255) COLLATE "pg_catalog"."default",
                                        "created_at" timestamp(6) DEFAULT CURRENT_TIMESTAMP,
                                        "updated_at" timestamp(6)
)
;
COMMENT ON COLUMN "public"."dify4j_menu"."id" IS '主键ID';
COMMENT ON COLUMN "public"."dify4j_menu"."parent_id" IS '父菜单ID';
COMMENT ON COLUMN "public"."dify4j_menu"."weight" IS '权重';
COMMENT ON COLUMN "public"."dify4j_menu"."name" IS '菜单名称';
COMMENT ON COLUMN "public"."dify4j_menu"."path" IS '菜单路径';
COMMENT ON COLUMN "public"."dify4j_menu"."sort_order" IS '排序';
COMMENT ON COLUMN "public"."dify4j_menu"."menu_type" IS '菜单类型';
COMMENT ON COLUMN "public"."dify4j_menu"."is_link" IS '是否外链';
COMMENT ON COLUMN "public"."dify4j_menu"."is_iframe" IS '是否内嵌';
COMMENT ON COLUMN "public"."dify4j_menu"."is_keep_alive" IS '是否缓存';
COMMENT ON COLUMN "public"."dify4j_menu"."icon" IS '图标';
COMMENT ON COLUMN "public"."dify4j_menu"."en_name" IS '英文名称';
COMMENT ON COLUMN "public"."dify4j_menu"."is_affix" IS '是否固定';
COMMENT ON COLUMN "public"."dify4j_menu"."title" IS '标题';
COMMENT ON COLUMN "public"."dify4j_menu"."is_hide" IS '是否隐藏';
COMMENT ON COLUMN "public"."dify4j_menu"."permission" IS '权限标识';
COMMENT ON COLUMN "public"."dify4j_menu"."created_at" IS '创建时间';
COMMENT ON COLUMN "public"."dify4j_menu"."updated_at" IS '更新时间';
COMMENT ON TABLE "public"."dify4j_menu" IS '菜单表';

-- ----------------------------
-- Indexes structure for table dify4j_menu
-- ----------------------------
CREATE INDEX "idx_menu_parent_id" ON "public"."dify4j_menu" USING btree (
                                                                         "parent_id" "pg_catalog"."uuid_ops" ASC NULLS LAST
    );
CREATE INDEX "idx_menu_type" ON "public"."dify4j_menu" USING btree (
                                                                    "menu_type" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
    );

-- ----------------------------
-- Primary Key structure for table dify4j_menu
-- ----------------------------
ALTER TABLE "public"."dify4j_menu" ADD CONSTRAINT "dify4j_menu_pkey" PRIMARY KEY ("id");


DROP table if exists dify4j_role;
CREATE TABLE dify4j_role (
                             id UUID PRIMARY KEY,
                             name VARCHAR(255) NOT NULL,
                             code VARCHAR(255) NOT NULL,
                             description VARCHAR(500),
                             status VARCHAR(50) DEFAULT 'normal',
                             created_by UUID NOT NULL,
                             created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                             updated_by UUID,
                             updated_at TIMESTAMP,
                             tenant_id UUID NOT NULL,
                             category VARCHAR(50) DEFAULT '1',
                             group_id UUID
);

COMMENT ON TABLE dify4j_role IS '角色表';
COMMENT ON COLUMN dify4j_role.id IS '主键ID';
COMMENT ON COLUMN dify4j_role.name IS '角色名称';
COMMENT ON COLUMN dify4j_role.code IS '角色代码';
COMMENT ON COLUMN dify4j_role.description IS '角色描述';
COMMENT ON COLUMN dify4j_role.status IS '角色状态，默认为normal';
COMMENT ON COLUMN dify4j_role.created_by IS '创建者ID';
COMMENT ON COLUMN dify4j_role.created_at IS '创建时间';
COMMENT ON COLUMN dify4j_role.updated_by IS '更新者ID';
COMMENT ON COLUMN dify4j_role.updated_at IS '更新时间';
COMMENT ON COLUMN dify4j_role.tenant_id IS '租户ID';
COMMENT ON COLUMN dify4j_role.category IS '角色类别，默认为1';
COMMENT ON COLUMN dify4j_role.group_id IS '角色所属分组ID';

-- 创建索引
CREATE INDEX idx_role_tenant_id ON dify4j_role(tenant_id);
CREATE INDEX idx_role_code ON dify4j_role(code);
CREATE INDEX idx_role_group_id ON dify4j_role(group_id);



DROP table if exists api_keys;
CREATE TABLE api_keys (
                          id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                          app_id UUID NOT NULL,
                          type VARCHAR(50) NOT NULL,
                          token VARCHAR(255) NOT NULL,
                          last_used_at TIMESTAMP,
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          tenant_id UUID
);

COMMENT ON TABLE api_keys IS 'API密钥表';
COMMENT ON COLUMN api_keys.id IS '主键ID';
COMMENT ON COLUMN api_keys.app_id IS '应用ID';
COMMENT ON COLUMN api_keys.type IS '密钥类型';
COMMENT ON COLUMN api_keys.token IS '密钥令牌';
COMMENT ON COLUMN api_keys.last_used_at IS '最后使用时间';
COMMENT ON COLUMN api_keys.created_at IS '创建时间';
COMMENT ON COLUMN api_keys.tenant_id IS '租户ID';

-- 创建索引
CREATE INDEX idx_api_keys_app_id ON api_keys(app_id);
CREATE INDEX idx_api_keys_type ON api_keys(type);
CREATE INDEX idx_api_keys_tenant_id ON api_keys(tenant_id);


-- dify4j_role_group表的外键
ALTER TABLE dify4j_role_group ADD CONSTRAINT fk_role_group_tenant_id FOREIGN KEY (tenant_id) REFERENCES tenants(id);

-- dify4j_menu_role表的外键
ALTER TABLE dify4j_menu_role ADD CONSTRAINT fk_menu_role_menu_id FOREIGN KEY (menu_id) REFERENCES dify4j_menu(id);
ALTER TABLE dify4j_menu_role ADD CONSTRAINT fk_menu_role_role_id FOREIGN KEY (role_id) REFERENCES dify4j_role(id);

-- dify4j_role表的外键
ALTER TABLE dify4j_role ADD CONSTRAINT fk_role_tenant_id FOREIGN KEY (tenant_id) REFERENCES tenants(id);
ALTER TABLE dify4j_role ADD CONSTRAINT fk_role_group_id FOREIGN KEY (group_id) REFERENCES dify4j_role_group(id);


-- api_keys表的外键
ALTER TABLE api_keys ADD CONSTRAINT fk_api_keys_tenant_id FOREIGN KEY (tenant_id) REFERENCES tenants(id);


DROP table if exists dify4j_oauth2_authorization;
-- 创建OAuth2授权表 (PostgreSQL版本)

CREATE TABLE dify4j_oauth2_authorization (
                                             id varchar(100) NOT NULL,
                                             registered_client_id varchar(100) NOT NULL,
                                             principal_name varchar(200) NOT NULL,
                                             authorization_grant_type varchar(100) NOT NULL,
                                             authorized_scopes varchar(1000) DEFAULT NULL,
                                             attributes text DEFAULT NULL,
                                             state varchar(500) DEFAULT NULL,
                                             authorization_code_value text DEFAULT NULL,
                                             authorization_code_issued_at timestamp DEFAULT NULL,
                                             authorization_code_expires_at timestamp DEFAULT NULL,
                                             authorization_code_metadata text DEFAULT NULL,
                                             access_token_value text DEFAULT NULL,
                                             access_token_issued_at timestamp DEFAULT NULL,
                                             access_token_expires_at timestamp DEFAULT NULL,
                                             access_token_metadata text DEFAULT NULL,
                                             access_token_type varchar(100) DEFAULT NULL,
                                             access_token_scopes varchar(1000) DEFAULT NULL,
                                             oidc_id_token_value text DEFAULT NULL,
                                             oidc_id_token_issued_at timestamp DEFAULT NULL,
                                             oidc_id_token_expires_at timestamp DEFAULT NULL,
                                             oidc_id_token_metadata text DEFAULT NULL,
                                             refresh_token_value text DEFAULT NULL,
                                             refresh_token_issued_at timestamp DEFAULT NULL,
                                             refresh_token_expires_at timestamp DEFAULT NULL,
                                             refresh_token_metadata text DEFAULT NULL,
                                             user_code_value text DEFAULT NULL,
                                             user_code_issued_at timestamp DEFAULT NULL,
                                             user_code_expires_at timestamp DEFAULT NULL,
                                             user_code_metadata text DEFAULT NULL,
                                             device_code_value text DEFAULT NULL,
                                             device_code_issued_at timestamp DEFAULT NULL,
                                             device_code_expires_at timestamp DEFAULT NULL,
                                             device_code_metadata text DEFAULT NULL,
                                             PRIMARY KEY (id)
);


-- 创建索引以提高查询性能 (PostgreSQL版本)
CREATE INDEX dify4j_oauth2_authorization_registered_client_id_idx ON dify4j_oauth2_authorization (registered_client_id);
CREATE INDEX dify4j_oauth2_authorization_principal_name_idx ON dify4j_oauth2_authorization (principal_name);
CREATE INDEX dify4j_oauth2_authorization_state_idx ON dify4j_oauth2_authorization (state);



/*
 Navicat Premium Dump SQL

 Source Server         : 发财服务器-Dify
 Source Server Type    : PostgreSQL
 Source Server Version : 150013 (150013)
 Source Host           : 42.194.189.63:5432
 Source Catalog        : dify
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 150013 (150013)
 File Encoding         : 65001

 Date: 24/07/2025 23:55:53
*/


-- ----------------------------
-- Table structure for dify4j_app_role
-- ----------------------------
DROP TABLE IF EXISTS "public"."dify4j_app_role";
CREATE TABLE "public"."dify4j_app_role" (
                                            "id" uuid NOT NULL,
                                            "app_id" uuid NOT NULL,
                                            "role_id" uuid NOT NULL,
                                            "created_at" timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP
)
;

-- ----------------------------
-- Indexes structure for table dify4j_app_role
-- ----------------------------
CREATE INDEX "idx_app_role_app_id" ON "public"."dify4j_app_role" USING btree (
                                                                              "app_id" "pg_catalog"."uuid_ops" ASC NULLS LAST
    );
CREATE INDEX "idx_app_role_role_id" ON "public"."dify4j_app_role" USING btree (
                                                                               "role_id" "pg_catalog"."uuid_ops" ASC NULLS LAST
    );

-- ----------------------------
-- Primary Key structure for table dify4j_app_role
-- ----------------------------
ALTER TABLE "public"."dify4j_app_role" ADD CONSTRAINT "app_role_pkey" PRIMARY KEY ("id");


-- ----------------------------
-- Records of dify4j_menu
-- ----------------------------
INSERT INTO "public"."dify4j_menu" VALUES ('c72e7d6a-2e1c-4c78-8d29-d25f4e62a985', 'b61804f0-e99e-4c15-9f9c-0784b125846b', 1, '用户管理', '/admin/user/index', 1, '0', 'f', 'f', 'f', 'ele-User', 'user', 'f', '用户管理', 'f', NULL, '2025-06-08 00:00:00', '2025-06-08 00:00:00');
INSERT INTO "public"."dify4j_menu" VALUES ('d83f5a7b-3c91-4a6f-b8d7-e31f87e5a5d2', 'c72e7d6a-2e1c-4c78-8d29-d25f4e62a985', 1, '用户新增', NULL, 1, '1', 'f', 'f', 'f', NULL, NULL, 'f', '用户新增', 'f', 'sys_user_add', '2025-06-08 00:00:00', '2025-06-08 00:00:00');
INSERT INTO "public"."dify4j_menu" VALUES ('e94c2a8c-4d5e-4b6f-9a7d-8c2f3e1d9b0a', 'c72e7d6a-2e1c-4c78-8d29-d25f4e62a985', 1, '用户修改', NULL, 1, '1', 'f', 'f', 'f', NULL, NULL, 'f', '用户修改', 'f', 'sys_user_edit', '2025-06-08 00:00:00', '2025-06-08 00:00:00');
INSERT INTO "public"."dify4j_menu" VALUES ('f05d3b9d-5e6f-4c7d-8a9b-1c2d3e4f5a6b', 'c72e7d6a-2e1c-4c78-8d29-d25f4e62a985', 1, '用户删除', NULL, 1, '1', 'f', 'f', 'f', NULL, NULL, 'f', '用户删除', 'f', 'sys_user_del', '2025-06-08 00:00:00', '2025-06-08 00:00:00');
INSERT INTO "public"."dify4j_menu" VALUES ('a16c4e7f-8b39-4e5d-9c2a-3b4d5e6f7a8b', 'c72e7d6a-2e1c-4c78-8d29-d25f4e62a985', 1, '导入导出', NULL, 1, '1', 'f', 'f', 'f', NULL, NULL, 'f', '导入导出', 'f', 'sys_user_export', '2025-06-08 00:00:00', '2025-06-08 00:00:00');
INSERT INTO "public"."dify4j_menu" VALUES ('b27d5e6f-9c3a-4b8d-7e6f-1a2b3c4d5e6f', 'b61804f0-e99e-4c15-9f9c-0784b125846b', 3, '角色管理', '/admin/role/index', 3, '0', 'f', 'f', 'f', 'iconfont icon-gerenzhongxin', 'role', 'f', '角色管理', 'f', NULL, '2025-06-08 00:00:00', '2025-06-08 00:00:00');
INSERT INTO "public"."dify4j_menu" VALUES ('c38e6f7a-9d2b-4c5d-6e7f-8a9b0c1d2e3f', 'b27d5e6f-9c3a-4b8d-7e6f-1a2b3c4d5e6f', 1, '角色删除', NULL, 1, '1', 'f', 'f', 'f', NULL, NULL, 'f', '角色删除', 'f', 'sys_role_del', '2025-06-08 00:00:00', '2025-06-08 00:00:00');
INSERT INTO "public"."dify4j_menu" VALUES ('d49f0a1b-2c3d-4e5f-6a7b-8c9d0e1f2a3b', 'b27d5e6f-9c3a-4b8d-7e6f-1a2b3c4d5e6f', 1, '分配权限', NULL, 1, '1', 'f', 'f', 'f', NULL, NULL, 'f', '分配权限', 'f', 'sys_role_perm', '2025-06-08 00:00:00', '2025-06-08 00:00:00');
INSERT INTO "public"."dify4j_menu" VALUES ('e50a1b2c-3d4e-5f6a-7b8c-9d0e1f2a3b4c', 'b27d5e6f-9c3a-4b8d-7e6f-1a2b3c4d5e6f', 1, '角色新增', NULL, 1, '1', 'f', 'f', 'f', NULL, NULL, 'f', '角色新增', 'f', 'sys_role_add', '2025-06-08 00:00:00', '2025-06-08 00:00:00');
INSERT INTO "public"."dify4j_menu" VALUES ('f61b2c3d-4e5f-6a7b-8c9d-0e1f2a3b4c5d', 'b27d5e6f-9c3a-4b8d-7e6f-1a2b3c4d5e6f', 1, '角色修改', NULL, 1, '1', 'f', 'f', 'f', NULL, NULL, 'f', '角色修改', 'f', 'sys_role_edit', '2025-06-08 00:00:00', '2025-06-08 00:00:00');
INSERT INTO "public"."dify4j_menu" VALUES ('a72c3d4e-5f6a-7b8c-9d0e-1f2a3b4c5d6e', 'b27d5e6f-9c3a-4b8d-7e6f-1a2b3c4d5e6f', 4, '角色导入导出', NULL, 4, '1', 'f', 'f', 'f', NULL, NULL, 'f', '角色导入导出', 'f', 'sys_role_export', '2025-06-08 00:00:00', '2025-06-08 00:00:00');
INSERT INTO "public"."dify4j_menu" VALUES ('b83d4e5f-6a7b-8c9d-0e1f-2a3b4c5d6e7f', 'b61804f0-e99e-4c15-9f9c-0784b125846b', 5, '菜单管理', '/admin/menu/index', 5, '0', 'f', 'f', 'f', 'iconfont icon-caidan', 'menu', 'f', '菜单管理', 'f', NULL, '2025-06-08 00:00:00', '2025-06-08 00:00:00');
INSERT INTO "public"."dify4j_menu" VALUES ('c94e5f6a-7b8c-9d0e-1f2a-3b4c5d6e7f8a', 'b83d4e5f-6a7b-8c9d-0e1f-2a3b4c5d6e7f', 1, '菜单新增', NULL, 1, '1', 'f', 'f', 'f', NULL, NULL, 'f', '菜单新增', 'f', 'sys_menu_add', '2025-06-08 00:00:00', '2025-06-08 00:00:00');
INSERT INTO "public"."dify4j_menu" VALUES ('d05f6a7b-8c9d-0e1f-2a3b-4c5d6e7f8a9b', 'b83d4e5f-6a7b-8c9d-0e1f-2a3b4c5d6e7f', 1, '菜单修改', NULL, 1, '1', 'f', 'f', 'f', NULL, NULL, 'f', '菜单修改', 'f', 'sys_menu_edit', '2025-06-08 00:00:00', '2025-06-08 00:00:00');
INSERT INTO "public"."dify4j_menu" VALUES ('e16a7b8c-9d0e-1f2a-3b4c-5d6e7f8a9b0c', 'b83d4e5f-6a7b-8c9d-0e1f-2a3b4c5d6e7f', 1, '菜单删除', NULL, 1, '1', 'f', 'f', 'f', NULL, NULL, 'f', '菜单删除', 'f', 'sys_menu_del', '2025-06-08 00:00:00', '2025-06-08 00:00:00');
INSERT INTO "public"."dify4j_menu" VALUES ('a38c9d0e-1f2a-3b4c-5d6e-7f8a9b0c1d2e', 'f27b8c9d-0e1f-2a3b-4c5d-6e7f8a9b0c1d', 1, '客户端新增', NULL, 1, '1', 'f', 'f', 'f', '1', NULL, 'f', '客户端新增', 'f', 'sys_client_add', '2025-06-08 00:00:00', '2025-06-08 00:00:00');
INSERT INTO "public"."dify4j_menu" VALUES ('b49d0e1f-2a3b-4c5d-6e7f-8a9b0c1d2e3f', 'f27b8c9d-0e1f-2a3b-4c5d-6e7f8a9b0c1d', 1, '客户端修改', NULL, 1, '1', 'f', 'f', 'f', NULL, NULL, 'f', '客户端修改', 'f', 'sys_client_edit', '2025-06-08 00:00:00', '2025-06-08 00:00:00');
INSERT INTO "public"."dify4j_menu" VALUES ('c50e1f2a-3b4c-5d6e-7f8a-9b0c1d2e3f4a', 'f27b8c9d-0e1f-2a3b-4c5d-6e7f8a9b0c1d', 1, '客户端删除', NULL, 1, '1', 'f', 'f', 'f', NULL, NULL, 'f', '客户端删除', 'f', 'sys_client_del', '2025-06-08 00:00:00', '2025-06-08 00:00:00');
INSERT INTO "public"."dify4j_menu" VALUES ('7c87e50a-9706-4368-b523-0af8f61b4735', 'b61804f0-e99e-4c15-9f9c-0784b125846b', NULL, '租户管理', '/admin/tenant/index', 1, '0', 'f', 'f', 'f', 'iconfont icon-zidingyibuju', 'Tenant', NULL, '租户管理', 'f', '', '2025-07-24 23:12:54.468651', '2025-07-24 23:13:47.024752');
INSERT INTO "public"."dify4j_menu" VALUES ('e1ecf872-2b22-414b-b286-1350e37dc34b', 'de68e8c9-1266-4ebd-b343-374db82f51ce', NULL, '应用', '/ai/app/index', 1, '0', 'f', 'f', 'f', 'iconfont icon-shouye_dongtaihui', 'App', NULL, '应用', 'f', '', '2025-07-24 23:22:22.934386', '2025-07-24 23:22:22.934386');
INSERT INTO "public"."dify4j_menu" VALUES ('de68e8c9-1266-4ebd-b343-374db82f51ce', 'b61804f0-e99e-4c15-9f9c-0784b125888b', NULL, 'AI管理', '/ai', 0, '0', 'f', 'f', 'f', 'iconfont icon-shouye_dongtaihui', 'AI', NULL, 'AI管理', 'f', '', '2025-07-24 23:21:56.159465', '2025-07-24 23:28:57.718946');
INSERT INTO "public"."dify4j_menu" VALUES ('9aeb1900-c428-437e-b233-f4195b07fafa', 'b61804f0-e99e-4c15-9f9c-0784b125888b', NULL, 'Dify平台', 'http://{host}/auth/dify/redirect?redirect_uri={difyBaseUrl}/apps', 1, '0', 't', 'f', 'f', 'iconfont icon-diannao1', 'Dify', NULL, 'Dify平台', 'f', '', '2025-07-24 23:28:32.551802', '2025-07-24 23:29:03.685905');
INSERT INTO "public"."dify4j_menu" VALUES ('b61804f0-e99e-4c15-9f9c-0784b125846b', 'b61804f0-e99e-4c15-9f9c-0784b125888b', 1, '系统管理', '/system', 2, '0', 'f', 'f', 'f', 'iconfont icon-quanjushezhi_o', 'system', 'f', '系统管理', 'f', NULL, '2025-06-08 00:00:00', '2025-07-24 23:29:09.066813');
INSERT INTO "public"."dify4j_menu" VALUES ('f27b8c9d-0e1f-2a3b-4c5d-6e7f8a9b0c1d', 'b61804f0-e99e-4c15-9f9c-0784b125846b', 9, '鉴权客户端', '/admin/client/index', 9, '0', 'f', 'f', 'f', 'iconfont icon-gongju', 'client', 'f', '鉴权客户端', 'f', NULL, '2025-06-08 00:00:00', '2025-07-24 23:34:26.638067');
INSERT INTO "public"."dify4j_menu" VALUES ('db1daa78-0087-4fad-9415-f0ce5e38ac95', 'de68e8c9-1266-4ebd-b343-374db82f51ce', NULL, '模型提供商', '/ai/modelProvider/index', 3, '0', 'f', 'f', 'f', 'iconfont icon--chaifenhang', 'Model Provider', NULL, '模型提供商', 'f', '', '2025-07-24 23:40:18.896126', '2025-07-24 23:40:18.896126');
INSERT INTO "public"."dify4j_menu" VALUES ('1a576085-579e-4d64-ae78-0b665cb866a6', 'de68e8c9-1266-4ebd-b343-374db82f51ce', NULL, '模型', '/ai/model/index', 2, '0', 'f', 'f', 'f', 'iconfont icon-putong', 'Model', NULL, '模型', 'f', '', '2025-07-24 23:39:25.696941', '2025-07-24 23:40:24.463974');
INSERT INTO "public"."dify4j_menu" VALUES ('176e2d5a-cc8b-4ac0-b5ac-9e51a7feb317', 'de68e8c9-1266-4ebd-b343-374db82f51ce', NULL, '知识库', '/ai/knowledge/index', 5, '0', 'f', 'f', 'f', 'iconfont icon-juxingkaobei', 'Knowledge', NULL, '知识库', 'f', '', '2025-07-24 23:41:02.58133', '2025-07-24 23:41:40.624764');
INSERT INTO "public"."dify4j_menu" VALUES ('823323e9-6085-40f1-8770-c6a1f927fdef', 'de68e8c9-1266-4ebd-b343-374db82f51ce', NULL, '插件', 'http://{host}/auth/dify/redirect?redirect_uri={difyBaseUrl}/plugins', 8, '0', 't', 'f', 'f', 'iconfont icon-tupianyulan', 'Plugin', NULL, '插件', 'f', '', '2025-07-25 10:55:39.766988', '2025-07-25 10:56:07.46247');
INSERT INTO "public"."dify4j_menu" VALUES ('846bf99c-9446-4a79-b590-f4019f034505', 'de68e8c9-1266-4ebd-b343-374db82f51ce', NULL, '工具', 'http://{host}/auth/dify/redirect?redirect_uri={difyBaseUrl}/tools', 9, '0', 't', 'f', 'f', 'iconfont icon-bolangneng', 'Tool', NULL, '工具', 'f', '', '2025-07-25 10:56:39.389358', '2025-07-25 10:56:57.939233');
INSERT INTO "public"."dify4j_menu" VALUES ('bf21f802-6de9-4885-9b33-13789359da6d', 'de68e8c9-1266-4ebd-b343-374db82f51ce', NULL, '工作流', 'http://{host}/auth/dify/redirect?redirect_uri={difyBaseUrl}/tools?category=workflow', 10, '0', 't', 'f', 'f', 'iconfont icon-15tupianyulan', 'Workflow', NULL, '工作流', 'f', '', '2025-07-25 10:57:31.129987', '2025-07-25 10:57:48.24286');

-- ----------------------------
-- Records of dify4j_role_group
-- ----------------------------
INSERT INTO "public"."dify4j_role_group" VALUES ('52fd972c-feb3-6666-bc95-1ce4e36b2e88', '29d181ca-9562-4cc2-a4f3-be605a728143', '默认', 'b61804f0-e99e-4c15-9f9c-0784b125846b', '2025-07-10 21:54:37', 'b61804f0-e99e-4c15-9f9c-0784b125846b', '2025-07-10 21:54:41');

-- ----------------------------
-- Records of dify4j_role
-- ----------------------------
INSERT INTO "public"."dify4j_role" VALUES ('b61804f0-e99e-4c15-9f9c-0784b125888b', '超级管理员', 'owner', '拥有所有的权限', 'normal', 'b61804f0-e99e-4c15-9f9c-0784b125846b', '2025-07-10 21:52:11', '33f59f3e-4154-4da5-b3b2-7b07fd63318c', '2025-07-25 11:01:30.042257', '29d181ca-9562-4cc2-a4f3-be605a728143', '1', '52fd972c-feb3-6666-bc95-1ce4e36b2e88');
INSERT INTO "public"."dify4j_role" VALUES ('9b09b268-1625-45dc-8b5e-5e9c15369386', '管理员', 'admin', '能够建立应用程序和管理团队设置', 'normal', '33f59f3e-4154-4da5-b3b2-7b07fd63318c', '2025-07-25 11:29:48.45446', '33f59f3e-4154-4da5-b3b2-7b07fd63318c', '2025-07-25 11:30:52.884527', '29d181ca-9562-4cc2-a4f3-be605a728143', '1', '52fd972c-feb3-6666-bc95-1ce4e36b2e88');
INSERT INTO "public"."dify4j_role" VALUES ('720e1e51-e771-46f3-aaf7-aafc7d5d405c', '编辑员', 'editor', '能够建立并编辑应用程序，不能管理团队设置', 'normal', '33f59f3e-4154-4da5-b3b2-7b07fd63318c', '2025-07-25 11:32:24.988315', NULL, '2025-07-25 11:32:24.988315', '29d181ca-9562-4cc2-a4f3-be605a728143', '1', '52fd972c-feb3-6666-bc95-1ce4e36b2e88');
INSERT INTO "public"."dify4j_role" VALUES ('4b63f8a3-5810-4099-a926-81ac888d4d54', '普通员', 'normal', '只能使用应用程序，不能建立应用程序', 'normal', '33f59f3e-4154-4da5-b3b2-7b07fd63318c', '2025-07-25 11:33:35.676461', NULL, '2025-07-25 11:33:35.676461', '29d181ca-9562-4cc2-a4f3-be605a728143', '1', '52fd972c-feb3-6666-bc95-1ce4e36b2e88');

-- ----------------------------
-- Records of dify4j_menu_role
-- ----------------------------
INSERT INTO "public"."dify4j_menu_role" VALUES ('61eb3ed6-be05-4b8a-bd99-c51912c703d7', 'de68e8c9-1266-4ebd-b343-374db82f51ce', 'b61804f0-e99e-4c15-9f9c-0784b125888b', '2025-07-25 10:58:45.2279');
INSERT INTO "public"."dify4j_menu_role" VALUES ('36e3b329-5d44-4e3f-9b00-2f04713a6404', 'e1ecf872-2b22-414b-b286-1350e37dc34b', 'b61804f0-e99e-4c15-9f9c-0784b125888b', '2025-07-25 10:58:45.2279');
INSERT INTO "public"."dify4j_menu_role" VALUES ('488c2469-bb33-4bfa-89ae-73c8aa35d76d', '1a576085-579e-4d64-ae78-0b665cb866a6', 'b61804f0-e99e-4c15-9f9c-0784b125888b', '2025-07-25 10:58:45.2279');
INSERT INTO "public"."dify4j_menu_role" VALUES ('cec54184-48f9-48b8-a774-3ee319bd3a8b', 'db1daa78-0087-4fad-9415-f0ce5e38ac95', 'b61804f0-e99e-4c15-9f9c-0784b125888b', '2025-07-25 10:58:45.2279');
INSERT INTO "public"."dify4j_menu_role" VALUES ('ce2c8e19-0c97-4085-a78a-1af6b1fc6284', '176e2d5a-cc8b-4ac0-b5ac-9e51a7feb317', 'b61804f0-e99e-4c15-9f9c-0784b125888b', '2025-07-25 10:58:45.2279');
INSERT INTO "public"."dify4j_menu_role" VALUES ('d0a5706c-b34c-4f53-b1f1-ecfc8a01efc9', '823323e9-6085-40f1-8770-c6a1f927fdef', 'b61804f0-e99e-4c15-9f9c-0784b125888b', '2025-07-25 10:58:45.2279');
INSERT INTO "public"."dify4j_menu_role" VALUES ('86861de7-3c4a-49a6-bbfc-3e163a835d3a', '846bf99c-9446-4a79-b590-f4019f034505', 'b61804f0-e99e-4c15-9f9c-0784b125888b', '2025-07-25 10:58:45.2279');
INSERT INTO "public"."dify4j_menu_role" VALUES ('9077d6ec-448e-4a9f-850a-5e8ce6e42da0', 'bf21f802-6de9-4885-9b33-13789359da6d', 'b61804f0-e99e-4c15-9f9c-0784b125888b', '2025-07-25 10:58:45.2279');
INSERT INTO "public"."dify4j_menu_role" VALUES ('dc6b6199-dc4e-4286-a3fb-8bf7e96f3194', '9aeb1900-c428-437e-b233-f4195b07fafa', 'b61804f0-e99e-4c15-9f9c-0784b125888b', '2025-07-25 10:58:45.2279');
INSERT INTO "public"."dify4j_menu_role" VALUES ('c46a7371-9269-4e2a-b0d0-19473c8f80d2', 'b61804f0-e99e-4c15-9f9c-0784b125846b', 'b61804f0-e99e-4c15-9f9c-0784b125888b', '2025-07-25 10:58:45.2279');
INSERT INTO "public"."dify4j_menu_role" VALUES ('950a7f80-c04f-4706-bd1c-0ab64af8d1c4', '7c87e50a-9706-4368-b523-0af8f61b4735', 'b61804f0-e99e-4c15-9f9c-0784b125888b', '2025-07-25 10:58:45.2279');
INSERT INTO "public"."dify4j_menu_role" VALUES ('d1453be1-47af-470e-b3b0-e7d24ade0ff8', 'c72e7d6a-2e1c-4c78-8d29-d25f4e62a985', 'b61804f0-e99e-4c15-9f9c-0784b125888b', '2025-07-25 10:58:45.2279');
INSERT INTO "public"."dify4j_menu_role" VALUES ('5b855887-f747-4733-af5b-7de9c7869ba5', 'e94c2a8c-4d5e-4b6f-9a7d-8c2f3e1d9b0a', 'b61804f0-e99e-4c15-9f9c-0784b125888b', '2025-07-25 10:58:45.2279');
INSERT INTO "public"."dify4j_menu_role" VALUES ('2d1e4ec1-9360-4110-9b78-066426b00447', 'a16c4e7f-8b39-4e5d-9c2a-3b4d5e6f7a8b', 'b61804f0-e99e-4c15-9f9c-0784b125888b', '2025-07-25 10:58:45.2279');
INSERT INTO "public"."dify4j_menu_role" VALUES ('3181e94a-1db1-412f-9b1c-da2926a0ea6a', 'd83f5a7b-3c91-4a6f-b8d7-e31f87e5a5d2', 'b61804f0-e99e-4c15-9f9c-0784b125888b', '2025-07-25 10:58:45.2279');
INSERT INTO "public"."dify4j_menu_role" VALUES ('29fab297-cee2-4c2b-bb12-af2d323ed65a', 'f05d3b9d-5e6f-4c7d-8a9b-1c2d3e4f5a6b', 'b61804f0-e99e-4c15-9f9c-0784b125888b', '2025-07-25 10:58:45.2279');
INSERT INTO "public"."dify4j_menu_role" VALUES ('b46b381c-45b2-4fba-80b3-c2091b7bcee7', 'b27d5e6f-9c3a-4b8d-7e6f-1a2b3c4d5e6f', 'b61804f0-e99e-4c15-9f9c-0784b125888b', '2025-07-25 10:58:45.2279');
INSERT INTO "public"."dify4j_menu_role" VALUES ('94fd7a24-8478-476c-bbcd-9833ae18ed01', 'f61b2c3d-4e5f-6a7b-8c9d-0e1f2a3b4c5d', 'b61804f0-e99e-4c15-9f9c-0784b125888b', '2025-07-25 10:58:45.2279');
INSERT INTO "public"."dify4j_menu_role" VALUES ('17ce4b4a-2497-40ec-a120-d6cc423a1ab0', 'd49f0a1b-2c3d-4e5f-6a7b-8c9d0e1f2a3b', 'b61804f0-e99e-4c15-9f9c-0784b125888b', '2025-07-25 10:58:45.2279');
INSERT INTO "public"."dify4j_menu_role" VALUES ('883a9ccb-f4f7-4559-9020-d2ad2312afc3', 'c38e6f7a-9d2b-4c5d-6e7f-8a9b0c1d2e3f', 'b61804f0-e99e-4c15-9f9c-0784b125888b', '2025-07-25 10:58:45.2279');
INSERT INTO "public"."dify4j_menu_role" VALUES ('57ef4082-2efe-43ec-8755-86730b37fd3c', 'e50a1b2c-3d4e-5f6a-7b8c-9d0e1f2a3b4c', 'b61804f0-e99e-4c15-9f9c-0784b125888b', '2025-07-25 10:58:45.2279');
INSERT INTO "public"."dify4j_menu_role" VALUES ('b2d74b8f-d6cd-4ca5-bc1b-1fa3e209f1b4', 'a72c3d4e-5f6a-7b8c-9d0e-1f2a3b4c5d6e', 'b61804f0-e99e-4c15-9f9c-0784b125888b', '2025-07-25 10:58:45.2279');
INSERT INTO "public"."dify4j_menu_role" VALUES ('fd136bfc-9229-4532-8eb7-db7b46a46478', 'b83d4e5f-6a7b-8c9d-0e1f-2a3b4c5d6e7f', 'b61804f0-e99e-4c15-9f9c-0784b125888b', '2025-07-25 10:58:45.2279');
INSERT INTO "public"."dify4j_menu_role" VALUES ('ad727a74-d5f1-4780-9b6f-389b0892e8e9', 'c94e5f6a-7b8c-9d0e-1f2a-3b4c5d6e7f8a', 'b61804f0-e99e-4c15-9f9c-0784b125888b', '2025-07-25 10:58:45.2279');
INSERT INTO "public"."dify4j_menu_role" VALUES ('cf66c6f1-bbb2-4ac5-b456-aef69d4549f7', 'e16a7b8c-9d0e-1f2a-3b4c-5d6e7f8a9b0c', 'b61804f0-e99e-4c15-9f9c-0784b125888b', '2025-07-25 10:58:45.2279');
INSERT INTO "public"."dify4j_menu_role" VALUES ('2770e085-dc13-4637-9965-1889f0bc1ef5', 'd05f6a7b-8c9d-0e1f-2a3b-4c5d6e7f8a9b', 'b61804f0-e99e-4c15-9f9c-0784b125888b', '2025-07-25 10:58:45.2279');
INSERT INTO "public"."dify4j_menu_role" VALUES ('f5df89e1-d6f3-4cce-a4be-8448af023c65', 'f27b8c9d-0e1f-2a3b-4c5d-6e7f8a9b0c1d', 'b61804f0-e99e-4c15-9f9c-0784b125888b', '2025-07-25 10:58:45.2279');
INSERT INTO "public"."dify4j_menu_role" VALUES ('ad21a2c2-61f8-4c16-ab2a-076fa1a07a63', 'b49d0e1f-2a3b-4c5d-6e7f-8a9b0c1d2e3f', 'b61804f0-e99e-4c15-9f9c-0784b125888b', '2025-07-25 10:58:45.2279');
INSERT INTO "public"."dify4j_menu_role" VALUES ('94e880c4-99d1-4f06-a8c7-f7cd3d732063', 'a38c9d0e-1f2a-3b4c-5d6e-7f8a9b0c1d2e', 'b61804f0-e99e-4c15-9f9c-0784b125888b', '2025-07-25 10:58:45.2279');
INSERT INTO "public"."dify4j_menu_role" VALUES ('172e8588-3cfe-4036-8a8d-effd6a3eb806', 'c50e1f2a-3b4c-5d6e-7f8a-9b0c1d2e3f4a', 'b61804f0-e99e-4c15-9f9c-0784b125888b', '2025-07-25 10:58:45.2279');

INSERT INTO "public"."dify4j_oauth2_registered_client" VALUES ('e957aa44-fccc-4843-9c12-5caff7250f4d', 'dify4j', '2025-07-24 22:33:19.686', '{noop}dify4j', '2125-07-24 00:00:00', 'Dify4j', 'client_secret_basic', 'password,refresh_token', '', NULL, 'server', '{"@class":"java.util.Collections$UnmodifiableMap","settings.client.require-proof-key":false,"settings.client.require-authorization-consent":false}', '{"settings.token.reuse-refresh-tokens":false,"@class":"java.util.Collections$UnmodifiableMap","settings.token.access-token-time-to-live":["java.time.Duration",60],"settings.token.refresh-token-time-to-live":["java.time.Duration",600]}');
INSERT INTO "public"."dify4j_oauth2_registered_client" VALUES ('6f2114f4-2508-4bd4-b391-66029d03a032', 'dingtalk', '2025-07-24 23:37:34.019', '{noop}dingtalk', '2125-07-24 00:00:00', '钉钉', 'client_secret_basic', 'refresh_token,dingtalk', '', NULL, 'server', '{"@class":"java.util.Collections$UnmodifiableMap","settings.client.require-proof-key":false,"settings.client.require-authorization-consent":false}', '{"settings.token.reuse-refresh-tokens":false,"@class":"java.util.Collections$UnmodifiableMap","settings.token.access-token-time-to-live":["java.time.Duration",3600],"settings.token.refresh-token-time-to-live":["java.time.Duration",36000]}');
INSERT INTO "public"."dify4j_oauth2_registered_client" VALUES ('2e8a12b8-7bb5-42f1-a316-464642f69242', 'dify', '2025-07-24 23:36:45.384', '{noop}dify', '2125-07-24 00:00:00', 'Dify平台', 'client_secret_basic', 'refresh_token,dify,dify_authorization_code', 'http://localhost:8889/auth/dify/callback', NULL, 'server', '{"@class":"java.util.Collections$UnmodifiableMap","settings.client.require-proof-key":false,"settings.client.require-authorization-consent":false}', '{"settings.token.reuse-refresh-tokens":false,"@class":"java.util.Collections$UnmodifiableMap","settings.token.access-token-time-to-live":["java.time.Duration",3600],"settings.token.refresh-token-time-to-live":["java.time.Duration",36000]}');
