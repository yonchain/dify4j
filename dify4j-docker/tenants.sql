INSERT INTO "public"."tenants" ("id", "name", "encrypt_public_key", "plan", "status", "created_at", "updated_at", "custom_config") VALUES ('29d181ca-9562-4cc2-a4f3-be605a728143', 'admin''s Workspace', '-----BEGIN PUBLIC KEY-----
MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEApC39RBhiSV62pKmDqNIH
Si961WrakhXqz8/+e7gY//lIlz1+m0LEkwRbEoM75nuHpl4743vBO+qO1qqlRQJu
q0FWuaeZB2Ht2h7k/TUnwKRKitUDsfd12pAwJV072tjM8AaX1xY9T46UOcPiuAmh
gXCz4/5qgBx+9m4flCxsUzNRqSZWLNZgOv9ohuM40d33yxnmF9Fmgbe6hQupGU5d
veNTHzyVhOcvBb9MgXz8/BMTQbMfDy5v16cGeyurTOGCXeIyXVUiJa+wOmmpZR+R
IZG0nW8j4eYxCFMB84Hrcrikc+kfhnX0l3t1Tb3rX3h/yHLittAbjfhvbR4qBzhW
EwIDAQAB
-----END PUBLIC KEY-----', 'basic', 'normal', '2025-07-25 03:54:35', '2025-07-25 03:54:35', NULL);


INSERT INTO "public"."accounts" ("id", "name", "email", "password", "password_salt", "avatar", "interface_language", "interface_theme", "timezone", "last_login_at", "last_login_ip", "status", "initialized_at", "created_at", "updated_at", "last_active_at") VALUES ('613c0ef6-eee8-4975-92e9-8552d4b12b21', 'admin', 'admin@dify4j.com', 'NTM1YjZlMjc2OThjN2M3OTNiMmNjMmVkZTIxMmFkMzA5NTBlZjYyMzVmNjk5NjEzMGFkY2UyMDM5YjZkMTI0Ng==', '1VWjOyNm70o3QrRextz1sw==', NULL, 'en-US', 'light', 'America/New_York', '2025-07-25 03:54:40.583615', '120.239.137.85', 'active', '2025-07-25 03:54:34.784722', '2025-07-25 03:54:35', '2025-07-25 03:54:35', '2025-07-25 03:54:35');


INSERT INTO "public"."tenant_account_joins" ("id", "tenant_id", "account_id", "role", "invited_by", "created_at", "updated_at", "current") VALUES ('39c8d043-4483-4a2f-ab67-a1af575d95c8', '29d181ca-9562-4cc2-a4f3-be605a728143', '613c0ef6-eee8-4975-92e9-8552d4b12b21', 'owner', NULL, '2025-07-25 03:54:36', '2025-07-25 03:54:36', 't');
