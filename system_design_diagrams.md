# 系统设计图表

## 1. 系统功能模块图

```mermaid
graph TD
    subgraph 可视化宿舍维护系统
        subgraph 核心功能模块
            A[宿舍维护管理模块] --> A1[任务录入]
            A --> A2[任务分配]
            A --> A3[任务状态跟踪]
            A --> A4[历史记录管理]
            
            B[排班管理模块] --> B1[人员排班]
            B --> B2[班次管理]
            B --> B3[排班查询]
            
            C[考勤管理模块] --> C1[打卡记录]
            C --> C2[考勤统计]
            C --> C3[考勤查询]
            
            D[可视化展示模块] --> D1[任务统计图表]
            D --> D2[出勤趋势图表]
            D --> D3[监控视频展示]
        end
        
        subgraph 基础功能
            E[用户认证模块] --> E1[登录]
            E --> E2[注册]
            E --> E3[权限管理]
            
            F[宿舍信息管理] --> F1[宿舍信息录入]
            F --> F2[宿舍信息编辑]
            F --> F3[宿舍信息查询]
            
            G[人员管理模块] --> G1[人员信息录入]
            G --> G2[人员信息编辑]
            G --> G3[人员信息查询]
        end
    end
    
    核心功能模块 --> 基础功能
```

## 2. 系统E-R图

```mermaid
graph TD
    subgraph 实体
        User[用户实体] --> |管理| Dorm[宿舍实体]
        User --> |管理| MaintainTask[维护任务实体]
        User --> |管理| Schedule[排班实体]
        User --> |管理| Attendance[考勤实体]
        
        Dorm --> |关联| MaintainTask
        MaintainStaff[维护人员实体] --> |执行| MaintainTask
        MaintainStaff --> |拥有| Schedule
        MaintainStaff --> |产生| Attendance
    end
    
    subgraph 关系
        User ||--o{ Dorm : 管理
        User ||--o{ MaintainTask : 管理
        User ||--o{ Schedule : 管理
        User ||--o{ Attendance : 管理
        Dorm ||--o{ MaintainTask : 关联
        MaintainStaff ||--o{ MaintainTask : 执行
        MaintainStaff ||--o{ Schedule : 拥有
        MaintainStaff ||--o{ Attendance : 产生
    end
    
    subgraph 属性
        User["User\n- id: Long\n- username: String\n- password: String\n- name: String\n- phone: String\n- role: String\n- status: Integer"]
        Dorm["Dorm\n- id: Long\n- dormNumber: String\n- building: String\n- floor: Integer\n- roomType: String\n- capacity: Integer\n- status: String\n- description: String"]
        MaintainStaff["MaintainStaff\n- id: Long\n- staffId: String\n- name: String\n- phone: String\n- department: String\n- team: String\n- position: String\n- status: String"]
        MaintainTask["MaintainTask\n- id: Long\n- taskId: String\n- taskType: String\n- dormId: Long\n- dormNumber: String\n- building: String\n- description: String\n- assignStaffId: Long\n- assignStaffName: String\n- status: String\n- priority: String"]
        Schedule["Schedule\n- id: Long\n- scheduleDate: String\n- staffId: Long\n- staffName: String\n- shift: String\n- startTime: String\n- endTime: String\n- position: String\n- status: String"]
        Attendance["Attendance\n- id: Long\n- staffId: Long\n- staffName: String\n- attendanceDate: String\n- checkInTime: String\n- checkOutTime: String\n- status: String"]
    end
```

## 3. 系统架构图

```mermaid
graph TD
    subgraph 前端展示层
        Browser[用户浏览器] --> HTML[HTML页面]
        HTML --> CSS[CSS样式]
        HTML --> JS[JavaScript脚本]
        JS --> ECharts[ECharts图表]
        JS --> Video[视频监控]
    end
    
    subgraph 业务逻辑层
        Controller[控制器层] --> Service[服务层]
        Service --> Repository[数据访问层]
        Controller --> Security[安全认证]
    end
    
    subgraph 数据存储层
        Database[MySQL数据库]
        FileSystem[文件系统]
    end
    
    Browser --> |HTTP请求| Controller
    Controller --> |返回数据| Browser
    Service --> |CRUD操作| Repository
    Repository --> |存储数据| Database
    FileSystem --> |存储视频| Video
```