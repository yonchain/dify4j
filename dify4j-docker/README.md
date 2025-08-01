# Dify4j Docker部署指南

本文档提供了使用Docker Compose部署Dify4j的详细说明。

## 前提条件

- Docker 20.10 或更高版本
- Docker Compose 2.0 或更高版本
- 至少2GB RAM和4GB磁盘空间

## 快速部署

### 1. 克隆仓库

```bash
git clone https://github.com/yonchain/dify4j.git
cd dify4j/dify4j-docker
```

### 2. 配置环境变量

复制环境变量模板文件并修改配置：

```bash
cp .env.example .env
```

编辑`.env`文件，配置以下关键参数：
- `DB_USERNAME`: PostgreSQL数据库用户名
- `DB_PASSWORD`: PostgreSQL数据库密码
- `REDIS_PASSWORD`: Redis密码
- `VECTOR_STORE`: 向量数据库类型(weaviate/milvus/opensearch)
- `STORAGE_TYPE`: 存储类型(local/s3/azure)

### 3. 启动服务

```bash
docker compose up -d
```

### 4. 访问应用

应用将在 `http://localhost` 启动。

## 环境变量说明

### 数据库配置
- `DB_USERNAME`: PostgreSQL数据库用户名
- `DB_PASSWORD`: PostgreSQL数据库密码
- `DB_HOST`: PostgreSQL数据库主机名
- `DB_PORT`: PostgreSQL数据库端口
- `DB_DATABASE`: PostgreSQL数据库名称

### Redis配置
- `REDIS_HOST`: Redis主机名
- `REDIS_PORT`: Redis端口
- `REDIS_PASSWORD`: Redis密码

### 向量数据库配置
- `VECTOR_STORE`: 向量数据库类型(weaviate/milvus/opensearch)
- `WEAVIATE_ENDPOINT`: Weaviate端点URL
- `WEAVIATE_API_KEY`: Weaviate API密钥

### 存储配置
- `STORAGE_TYPE`: 存储类型(opendal)
- `OPENDAL_SCHEME`: OpenDAL存储方案(fs/s3/azure)
- `OPENDAL_FS_ROOT`: 文件系统存储根目录

### 应用配置
- `SECRET_KEY`: 应用密钥
- `INIT_PASSWORD`: 初始管理员密码

### 网络配置
- `NGINX_PORT`: Nginx HTTP端口
- `NGINX_SSL_PORT`: Nginx HTTPS端口
- `NGINX_HTTPS_ENABLED`: 是否启用HTTPS

## 数据持久化

Docker部署默认会将以下数据持久化：
- PostgreSQL数据存储在`./data/postgres`目录
- Redis数据存储在`./data/redis`目录
- 上传文件存储在`./storage`目录
- Weaviate数据存储在`./data/weaviate`目录

## 中间件部署(开发环境)

如果需要单独部署中间件服务(数据库、Redis等)用于开发：

```bash
docker compose -f docker-compose.middleware.yaml --profile weaviate -p dify up -d
```

## 常见问题

### 1. 如何更改默认端口？

编辑`.env`文件，修改`NGINX_PORT`和`NGINX_SSL_PORT`的值。

### 2. 如何备份数据？

数据库备份：
```bash
docker exec dify4j-postgres pg_dump -U postgres dify > backup.sql
```

### 3. 如何升级到新版本？

```bash
# 拉取最新代码
git pull

# 重新构建并启动容器
docker compose down
docker compose up -d
```

### 4. 如何查看日志？

```bash
# 查看所有服务的日志
docker compose logs

# 查看特定服务的日志
docker compose logs api
```

## 自定义配置

如果需要自定义配置，可以编辑`docker-compose.yaml`文件，根据需要修改服务配置。
