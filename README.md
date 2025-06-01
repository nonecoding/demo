# Demo Spring Boot Application

## 项目简介

这是一个基于Spring Boot 2.6.13的演示项目，集成了多种技术栈，包括：

- **Spring Boot 2.6.13** - 主框架
- **MyBatis-Plus** - ORM框架
- **DM数据库** - 达梦数据库
- **Apache Kafka** - 消息队列
- **MinIO** - 对象存储
- **WebSocket** - 实时通信
- **Knife4j** - API文档

## 项目结构

```
src/
├── main/
│   ├── java/
│   │   └── com/example/demo/
│   │       ├── common/                 # 公共模块
│   │       │   ├── config/            # 配置类
│   │       │   ├── controller/        # 公共控制器
│   │       │   ├── exception/         # 异常处理
│   │       │   ├── response/          # 统一响应格式
│   │       │   └── utils/             # 工具类
│   │       └── demo1/                 # 业务模块
│   │           ├── controller/        # 控制器
│   │           ├── entities/          # 实体类
│   │           ├── mapper/            # 数据访问层
│   │           └── service/           # 服务层
│   └── resources/
│       ├── application.yml            # 配置文件
│       └── logback-spring.xml         # 日志配置
```

## 主要功能

### 1. 用户管理 (UserController)
- 创建用户
- 查询用户
- 更新用户
- 删除用户
- 用户列表

### 2. 文件管理 (MinioController)
- 文件上传
- 文件下载
- 文件删除
- 文件列表
- 批量上传

### 3. 消息队列 (KafkaController)
- 发送消息
- 指定主题发送

### 4. 健康检查 (HealthController)
- 应用状态检查
- Ping检查

## 技术特性

### 1. 统一响应格式
所有API返回统一的响应格式：
```json
{
  "code": 200,
  "message": "操作成功",
  "data": {},
  "timestamp": "2023-12-01T10:00:00"
}
```

### 2. 全局异常处理
- 业务异常处理
- 参数验证异常
- 系统异常处理
- 统一错误响应

### 3. 参数验证
- 使用JSR-303注解进行参数验证
- 自定义验证消息
- 统一验证异常处理

### 4. 日志管理
- 分环境日志配置
- 异步日志输出
- 错误日志单独记录
- SQL日志记录

### 5. 安全优化
- 文件类型限制
- 文件大小限制
- 参数验证
- 异常信息脱敏

## 环境要求

- JDK 8+
- Maven 3.6+
- DM数据库
- Apache Kafka
- MinIO

## 配置说明

### 数据库配置
```yaml
spring:
  datasource:
    url: jdbc:dm://localhost:5236/TESTDB
    username: SYSDBA
    password: SYSDBA
    driver-class-name: dm.jdbc.driver.DmDriver
```

### Kafka配置
```yaml
spring:
  kafka:
    bootstrap-servers: localhost:9092
    producer:
      retries: 3
    consumer:
      group-id: my-consumer-group
```

### MinIO配置
```yaml
spring:
  minio:
    url: http://localhost:9000
    access-key: minioadmin
    secret-key: minioadmin
    bucket: demo-bucket
```

## 启动方式

1. 确保所有依赖服务已启动（数据库、Kafka、MinIO）
2. 运行主类：`Demo1Application`
3. 访问API文档：http://localhost:8089/doc.html

## API文档

项目集成了Knife4j，启动后可访问：
- Swagger UI: http://localhost:8089/doc.html
- API JSON: http://localhost:8089/v2/api-docs

## 主要优化点

### 1. 代码质量
- 使用Lombok减少样板代码
- 统一依赖注入方式（构造器注入）
- 添加详细的JavaDoc注释
- 规范的包结构和命名

### 2. 异常处理
- 全局异常处理器
- 自定义业务异常
- 统一错误响应格式
- 异常日志记录

### 3. 性能优化
- 数据库连接池配置
- 异步日志输出
- 文件流式处理
- 缓存配置

### 4. 安全性
- 参数验证
- 文件上传限制
- 敏感信息配置化
- 错误信息脱敏

### 5. 可维护性
- 分层架构
- 配置外部化
- 日志分级管理
- 健康检查接口

## 开发规范

### 1. 代码规范
- 使用统一的代码格式
- 添加必要的注释
- 遵循RESTful API设计
- 使用有意义的变量名

### 2. 异常处理
- 业务异常使用BusinessException
- 记录详细的错误日志
- 返回用户友好的错误信息

### 3. 日志规范
- 使用SLF4J进行日志记录
- 区分不同级别的日志
- 记录关键操作和异常

### 4. 测试规范
- 编写单元测试
- 集成测试覆盖
- 性能测试验证

## 部署说明

### 1. 环境变量
```bash
export SERVER_PORT=8089
export DB_URL=jdbc:dm://localhost:5236/TESTDB
export KAFKA_BOOTSTRAP_SERVERS=localhost:9092
export MINIO_URL=http://localhost:9000
```

### 2. Docker部署
```dockerfile
FROM openjdk:8-jre-alpine
COPY target/demo-1.0.0.jar app.jar
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "/app.jar"]
```

