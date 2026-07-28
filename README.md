# 🏠manager_dorm可视化高校宿舍后勤管理系统
[![MIT License](https://img.shields.io/badge/license-MIT-green.svg)](LICENSE)
[![Java 17](https://img.shields.io/badge/JDK-17-blue.svg)]
[![SpringBoot 3.2](https://img.shields.io/badge/SpringBoot-3.2-orange.svg)]
[![MySQL8](https://img.shields.io/badge/MySQL-8.0-lightblue.svg)]

## 📋目录导航
- [项目简介](#📖-项目简介)
- [核心功能](#✨-核心功能)
- [技术栈](#🛠-技术栈)
- [系统截图](#🖼-系统功能截图)
- [完整项目目录（点击展开查看）](#📁-完整项目目录点击展开查看)
- [本地部署教程](#🚀-本地部署教程)
- [配套文档](#📎-配套文档)
- [开源协议](#📄-开源协议)

## 📖项目简介
本系统基于 SpringBoot3+Thymeleaf 开发，面向高校宿管、后勤维修班组打造一体化管理平台。
一站式解决宿舍信息、维修人员、维修工单、排班考勤管理，内置 ECharts 数据可视化大屏+模拟监控播放模块，课程设计/毕设可直接使用。

## ✨核心功能
- 🔐 用户权限：账号注册登录，SpringSecurity 身份校验
- 🛏 宿舍管理：楼栋、房间增删改查，房间状态管控
- 👷 维修人员：班组、人员信息维护管理
- 🛠 维修任务：工单创建、分配、状态流转、优先级标记
- 📅 排班管理：早/中/晚班次安排，人员调度
- ⏰ 考勤模块：上下班打卡、出勤记录、考勤图表统计
- 📊 可视化大屏：任务统计、出勤趋势、完成率ECharts图表
- 🎥 模拟监控：本地视频播放，模拟宿舍楼实时监控画面

## 🛠技术栈
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

## 🖼系统功能截图
1 用户功能模块与系统首页实现

<img width="415" height="229" alt="image" src="https://github.com/user-attachments/assets/75be6dda-2274-4404-b513-22436c2a95c1" />

<img width="415" height="229" alt="image" src="https://github.com/user-attachments/assets/72e1ba55-597e-435a-bef9-ebd4a6a41635" />

<img width="415" height="229" alt="image" src="https://github.com/user-attachments/assets/d1dd61b3-dd62-4597-8dbd-f064c766179f" />

<img width="415" height="229" alt="image" src="https://github.com/user-attachments/assets/703e0713-0124-4686-9fa6-d94e3006b1d6" />

<img width="415" height="229" alt="image" src="https://github.com/user-attachments/assets/de9543c2-e80a-4707-9319-c2d6ddc5079b" />

4.2 宿舍管理与任务管理模块实现
宿舍管理模块主要用于对宿舍基本信息进行管理，是系统数据管理的重要组成部分。在宿舍管理列表页面，如图6所示中，系统以表格形式展示所有宿舍信息，包括宿舍编号、楼栋信息以及相关状态等。用户可以通过页面中的操作按钮对宿舍信息进行新增、修改和删除操作。在新增宿舍页面，如图7所示中，用户填写宿舍相关信息后提交，系统通过后台接口接收数据，并将其存储到数据库中。

图6 宿舍管理列表页

图7 新增宿舍页
任务管理模块是系统的核心功能模块之一，主要用于管理宿舍维护任务。在任务管理列表页面，如图8所示中，系统展示所有维护任务的基本信息，包括任务内容、任务状态以及处理情况等。用户可以通过新增任务页面录入新的维护任务信息，如图9所示，系统在接收到任务数据后，通过业务逻辑层对数据进行处理，并存储至数据库中的任务表中。

图8 任务管理列表页

图9 新增任务页
在任务执行过程中，系统支持对任务状态进行动态更新，例如将任务状态由“未完成”更新为“已完成”。系统通过对任务状态的实时更新，实现对任务处理过程的有效跟踪。此外，系统还支持任务信息的查询功能，用户可以根据不同条件筛选任务，从而提高信息检索效率。
4.3 排班管理与考勤管理模块实现
排班管理模块主要用于对维护人员的工作时间进行安排，其功能页面如图10所示。系统通过列表形式展示排班信息，包括人员姓名、工作时间以及具体安排等内容。用户可以通过新增排班页面，录入排班信息，系统在接收到数据后，通过后台程序进行处理，并将排班信息存储到数据库中，如图11所示。

图10 排班管理列表页

图11 新增排班页
在排班管理过程中，系统支持对已有排班信息进行修改，从而提高人员调度的灵活性。通过该模块，可以实现对维护人员工作安排的规范化管理，提高整体工作效率。
考勤管理模块用于记录维护人员的出勤情况，其列表页面如图12所示。系统以表格形式展示所有考勤记录，包括人员姓名、打卡时间等信息。在考勤打卡页面，如图13所示中，用户可以进行签到操作，系统自动记录当前时间，并将数据存储至数据库中。

图12 考勤管理列表页

图13 考勤打卡页
此外，系统还提供考勤统计功能，如图14所示，通过图表形式对考勤数据进行分析与展示。系统通过对考勤数据进行统计处理，并以可视化方式呈现，从而使管理人员能够直观了解人员出勤情况，提高管理决策的科学性。

图14 考勤统计页
4.4 维护人员管理与监控展示模块实现
维护人员管理模块主要用于对系统中的维修人员信息进行统一管理，其界面如图15所示。系统通过列表形式展示所有维护人员的基本信息，包括姓名、联系方式以及岗位信息等。用户可以通过新增维护人员页面，如图5-16所示，录入新的人员信息，系统在接收到数据后，通过后台接口将其存储至数据库中。

图15 维护人员管理页

图16 新增维护人员页
通过维护人员管理模块，可以实现对维修人员信息的集中管理，同时为任务分配和排班管理提供数据支持。
为了增强系统的可视化效果，本系统还设计了监控展示模块，其界面如图五所示。该模块通过视频播放器加载本地视频资源，用于模拟宿舍公共区域的监控画面。在实现过程中，前端页面通过调用视频组件实现视频播放功能，从而在系统界面中展示监控内容。
监控展示模块的实现，使系统不仅具备数据管理功能，还能够通过视频形式展示宿舍环境情况，从而增强系统的直观性和实用性。

## 📁 完整项目目录（点击展开查看）
<details>
<summary>dorm_maintain_system/  // 项目根目录
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
└── pom.xml  // Maven依赖配置文件（SpringBoot核心/数据库/前端/文件处理等依赖）</summary>
