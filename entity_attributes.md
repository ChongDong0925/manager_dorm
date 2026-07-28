# 系统实体属性列表

## 1. 宿舍实体 (Dorm)

| 属性名 | 数据类型 | 描述 | 约束 |
|-------|---------|------|------|
| id | Long | 宿舍ID | 主键，自增 |
| dormNumber | String | 宿舍号 | 唯一，非空 |
| building | String | 楼栋 | 非空 |
| floor | Integer | 楼层 | - |
| roomType | String | 房间类型 | - |
| capacity | Integer | 容纳人数 | - |
| status | String | 状态：可用/维修中/禁用 | - |
| description | String | 描述 | - |
| createTime | String | 创建时间 | - |
| updateTime | String | 更新时间 | - |

## 2. 维护任务实体 (MaintainTask)

| 属性名 | 数据类型 | 描述 | 约束 |
|-------|---------|------|------|
| id | Long | 任务ID | 主键，自增 |
| taskId | String | 任务编号 | 唯一，非空 |
| taskType | String | 任务类型：维修/养护/清扫 | 非空 |
| dormId | Long | 关联宿舍ID | - |
| dormNumber | String | 宿舍号 | - |
| building | String | 楼栋 | - |
| description | String | 任务描述 | 非空 |
| assignStaffId | Long | 分配人员ID | - |
| assignStaffName | String | 分配人员姓名 | - |
| status | String | 状态：待处理/处理中/已完成/已取消 | 非空 |
| priority | String | 优先级：高/中/低 | - |
| createTime | String | 创建时间 | 非空 |
| startTime | String | 开始时间 | - |
| completeTime | String | 完成时间 | - |
| handler | String | 处理人 | - |
| remark | String | 备注 | - |

## 3. 维护人员实体 (MaintainStaff)

| 属性名 | 数据类型 | 描述 | 约束 |
|-------|---------|------|------|
| id | Long | 人员ID | 主键，自增 |
| staffId | String | 工号 | 唯一，非空 |
| name | String | 姓名 | 非空 |
| phone | String | 电话 | - |
| department | String | 所属部门 | - |
| team | String | 所属班组 | - |
| position | String | 职位 | - |
| status | String | 状态：在职/离职 | - |
| createTime | String | 创建时间 | - |
| updateTime | String | 更新时间 | - |

## 4. 排班实体 (Schedule)

| 属性名 | 数据类型 | 描述 | 约束 |
|-------|---------|------|------|
| id | Long | 排班ID | 主键，自增 |
| scheduleDate | String | 排班日期 | 非空 |
| staffId | Long | 人员ID | 非空 |
| staffName | String | 人员姓名 | - |
| shift | String | 班次：早班/中班/晚班 | 非空 |
| startTime | String | 开始时间 | - |
| endTime | String | 结束时间 | - |
| position | String | 值班岗位 | - |
| status | String | 状态：正常/调班/请假 | - |
| remark | String | 备注 | - |
| createTime | String | 创建时间 | - |
| updateTime | String | 更新时间 | - |

## 5. 考勤实体 (Attendance)

| 属性名 | 数据类型 | 描述 | 约束 |
|-------|---------|------|------|
| id | Long | 考勤ID | 主键，自增 |
| attendanceDate | String | 考勤日期 | 非空 |
| staffId | Long | 人员ID | 非空 |
| staffName | String | 人员姓名 | - |
| checkInTime | String | 上班打卡时间 | - |
| checkOutTime | String | 下班打卡时间 | - |
| status | String | 出勤状态：正常/迟到/早退/缺勤/请假 | 非空 |
| remark | String | 备注 | - |
| createTime | String | 创建时间 | - |
| updateTime | String | 更新时间 | - |