### 3. 监控配置
- 应用监控：Spring Boot Actuator
- 日志监控：ELK Stack
- 性能监控：Micrometer + Prometheus

## 常见问题

### 1. 数据库连接失败
- 检查数据库服务是否启动
- 验证连接参数是否正确
- 确认网络连通性

### 2. Kafka连接失败
- 检查Kafka服务状态
- 验证bootstrap-servers配置
- 确认主题是否存在

### 3. MinIO连接失败
- 检查MinIO服务状态
- 验证访问密钥配置
- 确认桶是否存在

## 版本历史

- v1.0.0 - 初始版本，基础功能实现
- v1.1.0 - 代码优化，添加全局异常处理
- v1.2.0 - 性能优化，安全性增强

## 贡献指南

1. Fork项目
2. 创建功能分支
3. 提交代码
4. 创建Pull Request

## 许可证

MIT License

![img](https://cdn.nlark.com/yuque/0/2022/png/27683667/1665994390645-292d9d08-3927-4a96-8d4a-0c8a653d0b45.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_18%2Ctext_6buR6ams56iL5bqP5ZGYwrfnoJTnqbbpmaI%3D%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

2 What is God's provision?
==========================

Shenling Logistics is a \*\*\[production-level\]\*\* logistics project system based on microservice architecture system. This may be the project course closest to the real scene of the enterprise that you can learn at present. Its business integrity, authenticity and complexity will surprise you. Here you will learn the most core logistics scheduling system. You can also learn to develop and solve related problems under complex microservice architecture system. And then you're going to get a "wow".

2.1 Company Profile
-------------------

Since 2019, the company has expanded its business rapidly, expanding the number of outlets from 138 to 540, and the number of vehicles from 170 to 800. At the same time, the original system is very simple. For example, vehicle scheduling relies on manual operation, all goods sorting relies on personnel, and core order data is manually entered, so the human efficiency is very low.

With the continuous evolution of business and continuous improvement of technology, the original transportation management system can no longer meet the business requirements under the current rapid expansion, but after evaluating the existing system, it is found that the cost of upgrading the system is much higher than that of re-development.

Therefore, the company decided to rebuild the existing business system and create a new TMS transportation system to replace the original system directly. The business focuses on displaying core business processes such as vehicle research and route planning, and the operation is intelligent, which greatly improves human efficiency and control efficiency.

2.2 Organizational structure
----------------------------

![img](https://cdn.nlark.com/yuque/0/2022/jpeg/27683667/1665996673705-67f5f038-4e74-4205-8cfc-ee8dd1b4ee66.jpeg)

The first-level department where Java developers belong is the information center, which is mainly responsible for the research and development, maintenance and update iteration of the new system of the group. The Information Center consists of three Level 2 departments, namely Product Department, Operation and Maintenance Department and Development Department. The Development Department has a total of 42 people, which are divided into 4 groups according to business lines, including TMS Project Group, WMS Project Group, OMS Project Group and CRM Group.

The TMS(Transportation Management System) project team currently has a total of 8 people, including 3 front-end and 5 back-end. Back-end personnel divide tasks according to the following functional modules. In actual business, it is impossible for one person to take care of the whole world. Division of labor and cooperation is the normal operation.

2.3 Product description
-----------------------

Shenling logistics system is similar to SF Express, which is a system that provides express delivery service to C-end users. Competitors include: Shunfeng, Zhongtong, Yuantong, Jingdong Express, etc.

The project products mainly have 4 end products:

*   User end: developed based on Weixin Mini Programs, used by external customers, can send mail, query logistics information, etc.

*   Courier terminal: Mobile APP developed based on Android, used by internal couriers of the company, can receive delivery tasks, etc.

*   Driver end: Mobile APP developed based on Android, used by drivers in the company, can receive transportation tasks, report location information, etc.

*   Background system management: based on vue development, PC use, internal administrator user use, can carry out basic data maintenance, order management, waybill management, etc.


3\. Logistics industry system
=============================

In terms of breadth, logistics system can be understood as composed of multiple subsystems. Here we take general integrated logistics system as an example. In the overall framework, it can be divided into warehouse system WMS, transportation and distribution system TMS, document system OMS and billing system BMS.

These four systems essentially solve the four core problems of the logistics industry: how to store, how to transport, how to follow up, and how to settle.

Shenling logistics system is TMS transportation and distribution system, which essentially solves the problem of how to transport.

![img](https://cdn.nlark.com/yuque/0/2022/png/27683667/1666843467766-309e2f8f-1fc0-4f05-ba11-3142f542929c.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_77%2Ctext_6buR6ams56iL5bqP5ZGYwrfnoJTnqbbpmaI%3D%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

4\. System architecture and technical architecture
==================================================

4.1, system architecture
------------------------

![img](https://cdn.nlark.com/yuque/0/2022/jpeg/27683667/1665997407045-5b9ee5fe-d30b-4cec-a5a9-599f5a8ee6bd.jpeg)

4.2, technical architecture
---------------------------

The following figure shows the main technologies used in the Shenling logistics project:

![img](https://cdn.nlark.com/yuque/0/2022/jpeg/27683667/1665997873162-a4c9ea61-f71e-4111-862e-efa01fd35e7b.jpeg)

5\. Function demonstration
==========================

5.1 Requirements document
-------------------------

The main functions of the four terminals will be demonstrated below. For more functions, please see the requirements documents of each terminal.

<table data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2"><thead data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2"><tr data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2"><th data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2" data-immersive-translate-paragraph="1"><font class="notranslate immersive-translate-target-wrapper" data-immersive-translate-translation-element-mark="1" lang="en"><br><font class="notranslate immersive-translate-target-translation-theme-none immersive-translate-target-translation-block-wrapper-theme-none immersive-translate-target-translation-block-wrapper" data-immersive-translate-translation-element-mark="1"><font class="notranslate immersive-translate-target-inner immersive-translate-target-translation-theme-none-inner" data-immersive-translate-translation-element-mark="1">user side</font></font></font></th><th data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2" data-immersive-translate-paragraph="1"><a href="https://share.lanhuapp.com/#/invite?sid=qx01hbI7" data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2">https://share.lanhuapp.com/#/invite?sid=qx01hbI7</a> 密码: UxGE</th></tr></thead><tbody data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2"><tr data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2"><td data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2" data-immersive-translate-paragraph="1"><font class="notranslate immersive-translate-target-wrapper" data-immersive-translate-translation-element-mark="1" lang="en"><br><font class="notranslate immersive-translate-target-translation-theme-none immersive-translate-target-translation-block-wrapper-theme-none immersive-translate-target-translation-block-wrapper" data-immersive-translate-translation-element-mark="1"><font class="notranslate immersive-translate-target-inner immersive-translate-target-translation-theme-none-inner" data-immersive-translate-translation-element-mark="1">courier terminal</font></font></font></td><td data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2" data-immersive-translate-paragraph="1"><a href="https://share.lanhuapp.com/#/invite?sid=qxe42Dya" data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2">https://share.lanhuapp.com/#/invite?sid=qxe42Dya</a> 密码: Nomz</td></tr><tr data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2"><td data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2" data-immersive-translate-paragraph="1"><font class="notranslate immersive-translate-target-wrapper" data-immersive-translate-translation-element-mark="1" lang="en"><br><font class="notranslate immersive-translate-target-translation-theme-none immersive-translate-target-translation-block-wrapper-theme-none immersive-translate-target-translation-block-wrapper" data-immersive-translate-translation-element-mark="1"><font class="notranslate immersive-translate-target-inner immersive-translate-target-translation-theme-none-inner" data-immersive-translate-translation-element-mark="1">driver's side</font></font></font></td><td data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2" data-immersive-translate-paragraph="1"><a href="https://share.lanhuapp.com/#/invite?sid=qX0NEmro" data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2">https://share.lanhuapp.com/#/invite?sid=qX0NEmro</a> 密码: yrzZ</td></tr><tr data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2"><td data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2" data-immersive-translate-paragraph="1"><font class="notranslate immersive-translate-target-wrapper" data-immersive-translate-translation-element-mark="1" lang="en"><br><font class="notranslate immersive-translate-target-translation-theme-none immersive-translate-target-translation-block-wrapper-theme-none immersive-translate-target-translation-block-wrapper" data-immersive-translate-translation-element-mark="1"><font class="notranslate immersive-translate-target-inner immersive-translate-target-translation-theme-none-inner" data-immersive-translate-translation-element-mark="1">management end</font></font></font></td><td data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2" data-immersive-translate-paragraph="1"><a href="https://share.lanhuapp.com/#/invite?sid=qX0axVem" data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2">https://share.lanhuapp.com/#/invite?sid=qX0axVem</a> 密码: fh3i</td></tr></tbody></table>

5.2 Functional architecture
---------------------------

![img](https://cdn.nlark.com/yuque/0/2022/jpeg/27683667/1672389615739-d11e9b27-5241-49e4-bd52-2374f32a38be.jpeg)

5.3 Business function process
-----------------------------

![img](https://cdn.nlark.com/yuque/0/2022/jpeg/27683667/1667813584952-24320691-7837-4c72-97c1-2d99b7da71fe.jpeg)

Process Description:

*   After the user places an order in \*\*\[Client\]\*\*, an order is generated.
*   The system will generate \*\*\[Pick-up Task\] according to the order, and generate \[Waybill\]\*\* after the courier successfully picks up the item.
*   When the user pays for the order, \*\*\[Transaction Order\]\*\* will be generated.
*   Express starts transportation, and it will go through the transshipment transportation among the initial business department, sorting center, transfer center, sorting center and terminal business department. During this period, there will be multiple \*\*\[transportation tasks\]\*\*
*   After arriving at the destination network, the system will generate \*\*\[Delivery Task\]\*\*, and the courier will carry out the delivery operation.
*   Finally, the user will sign in or reject

5.4, client
-----------

Function demonstration operation video list:

<table data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2"><thead data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2"><tr data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2"><th data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2" data-immersive-translate-paragraph="1"><font class="notranslate immersive-translate-target-wrapper" data-immersive-translate-translation-element-mark="1" lang="en"><br><font class="notranslate immersive-translate-target-translation-theme-none immersive-translate-target-translation-block-wrapper-theme-none immersive-translate-target-translation-block-wrapper" data-immersive-translate-translation-element-mark="1"><font class="notranslate immersive-translate-target-inner immersive-translate-target-translation-theme-none-inner" data-immersive-translate-translation-element-mark="1">Order operation</font></font></font></th><th data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2"><a href="https://yjy-slwl-oss.oss-cn-hangzhou.aliyuncs.com/0c8fc60a-2cf5-4140-9592-124cb3352fd0.mp4" data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2" data-immersive-translate-paragraph="1"><font class="notranslate immersive-translate-target-wrapper" data-immersive-translate-translation-element-mark="1" lang="en"><br><font class="notranslate immersive-translate-target-translation-theme-none immersive-translate-target-translation-block-wrapper-theme-none immersive-translate-target-translation-block-wrapper" data-immersive-translate-translation-element-mark="1"><font class="notranslate immersive-translate-target-inner immersive-translate-target-translation-theme-none-inner" data-immersive-translate-translation-element-mark="1">click to view</font></font></font></a></th></tr></thead><tbody data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2"><tr data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2"><td data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2" data-immersive-translate-paragraph="1"><font class="notranslate immersive-translate-target-wrapper" data-immersive-translate-translation-element-mark="1" lang="en"><br><font class="notranslate immersive-translate-target-translation-theme-none immersive-translate-target-translation-block-wrapper-theme-none immersive-translate-target-translation-block-wrapper" data-immersive-translate-translation-element-mark="1"><font class="notranslate immersive-translate-target-inner immersive-translate-target-translation-theme-none-inner" data-immersive-translate-translation-element-mark="1">cancel the order</font></font></font></td><td data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2"><a href="https://yjy-slwl-oss.oss-cn-hangzhou.aliyuncs.com/efd2553b-69ab-4ec1-ad71-f0fd27c84165.mp4" data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2" data-immersive-translate-paragraph="1"><font class="notranslate immersive-translate-target-wrapper" data-immersive-translate-translation-element-mark="1" lang="en"><br><font class="notranslate immersive-translate-target-translation-theme-none immersive-translate-target-translation-block-wrapper-theme-none immersive-translate-target-translation-block-wrapper" data-immersive-translate-translation-element-mark="1"><font class="notranslate immersive-translate-target-inner immersive-translate-target-translation-theme-none-inner" data-immersive-translate-translation-element-mark="1">click to view</font></font></font></a></td></tr><tr data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2"><td data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2" data-immersive-translate-paragraph="1"><font class="notranslate immersive-translate-target-wrapper" data-immersive-translate-translation-element-mark="1" lang="en"><br><font class="notranslate immersive-translate-target-translation-theme-none immersive-translate-target-translation-block-wrapper-theme-none immersive-translate-target-translation-block-wrapper" data-immersive-translate-translation-element-mark="1"><font class="notranslate immersive-translate-target-inner immersive-translate-target-translation-theme-none-inner" data-immersive-translate-translation-element-mark="1">address book</font></font></font></td><td data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2"><a href="https://yjy-slwl-oss.oss-cn-hangzhou.aliyuncs.com/1fcbdd1e-70bc-461c-9b0e-60ec75edbabb.mp4" data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2" data-immersive-translate-paragraph="1"><font class="notranslate immersive-translate-target-wrapper" data-immersive-translate-translation-element-mark="1" lang="en"><br><font class="notranslate immersive-translate-target-translation-theme-none immersive-translate-target-translation-block-wrapper-theme-none immersive-translate-target-translation-block-wrapper" data-immersive-translate-translation-element-mark="1"><font class="notranslate immersive-translate-target-inner immersive-translate-target-translation-theme-none-inner" data-immersive-translate-translation-element-mark="1">click to view</font></font></font></a></td></tr></tbody></table>

![用户下单](https://cdn.nlark.com/yuque/0/2022/png/27683667/1666145111077-c453ef4e-3165-4085-8b70-f38c82be3d1a.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_12%2Ctext_6buR6ams56iL5bqP5ZGYwrfnoJTnqbbpmaI%3D%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

![估算运费](https://cdn.nlark.com/yuque/0/2022/png/27683667/1666145242663-e0a704ba-dcfa-4f99-a25f-1b7a3ec5f119.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_12%2Ctext_6buR6ams56iL5bqP5ZGYwrfnoJTnqbbpmaI%3D%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

![下单成功](https://cdn.nlark.com/yuque/0/2022/png/27683667/1666145268551-72b01391-9f65-4a87-90c5-23cb3ffecaa6.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_12%2Ctext_6buR6ams56iL5bqP5ZGYwrfnoJTnqbbpmaI%3D%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

5.5 Courier end
---------------

Function demonstration operation video list:

<table data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2"><thead data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2"><tr data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2"><th data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2" data-immersive-translate-paragraph="1"><font class="notranslate immersive-translate-target-wrapper" data-immersive-translate-translation-element-mark="1" lang="en"><br><font class="notranslate immersive-translate-target-translation-theme-none immersive-translate-target-translation-block-wrapper-theme-none immersive-translate-target-translation-block-wrapper" data-immersive-translate-translation-element-mark="1"><font class="notranslate immersive-translate-target-inner immersive-translate-target-translation-theme-none-inner" data-immersive-translate-translation-element-mark="1">Delivery operation flow</font></font></font></th><th data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2"><a href="https://yjy-slwl-oss.oss-cn-hangzhou.aliyuncs.com/7bb3000d-69b8-473f-9d6b-d391b8c28a9f.mp4" data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2" data-immersive-translate-paragraph="1"><font class="notranslate immersive-translate-target-wrapper" data-immersive-translate-translation-element-mark="1" lang="en"><br><font class="notranslate immersive-translate-target-translation-theme-none immersive-translate-target-translation-block-wrapper-theme-none immersive-translate-target-translation-block-wrapper" data-immersive-translate-translation-element-mark="1"><font class="notranslate immersive-translate-target-inner immersive-translate-target-translation-theme-none-inner" data-immersive-translate-translation-element-mark="1">click to view</font></font></font></a></th></tr></thead><tbody data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2"><tr data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2"><td data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2" data-immersive-translate-paragraph="1"><font class="notranslate immersive-translate-target-wrapper" data-immersive-translate-translation-element-mark="1" lang="en"><br><font class="notranslate immersive-translate-target-translation-theme-none immersive-translate-target-translation-block-wrapper-theme-none immersive-translate-target-translation-block-wrapper" data-immersive-translate-translation-element-mark="1"><font class="notranslate immersive-translate-target-inner immersive-translate-target-translation-theme-none-inner" data-immersive-translate-translation-element-mark="1">Fetch operation flow</font></font></font></td><td data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2"><a href="https://yjy-slwl-oss.oss-cn-hangzhou.aliyuncs.com/7767cda8-8e83-4c5c-a976-634815ec0a10.mp4" data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2" data-immersive-translate-paragraph="1"><font class="notranslate immersive-translate-target-wrapper" data-immersive-translate-translation-element-mark="1" lang="en"><br><font class="notranslate immersive-translate-target-translation-theme-none immersive-translate-target-translation-block-wrapper-theme-none immersive-translate-target-translation-block-wrapper" data-immersive-translate-translation-element-mark="1"><font class="notranslate immersive-translate-target-inner immersive-translate-target-translation-theme-none-inner" data-immersive-translate-translation-element-mark="1">click to view</font></font></font></a></td></tr><tr data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2"><td data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2" data-immersive-translate-paragraph="1"><font class="notranslate immersive-translate-target-wrapper" data-immersive-translate-translation-element-mark="1" lang="en"><br><font class="notranslate immersive-translate-target-translation-theme-none immersive-translate-target-translation-block-wrapper-theme-none immersive-translate-target-translation-block-wrapper" data-immersive-translate-translation-element-mark="1"><font class="notranslate immersive-translate-target-inner immersive-translate-target-translation-theme-none-inner" data-immersive-translate-translation-element-mark="1">Operation flow of all picking and dispatching</font></font></font></td><td data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2"><a href="https://outin-ffd84744973f11eb806300163e038793.oss-cn-beijing.aliyuncs.com/sv/605f258-1844feb861d/605f258-1844feb861d.mp4" data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2" data-immersive-translate-paragraph="1"><font class="notranslate immersive-translate-target-wrapper" data-immersive-translate-translation-element-mark="1" lang="en"><br><font class="notranslate immersive-translate-target-translation-theme-none immersive-translate-target-translation-block-wrapper-theme-none immersive-translate-target-translation-block-wrapper" data-immersive-translate-translation-element-mark="1"><font class="notranslate immersive-translate-target-inner immersive-translate-target-translation-theme-none-inner" data-immersive-translate-translation-element-mark="1">click to view</font></font></font></a></td></tr><tr data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2"><td data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2" data-immersive-translate-paragraph="1"><font class="notranslate immersive-translate-target-wrapper" data-immersive-translate-translation-element-mark="1" lang="en"><br><font class="notranslate immersive-translate-target-translation-theme-none immersive-translate-target-translation-block-wrapper-theme-none immersive-translate-target-translation-block-wrapper" data-immersive-translate-translation-element-mark="1"><font class="notranslate immersive-translate-target-inner immersive-translate-target-translation-theme-none-inner" data-immersive-translate-translation-element-mark="1">Search operation flow</font></font></font></td><td data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2"><a href="https://outin-ffd84744973f11eb806300163e038793.oss-cn-beijing.aliyuncs.com/sv/60a0b1bf-1845000a4d0/60a0b1bf-1845000a4d0.mp4" data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2" data-immersive-translate-paragraph="1"><font class="notranslate immersive-translate-target-wrapper" data-immersive-translate-translation-element-mark="1" lang="en"><br><font class="notranslate immersive-translate-target-translation-theme-none immersive-translate-target-translation-block-wrapper-theme-none immersive-translate-target-translation-block-wrapper" data-immersive-translate-translation-element-mark="1"><font class="notranslate immersive-translate-target-inner immersive-translate-target-translation-theme-none-inner" data-immersive-translate-translation-element-mark="1">click to view</font></font></font></a></td></tr><tr data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2"><td data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2" data-immersive-translate-paragraph="1"><font class="notranslate immersive-translate-target-wrapper" data-immersive-translate-translation-element-mark="1" lang="en"><br><font class="notranslate immersive-translate-target-translation-theme-none immersive-translate-target-translation-block-wrapper-theme-none immersive-translate-target-translation-block-wrapper" data-immersive-translate-translation-element-mark="1"><font class="notranslate immersive-translate-target-inner immersive-translate-target-translation-theme-none-inner" data-immersive-translate-translation-element-mark="1">Message operation flow</font></font></font></td><td data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2"><a href="https://outin-ffd84744973f11eb806300163e038793.oss-cn-beijing.aliyuncs.com/sv/38c12638-18450c563db/38c12638-18450c563db.mp4" data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2" data-immersive-translate-paragraph="1"><font class="notranslate immersive-translate-target-wrapper" data-immersive-translate-translation-element-mark="1" lang="en"><br><font class="notranslate immersive-translate-target-translation-theme-none immersive-translate-target-translation-block-wrapper-theme-none immersive-translate-target-translation-block-wrapper" data-immersive-translate-translation-element-mark="1"><font class="notranslate immersive-translate-target-inner immersive-translate-target-translation-theme-none-inner" data-immersive-translate-translation-element-mark="1">click to view</font></font></font></a></td></tr></tbody></table>

![取件任务列表](https://cdn.nlark.com/yuque/0/2022/png/27683667/1666147847509-b0623617-3ea2-4293-b9a0-7ba0dc51e076.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_21%2Ctext_6buR6ams56iL5bqP5ZGYwrfnoJTnqbbpmaI%3D%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

![去取件](https://cdn.nlark.com/yuque/0/2022/png/27683667/1666147783779-ced836d1-62c2-4fac-aa26-9cf6e5180138.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_21%2Ctext_6buR6ams56iL5bqP5ZGYwrfnoJTnqbbpmaI%3D%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

![扫描支付](https://cdn.nlark.com/yuque/0/2022/png/27683667/1666148205970-20236142-d3aa-455a-8b18-0b5438d6b4e5.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_21%2Ctext_6buR6ams56iL5bqP5ZGYwrfnoJTnqbbpmaI%3D%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

![取件成功](https://cdn.nlark.com/yuque/0/2022/png/27683667/1666148251950-460e944c-26a7-47d2-819f-6bb03022d98b.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_21%2Ctext_6buR6ams56iL5bqP5ZGYwrfnoJTnqbbpmaI%3D%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

5.6, driver end
---------------

[Click to view demo video](https://outin-ffd84744973f11eb806300163e038793.oss-cn-beijing.aliyuncs.com/sv/4ffdd092-184501a12ff/4ffdd092-184501a12ff.mp4)

![司机运输任务](https://cdn.nlark.com/yuque/0/2022/png/27683667/1666148843502-dbfb5e33-0aec-43be-992a-1005cf84d63d.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_21%2Ctext_6buR6ams56iL5bqP5ZGYwrfnoJTnqbbpmaI%3D%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

![任务详情](https://cdn.nlark.com/yuque/0/2022/png/27683667/1666148927871-7a8bfa02-3a6f-4c9a-86f8-ae2355750ee1.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_21%2Ctext_6buR6ams56iL5bqP5ZGYwrfnoJTnqbbpmaI%3D%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

![提货成功（运输开始）](https://cdn.nlark.com/yuque/0/2022/png/27683667/1666149092451-d7eb65a3-f0dc-4a9e-b1b3-147a265d126f.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_21%2Ctext_6buR6ams56iL5bqP5ZGYwrfnoJTnqbbpmaI%3D%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

![到达目的地](https://cdn.nlark.com/yuque/0/2022/png/27683667/1666149148556-d9866b4c-746e-470d-a536-ef4e8298a9d8.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_21%2Ctext_6buR6ams56iL5bqP5ZGYwrfnoJTnqbbpmaI%3D%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

![如果有异常可以进行上报](https://cdn.nlark.com/yuque/0/2022/png/27683667/1666149017437-ff6a070b-8562-4daa-8876-67e72b0f8554.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_21%2Ctext_6buR6ams56iL5bqP5ZGYwrfnoJTnqbbpmaI%3D%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

5.7 Background management system
--------------------------------

Function demonstration operation video list:

<table data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2"><thead data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2"><tr data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2"><th data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2" data-immersive-translate-paragraph="1"><font class="notranslate immersive-translate-target-wrapper" data-immersive-translate-translation-element-mark="1" lang="en"><br><font class="notranslate immersive-translate-target-translation-theme-none immersive-translate-target-translation-block-wrapper-theme-none immersive-translate-target-translation-block-wrapper" data-immersive-translate-translation-element-mark="1"><font class="notranslate immersive-translate-target-inner immersive-translate-target-translation-theme-none-inner" data-immersive-translate-translation-element-mark="1">institution-building</font></font></font></th><th data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2"><a href="https://yjy-slwl-oss.oss-cn-hangzhou.aliyuncs.com/44443260-b57f-41f8-a1f2-22c44b1c16c1.mp4" data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2" data-immersive-translate-paragraph="1"><font class="notranslate immersive-translate-target-wrapper" data-immersive-translate-translation-element-mark="1" lang="en"><br><font class="notranslate immersive-translate-target-translation-theme-none immersive-translate-target-translation-block-wrapper-theme-none immersive-translate-target-translation-block-wrapper" data-immersive-translate-translation-element-mark="1"><font class="notranslate immersive-translate-target-inner immersive-translate-target-translation-theme-none-inner" data-immersive-translate-translation-element-mark="1">click to view</font></font></font></a></th></tr></thead><tbody data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2"><tr data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2"><td data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2" data-immersive-translate-paragraph="1"><font class="notranslate immersive-translate-target-wrapper" data-immersive-translate-translation-element-mark="1" lang="en"><br><font class="notranslate immersive-translate-target-translation-theme-none immersive-translate-target-translation-block-wrapper-theme-none immersive-translate-target-translation-block-wrapper" data-immersive-translate-translation-element-mark="1"><font class="notranslate immersive-translate-target-inner immersive-translate-target-translation-theme-none-inner" data-immersive-translate-translation-element-mark="1">new employee</font></font></font></td><td data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2"><a href="https://yjy-slwl-oss.oss-cn-hangzhou.aliyuncs.com/ab24e727-9c1f-458c-a8c3-b2d3cbfce46d.mp4" data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2" data-immersive-translate-paragraph="1"><font class="notranslate immersive-translate-target-wrapper" data-immersive-translate-translation-element-mark="1" lang="en"><br><font class="notranslate immersive-translate-target-translation-theme-none immersive-translate-target-translation-block-wrapper-theme-none immersive-translate-target-translation-block-wrapper" data-immersive-translate-translation-element-mark="1"><font class="notranslate immersive-translate-target-inner immersive-translate-target-translation-theme-none-inner" data-immersive-translate-translation-element-mark="1">click to view</font></font></font></a></td></tr><tr data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2"><td data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2" data-immersive-translate-paragraph="1"><font class="notranslate immersive-translate-target-wrapper" data-immersive-translate-translation-element-mark="1" lang="en"><br><font class="notranslate immersive-translate-target-translation-theme-none immersive-translate-target-translation-block-wrapper-theme-none immersive-translate-target-translation-block-wrapper" data-immersive-translate-translation-element-mark="1"><font class="notranslate immersive-translate-target-inner immersive-translate-target-translation-theme-none-inner" data-immersive-translate-translation-element-mark="1">Draw job scope</font></font></font></td><td data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2"><a href="https://yjy-slwl-oss.oss-cn-hangzhou.aliyuncs.com/9a1e3679-38eb-4585-b41b-7d9277dc1da0.mp4" data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2" data-immersive-translate-paragraph="1"><font class="notranslate immersive-translate-target-wrapper" data-immersive-translate-translation-element-mark="1" lang="en"><br><font class="notranslate immersive-translate-target-translation-theme-none immersive-translate-target-translation-block-wrapper-theme-none immersive-translate-target-translation-block-wrapper" data-immersive-translate-translation-element-mark="1"><font class="notranslate immersive-translate-target-inner immersive-translate-target-translation-theme-none-inner" data-immersive-translate-translation-element-mark="1">click to view</font></font></font></a></td></tr><tr data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2"><td data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2" data-immersive-translate-paragraph="1"><font class="notranslate immersive-translate-target-wrapper" data-immersive-translate-translation-element-mark="1" lang="en"><br><font class="notranslate immersive-translate-target-translation-theme-none immersive-translate-target-translation-block-wrapper-theme-none immersive-translate-target-translation-block-wrapper" data-immersive-translate-translation-element-mark="1"><font class="notranslate immersive-translate-target-inner immersive-translate-target-translation-theme-none-inner" data-immersive-translate-translation-element-mark="1">new lines</font></font></font></td><td data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2"><a href="https://yjy-slwl-oss.oss-cn-hangzhou.aliyuncs.com/cd62d82c-7910-4df0-835b-08854ecb0e79.mp4" data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2" data-immersive-translate-paragraph="1"><font class="notranslate immersive-translate-target-wrapper" data-immersive-translate-translation-element-mark="1" lang="en"><br><font class="notranslate immersive-translate-target-translation-theme-none immersive-translate-target-translation-block-wrapper-theme-none immersive-translate-target-translation-block-wrapper" data-immersive-translate-translation-element-mark="1"><font class="notranslate immersive-translate-target-inner immersive-translate-target-translation-theme-none-inner" data-immersive-translate-translation-element-mark="1">click to view</font></font></font></a></td></tr><tr data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2"><td data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2" data-immersive-translate-paragraph="1"><font class="notranslate immersive-translate-target-wrapper" data-immersive-translate-translation-element-mark="1" lang="en"><br><font class="notranslate immersive-translate-target-translation-theme-none immersive-translate-target-translation-block-wrapper-theme-none immersive-translate-target-translation-block-wrapper" data-immersive-translate-translation-element-mark="1"><font class="notranslate immersive-translate-target-inner immersive-translate-target-translation-theme-none-inner" data-immersive-translate-translation-element-mark="1">activating the vehicle</font></font></font></td><td data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2"><a href="https://yjy-slwl-oss.oss-cn-hangzhou.aliyuncs.com/5d8adc94-201f-43ee-8ef1-7906e5d8f272.mp4" data-immersive-translate-walked="0981d0fd-5945-493e-bb6f-c12d6c9330b2" data-immersive-translate-paragraph="1"><font class="notranslate immersive-translate-target-wrapper" data-immersive-translate-translation-element-mark="1" lang="en"><br><font class="notranslate immersive-translate-target-translation-theme-none immersive-translate-target-translation-block-wrapper-theme-none immersive-translate-target-translation-block-wrapper" data-immersive-translate-translation-element-mark="1"><font class="notranslate immersive-translate-target-inner immersive-translate-target-translation-theme-none-inner" data-immersive-translate-translation-element-mark="1">click to view</font></font></font></a></td></tr></tbody></table>

![工作台](https://cdn.nlark.com/yuque/0/2023/png/28217986/1673680992033-4e0d2021-7318-4667-8243-b980711e2cdf.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_54%2Ctext_6buR6ams56iL5bqP5ZGYwrfnoJTnqbbpmaI%3D%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)![车辆管理](https://cdn.nlark.com/yuque/0/2023/png/28217986/1673681344577-4f59ebcc-4b21-4076-ba64-ef1bee8bb22c.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_54%2Ctext_6buR6ams56iL5bqP5ZGYwrfnoJTnqbbpmaI%3D%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

![订单管理](https://cdn.nlark.com/yuque/0/2023/png/28217986/1673681441709-cd4f06cb-b65f-45c0-a9e4-da18b0da2a0d.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_54%2Ctext_6buR6ams56iL5bqP5ZGYwrfnoJTnqbbpmaI%3D%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

![司机管理](https://cdn.nlark.com/yuque/0/2023/png/28217986/1673681517364-16df33a4-9a48-405d-be13-2c9214ee8028.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_54%2Ctext_6buR6ams56iL5bqP5ZGYwrfnoJTnqbbpmaI%3D%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

![排班管理](https://cdn.nlark.com/yuque/0/2023/png/28217986/1673681584167-010c4de4-a89a-4db1-8913-c77b7bfb302c.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_54%2Ctext_6buR6ams56iL5bqP5ZGYwrfnoJTnqbbpmaI%3D%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

![运输任务管理](https://cdn.nlark.com/yuque/0/2023/png/28217986/1673681630034-08d98831-7274-4cab-a0e8-826ca34e62bf.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_54%2Ctext_6buR6ams56iL5bqP5ZGYwrfnoJTnqbbpmaI%3D%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

![线路管理](https://cdn.nlark.com/yuque/0/2023/png/28217986/1673681710302-70138a00-4dc0-44ba-90d4-fcb2d7226ed4.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_54%2Ctext_6buR6ams56iL5bqP5ZGYwrfnoJTnqbbpmaI%3D%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

![运单管理](https://cdn.nlark.com/yuque/0/2023/png/28217986/1673681799739-d8cccc7a-2d0f-4d99-9ed5-4a2e5eadeffc.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_53%2Ctext_6buR6ams56iL5bqP5ZGYwrfnoJTnqbbpmaI%3D%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

![机构管理](https://cdn.nlark.com/yuque/0/2023/png/28217986/1673681882850-4e26eb0c-532c-499e-8d70-56b1b05c4fe4.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_54%2Ctext_6buR6ams56iL5bqP5ZGYwrfnoJTnqbbpmaI%3D%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

![运费管理](https://cdn.nlark.com/yuque/0/2023/png/28217986/1673681922716-5a9002a3-4cf4-4048-b9ae-85d76445bf68.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_54%2Ctext_6buR6ams56iL5bqP5ZGYwrfnoJTnqbbpmaI%3D%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)

6\. Development environment
===========================

6.1 Development model
---------------------

In the Shenling logistics development team, the mode of group collaborative development is adopted. The whole development team is divided into 5 groups, each group has 4~5 people, and different groups are responsible for different micro-services.

The development environment is divided into local development environment, test environment and generation environment:

*   \*\* Local development environment: \*\* Own computer environment

*   \*\* Test environment: \*\* A set of environments built in the intranet that everyone can access and use.

*   \*\* Creation environment: \*\* Environment for final user use


6.2, team division of labor
---------------------------

At present, Shenling Logistics Project has 19 micro-services, 1 gateway, 1 parent project and 2 public dependent projects, which are jointly maintained and developed by the above 5 teams.

