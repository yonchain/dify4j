-- 系统登录日志表(PostgreSQL版本)
CREATE TABLE sys_login_log (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    ip_address VARCHAR(50) NOT NULL,
    ip_region VARCHAR(100),
    login_time TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    device_type VARCHAR(20)
);

-- 表注释
COMMENT ON TABLE sys_login_log IS '系统登录日志表';
COMMENT ON COLUMN sys_login_log.id IS '主键ID';
COMMENT ON COLUMN sys_login_log.user_id IS '用户ID';
COMMENT ON COLUMN sys_login_log.ip_address IS '登录IP地址';
COMMENT ON COLUMN sys_login_log.ip_region IS 'IP所在地区';
COMMENT ON COLUMN sys_login_log.login_time IS '登录时间';
COMMENT ON COLUMN sys_login_log.device_type IS '登录终端类型';

-- 创建索引
CREATE INDEX idx_sys_login_log_user_id ON sys_login_log(user_id);
CREATE INDEX idx_sys_login_log_login_time ON sys_login_log(login_time);
