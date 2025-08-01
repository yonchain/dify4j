# 贡献指南

感谢您考虑为 Dify4j 项目做出贡献！以下是一些指导原则和流程，帮助您更有效地参与项目开发。

## 行为准则

参与本项目的所有贡献者都应遵循以下行为准则：

- 尊重所有参与者，不论其经验水平、性别、性取向、残疾、种族或宗教信仰
- 使用包容性语言
- 接受建设性批评
- 关注项目和社区的最佳利益
- 对其他社区成员表示同理心

## 如何贡献

### 报告 Bug

如果您发现了 Bug，请通过 GitHub Issues 报告，并包含以下信息：

1. 问题的简要描述
2. 重现步骤
3. 预期行为
4. 实际行为
5. 环境信息（操作系统、JDK 版本、Spring Boot 版本等）
6. 相关日志或截图

### 提出新功能

如果您有新功能的想法，请先通过 GitHub Issues 讨论，包含以下信息：

1. 功能的详细描述
2. 为什么这个功能对项目有价值
3. 如何实现（如果您有想法）

### 提交代码

1. Fork 项目仓库
2. 创建您的特性分支：`git checkout -b feature/amazing-feature`
3. 提交您的更改：`git commit -m 'Add some amazing feature'`
4. 推送到分支：`git push origin feature/amazing-feature`
5. 提交 Pull Request

### 代码风格

- 遵循 [Google Java 风格指南](https://google.github.io/styleguide/javaguide.html)
- 使用 4 个空格缩进
- 类名使用 PascalCase（首字母大写）
- 方法名和变量名使用 camelCase（首字母小写）
- 常量使用全大写，单词间用下划线分隔
- 添加适当的注释，特别是对于复杂的逻辑
- 确保代码通过所有测试

### 提交信息规范

提交信息应遵循以下格式：

```
<类型>(<范围>): <描述>

[可选的正文]

[可选的脚注]
```

类型包括：
- feat: 新功能
- fix: 修复 Bug
- docs: 文档更改
- style: 不影响代码含义的更改（空格、格式化等）
- refactor: 既不修复 Bug 也不添加功能的代码更改
- perf: 提高性能的代码更改
- test: 添加或修正测试
- chore: 对构建过程或辅助工具的更改

例如：
```
feat(idm): 添加用户角色管理功能

- 实现角色创建和分配
- 添加角色权限管理
- 更新用户服务以支持角色

Closes #123
```

## 开发流程

### 设置开发环境

1. 克隆仓库：
   ```bash
   git clone https://github.com/yonchain/dify4j.git
   cd dify4j
   ```

2. 安装依赖：
   ```bash
   mvn clean install
   ```

3. 运行测试：
   ```bash
   mvn test
   ```

### 分支策略

- `main`: 稳定分支，包含已发布的代码
- `develop`: 开发分支，包含下一个版本的代码
- `feature/*`: 特性分支，用于开发新功能
- `bugfix/*`: 修复分支，用于修复 Bug
- `release/*`: 发布分支，用于准备新版本发布

### 版本控制

我们使用 [语义化版本控制](https://semver.org/)：

- MAJOR 版本：当进行不兼容的 API 更改时
- MINOR 版本：当以向后兼容的方式添加功能时
- PATCH 版本：当进行向后兼容的 Bug 修复时

## 发布流程

1. 更新版本号（在 pom.xml 文件中）
2. 更新 CHANGELOG.md
3. 创建发布分支：`release/vX.Y.Z`
4. 提交发布分支
5. 创建 Pull Request 到 `main` 分支
6. 合并后，在 GitHub 上创建新的发布标签

## 代码审查

所有代码更改都需要通过代码审查。审查者将关注：

- 代码质量和风格
- 测试覆盖率
- 文档完整性
- 向后兼容性
- 性能影响

## 许可证

通过贡献代码，您同意您的贡献将根据项目的 Apache License 2.0 许可证进行许可。

## 联系方式

如有任何问题，请通过 GitHub Issues 或以下方式联系我们：

- 项目负责人：[Yonchain](mailto:hongkong92@163.com)
- 项目主页：[GitHub](https://gitee.com/yonchain-ai)

感谢您的贡献！
