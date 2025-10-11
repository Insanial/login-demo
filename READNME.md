# 五维数据笔试题
## 题目描述
后端：
```
Implement a project using SpringBoot 3.2.0 . With a GET method HelloWorld API that requires SpringSecurity authentication, which returns a string saying "Hello World". And a username-password login API (could use username test and password 123456). Submit a GitHub link.
```
## 要求实现功能
1. 向外暴露/api/hello接口，
2. 访问该接口会跳转至验证界面（/login），使用名称和密码验证，
3. 验证成功返回界面，显示Hello World"。<br>
测试账号:test，123456

## 技术栈

*   **核心框架:** Spring Boot 3.2.0
*   **安全框架:** Spring Security 6
*   **Web 框架:** Spring Web (内置 Tomcat)
*   **ORM 框架:** MyBatis 3.0.3
*   **数据库:** MySQL 8
*   **构建工具:** Maven
*   **开发语言:** Java 17

## 1.如何在本地运行
### 运行步骤

1.  **克隆或下载项目:**
    *   使用 Git 克隆项目到本地：
      ```bash
      git clone https://github.com/你的用户名/security-demo.git
      ```
    *   或者直接下载项目的 ZIP 压缩包并解压。

2. **初始化mysql数据库**
修改application.yml中datasource配置，与本地数据库对应，密码默认root,root,可自行更改配置
```bash
-- 创建数据库
CREATE DATABASE login_demo;
USE login_demo;

-- 创建用户表
CREATE TABLE user (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

-- 添加测试账号
INSERT INTO user (name, password) VALUES ('test', '123456');
```

1.  **安装依赖**
      ```bash
      mvn clean package
      ```
2.  **运行应用程序:**
    *   在项目文件树中，执行主启动类 `src\main\java\com\demo\login_demo\LoginDemoApplication.java`。

3.  观察控制台输出，当看到类似 `Tomcat started on port(s): 8080 (http)` 的日志时，表示服务已成功启动。

## 2.如何在本地运行

### 2.1. 访问浏览器测试 API
1.  访问http://localhost:8080/api/hello
*   **预期结果:** 你会跳转到一个登录页面。
2.  输入测试账号：test，123456
*   **预期结果:** 认证成功，重定向，页面显示`Hello World`。
3.  再次访问：http://localhost:8080/api/hello
*   **预期结果:** 页面显示`Hello World`。
*   
### 2.2. 使用 Postman 测试 API

#### 1. 访问受保护接口 (未登录)

这一步验证接口确实被保护了。

1.  打开 Postman，新建一个 `GET` 请求。
2.  在地址栏输入：`http://localhost:8080/api/hello`
3.  点击 **Send**。

*   **预期结果:** 你会收到一个 **`200 OK`** 状态码，Body 中可能会显示一个 HTML 登录页面。
#### 2. 登录并获取会话 Cookie

这一步模拟用户提交表单登录。

1.  新建一个 `POST` 请求。
2.  在地址栏输入：`http://localhost:8080/login`
3.  切换到 **Body** 标签页，选择 **`x-www-form-urlencoded`**。
4.  在下方的表格中，添加两条数据：
    *   **KEY:** `username`, **VALUE:** `test`
    *   **KEY:** `password`, **VALUE:** `123456`
5.  点击 **Send**。

*   **预期结果:** Postman 会自动处理重定向，最终你会收到一个 `200 OK` 的响应。最重要的是，检查响应界面的 **Cookies** 标签页，你应该会看到一个由服务器设置的 `JSESSIONID`。Postman 会自动保存这个 Cookie 用于后续请求。
#### 3. 访问受保护接口 (已登录)

现在，带着登录成功的“身份”，再次访问受保护的接口。

1.  切换回**第一个**测试 `/api/hello` 的请求标签页。
2.  **不需要做任何修改**，直接再次点击 **Send**。

*   **预期结果:**
    *   状态码会变为 **`200 OK`**。
    *   响应的 **Body** 部分会显示字符串：`Hello World`。