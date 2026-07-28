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