# 🏠 manager_dorm 可视化高校宿舍后勤管理系统
[![MIT License](https://img.shields.io/badge/license-MIT-green.svg)](LICENSE)
[![Java 17](https://img.shields.io/badge/JDK-17-blue.svg)]
[![SpringBoot 3.2](https://img.shields.io/badge/SpringBoot-3.2-orange.svg)]
[![MySQL8](https://img.shields.io/badge/MySQL-8.0-lightblue.svg)]

## 📋 目录导航
- [项目简介](#📖-项目简介)
- [核心功能](#✨-核心功能)
- [技术栈](#🛠-技术栈)
- [系统截图](#🖼-系统功能截图)
- [完整项目目录](#📁-完整项目目录)
- [本地部署教程](#🚀-本地部署教程)
- [配套文档](#📎-配套文档)
- [开源协议](#📄-开源协议)

## 📖 项目简介
本系统基于 SpringBoot3+Thymeleaf 开发，面向高校宿管、后勤维修班组打造一体化管理平台。
一站式解决宿舍信息、维修人员、维修工单、排班考勤管理，内置 ECharts 数据可视化大屏+模拟监控播放模块，课程设计/毕设可直接使用。

## ✨ 核心功能
- 🔐 用户权限：账号注册登录，SpringSecurity 身份校验
- 🛏 宿舍管理：楼栋、房间增删改查，房间状态管控
- 👷 维修人员：班组、人员信息维护管理
- 🛠 维修任务：工单创建、分配、状态流转、优先级标记
- 📅 排班管理：早/中/晚班次安排，人员调度
- ⏰ 考勤模块：上下班打卡、出勤记录、考勤图表统计
- 📊 可视化大屏：任务统计、出勤趋势、完成率ECharts图表
- 🎥 模拟监控：本地视频播放，模拟宿舍楼实时监控画面

## 🛠 技术栈
### 后端
- Java 17 | Spring Boot 3.2.0
- Spring Security 权限框架
- Spring Data JPA 持久层
- Lombok 简化实体代码
- Maven 项目构建

### 前端
- Thymeleaf 服务端模板
- Bootstrap5 + FontAwesome 图标
- ECharts 数据可视化图表
- 原生JS/CSS

### 数据库
MySQL 8.0+

## 🖼 系统功能截图
### 1. 用户登录 & 注册页面
<p align="center">
<img width="400" src="https://github.com/user-attachments/assets/72e1ba55-597e-435a-bef9-ebd4a6a41635" alt="登录页面">
<img width="400" src="https://github.com/user-attachments/assets/75be6dda-2274-4404-b513-22436c2a95c1" alt="注册页面">
</p>

### 2. 可视化监控大屏（首页核心页面）
<p align="center">
<img width="480" src="https://github.com/user-attachments/assets/d1dd61b3-dd62-4597-8dbd-f064c766179f" alt="监控大屏1">
<img width="480" src="https://github.com/user-attachments/assets/703e0713-0124-4686-9fa6-d94e3006b1d6" alt="监控大屏2">
</p>

### 3. 宿舍信息管理模块
<p align="center">
<img width="420" src="https://github.com/user-attachments/assets/a81f7b21-3fb7-46af-8b3e-1b2382e403dc" alt="宿舍列表总览">
<img width="420" src="https://github.com/user-attachments/assets/7f6a7eb5-45e4-4392-857c-08e25729eedc" alt="新增/编辑宿舍弹窗">
</p>
<p align="center">
<img width="420" src="https://github.com/user-attachments/assets/c125ab3a-81a2-491c-91f6-a07895671338" alt="宿舍状态查看">
<img width="420" src="https://github.com/user-attachments/assets/7904290b-eaf4-45da-a3c6-e8832e2a7526" alt="宿舍信息检索筛选">
</p>

### 4. 其余业务模块
维修任务、排班、考勤、维护人员管理页面截图**后续分批补充上传**；
如需完整预览，本地拉取项目运行 `http://localhost:8083` 即可查看全部界面。

## 📁 完整项目目录（点击展开查看）
<details>
<summary>👉 点击展开：完整项目树形目录</summary>

```text
dorm_maintain_system/  // 项目根目录
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── org/
│   │   │       └── example/
│   │   │           └── manager_dorm/  // 项目主包（所有Java代码入口）
│   │   │               ├── ManagerDormApplication.java  // 项目启动类（核心）
│   │   │               ├── config/  // 全局配置类（无需频繁修改）
│   │   │               │   ├── SecurityConfig.java  // 权限配置（管理员/维护人员权限控制）
│   │   │               │   ├── WebConfig.java      // Web配置（静态资源/跨域/视图解析）
│   │   │               │   ├── JpaConfig.java       // JPA配置（数据库映射/分页）
│   │   │               │   └── FileConfig.java      // 文件配置（本地视频/图片上传/访问）
│   │   │               ├── controller/  // 控制器层（按业务模块划分，对接前端请求）
│   │   │               │   ├── CommonController.java    // 通用控制器（登录/注册/退出）
│   │   │               │   ├── DormController.java      // 宿舍信息管理控制器（增删改查）
│   │   │               │   ├── TaskController.java      // 维护任务管理控制器（创建/分配/状态更新）
│   │   │               │   ├── ScheduleController.java  // 排班管理控制器（班次新增/编辑/查询）
│   │   │               │   ├── AttendanceController.java// 考勤管理控制器（打卡/统计/编辑）
│   │   │               │   └── VisualController.java    // 可视化控制器（大屏数据接口/ECharts数据返回）
│   │   │               ├── entity/  // 实体类（和数据库表一一映射，JPA自动建表）
│   │   │               │   ├── User.java           // 用户表（管理员/维护人员，核心权限表）
│   │   │               │   ├── Dorm.java           // 宿舍信息表（宿舍号/楼栋/房间类型/状态等）
│   │   │               │   ├── MaintainStaff.java  // 维护人员信息表（姓名/工号/电话/所属班组等）
│   │   │               │   ├── MaintainTask.java   // 维护任务表（维修/养护/清扫，核心业务表）
│   │   │               │   ├── Schedule.java       // 排班信息表（人员/班次/日期/值班岗位）
│   │   │               │   └── Attendance.java     // 考勤信息表（人员/日期/打卡时间/出勤状态）
│   │   │               ├── repository/  // 数据访问层（JPA Repository，无需手写SQL）
│   │   │               │   ├── UserRepository.java
│   │   │               │   ├── DormRepository.java
│   │   │               │   ├── MaintainStaffRepository.java
│   │   │               │   ├── MaintainTaskRepository.java
│   │   │               │   ├── ScheduleRepository.java
│   │   │               │   └── AttendanceRepository.java
│   │   │               ├── service/  // 业务层（接口+实现类，核心业务逻辑写这里）
│   │   │               │   ├── // 业务接口（定义方法，解耦）
│   │   │               │   ├── UserService.java
│   │   │               │   ├── DormService.java
│   │   │               │   ├── MaintainStaffService.java
│   │   │               │   ├── MaintainTaskService.java
│   │   │               │   ├── ScheduleService.java
│   │   │               │   ├── AttendanceService.java
│   │   │               │   ├── VisualService.java
│   │   │               │   ├── // 业务实现类（实现接口，写具体逻辑）
│   │   │               │   ├── UserServiceImpl.java
│   │   │               │   ├── DormServiceImpl.java
│   │   │               │   ├── MaintainStaffServiceImpl.java
│   │   │               │   ├── MaintainTaskServiceImpl.java
│   │   │               │   ├── ScheduleServiceImpl.java
│   │   │               │   ├── AttendanceServiceImpl.java
│   │   │               │   └── VisualServiceImpl.java
│   │   │               ├── common/  // 通用工具类（全项目复用，无需修改）
│   │   │               │   ├── Result.java          // 统一返回结果封装（前后端交互规范）
│   │   │               │   ├── ResultCode.java      // 返回码枚举（成功/失败/参数错误等）
│   │   │               │   ├── GlobalExceptionHandler.java // 全局异常处理器（统一捕获报错）
│   │   │               │   ├── Constant.java        // 常量类（固定值，比如任务状态/考勤状态）
│   │   │               │   └── DateUtil.java        // 日期工具类（排班/考勤日期处理）
│   │   │               └── vo/  // 视图对象（前端传参/后端返参封装，避免直接传实体）
│   │   │                   ├── LoginVo.java         // 登录参数封装
│   │   │                   ├── RegisterVo.java      // 注册参数封装
│   │   │                   ├── TaskQueryVo.java     // 维护任务查询参数（多条件筛选）
│   │   │                   ├── TaskAddVo.java       // 维护任务新增参数
│   │   │                   ├── ScheduleAddVo.java   // 排班新增参数
│   │   │                   ├── AttendanceAddVo.java // 考勤打卡参数
│   │   │                   └── VisualDataVo.java    // 可视化大屏数据封装（ECharts专用）
│   │   └── resources/  // 资源目录（前端页面/静态资源/配置文件，核心可视化+视频在这里）
│   │       ├── application.properties  // 全局配置文件（数据库/服务器/静态资源/视频访问）
│   │       ├── static/  // 静态资源（CSS/JS/图片/本地监控视频/前端插件，直接访问）
│   │       │   ├── css/  // 自定义样式（大屏/业务页面样式修改）
│   │       │   │   ├── dashboard.css  // 可视化大屏专属样式（适配大屏布局/视频播放）
│   │       │   │   └── custom.css     // 通用业务页面样式
│   │       │   ├── js/   // 自定义JS（图表渲染/视频播放/表单验证）
│   │       │   │   ├── dashboard.js   // 大屏核心JS（ECharts渲染/本地视频播放控制）
│   │       │   │   ├── echarts-config.js // ECharts配置（图表样式/数据映射）
│   │       │   │   └── common.js      // 通用JS（表单提交/弹窗/日期选择）
│   │       │   ├── img/  // 图片资源（系统logo/楼栋图片/状态图标/大屏背景）
│   │       │   │   ├── logo.png       // 系统logo
│   │       │   │   ├── dorm_build.png // 宿舍楼栋示意图
│   │       │   │   ├── status/        // 状态图标（任务待处理/已完成/考勤正常/迟到等）
│   │       │   │   └── dashboard/     // 大屏背景图/装饰图
│   │       │   ├── video/  // 本地监控视频存放目录（核心！模拟宿舍/公共区域监控）
│   │       │   │   ├── dorm_1.mp4     // 1号宿舍楼监控模拟视频
│   │       │   │   ├── dorm_2.mp4     // 2号宿舍楼监控模拟视频
│   │       │   │   ├── public_area.mp4// 公共区域（楼道/水房）监控模拟视频
│   │       │   │   └── playground.mp4// 操场/公共区域监控模拟视频
│   │       │   └── plugins/  // 前端第三方插件（直接引入，无需修改）
│   │       │       ├── bootstrap-5.3.0/  // 页面布局框架（和之前项目一致）
│   │       │       ├── jquery-3.7.0/      // 前端工具库（表单/事件处理）
│   │       │       ├── font-awesome-6.4.0/ // 图标库（按钮/状态图标）
│   │       │       └── echarts-5.4.3/     // 可视化图表核心插件（大屏折线/柱状/饼图）
│   │       └── templates/  // Thymeleaf页面模板（按业务模块划分，复用通用布局）
│   │           ├── common/  // 通用页面（全项目复用，登录/注册/布局/错误页）
│   │           │   ├── layout.html   // 通用布局模板（头部/导航/底部，子页面继承）
│   │           │   ├── login.html    // 系统登录页（管理员/维护人员通用）
│   │           │   ├── register.html // 维护人员注册页（管理员可创建）
│   │           │   └── error.html    // 全局错误页（404/500）
│   │           ├── dashboard/  // 可视化大屏首页（核心！放监控视频+ECharts统计图表）
│   │           │   └── index.html    // 大屏主页面（唯一，聚合所有可视化数据+监控）
│   │           ├── dorm/  // 宿舍信息管理页面（增删改查/宿舍状态管理）
│   │           │   ├── dorm_list.html // 宿舍信息列表页（查询/编辑/删除）
│   │           │   └── dorm_add.html // 宿舍信息新增/编辑页
│   │           ├── task/  // 维护任务管理页面（维修/养护/清扫任务全流程）
│   │           │   ├── task_list.html  // 任务列表页（多条件筛选/状态更新/分配）
│   │           │   ├── task_add.html  // 任务新增/编辑页（维修/养护/清扫类型）
│   │           │   └── task_detail.html// 任务详情页（查看执行记录/完成情况）
│   │           ├── schedule/  // 排班管理页面（维护人员班次安排）
│   │           │   ├── schedule_list.html // 排班列表页（按人员/日期查询）
│   │           │   └── schedule_add.html // 排班新增/编辑页
│   │           └── attendance/  // 考勤管理页面（打卡/统计/出勤情况）
│   │               ├── attendance_list.html // 考勤列表页（按人员/日期统计）
│   │               ├── attendance_check.html// 考勤打卡页（维护人员自打卡）
│   │               └── attendance_stat.html // 考勤统计页（管理员查看，ECharts展示）
│   └── test/  // 测试目录（IDEA自动生成，开发完成后写单元测试）
│       └── java/
│           └── org/
│               └── example/
│                   └── dorm_maintain/
│                       └── DormMaintainApplicationTests.java // 项目测试启动类
└── pom.xml  // Maven依赖配置文件（SpringBoot核心/数据库/前端/文件处理等依赖）

```
</details>

## 🚀 本地部署教程
### 1. 环境准备
- JDK 17 及以上
- MySQL 8.0
- Maven 3.6+

### 2. 数据库配置
1. 新建数据库 `manager_dorm`
2. 修改 `src/main/resources/application.properties`
```properties
# 替换为你本地MySQL账号密码
spring.datasource.username=你的账号
spring.datasource.password=你的密码
3. 启动项目
Maven 加载全部依赖
运行启动类 ManagerDomeApplication
访问地址：http://localhost:8083
📎 配套文档
项目配套完整设计文档、功能说明书，包含系统架构、数据库设计、功能详解，可查看仓库内 system_design_diagrams.md 文件。
📄 开源协议
本项目基于 MIT License 开源，可免费学习、商用、二次修改，保留原版权声明即可。
Copyright © 2026 ChongDong0925
plaintext
```
