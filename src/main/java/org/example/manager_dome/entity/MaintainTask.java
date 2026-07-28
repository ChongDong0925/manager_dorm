package org.example.manager_dome.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "maintain_task")
@Data
public class MaintainTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "task_id", unique = true, nullable = false)
    private String taskId; // 任务编号

    @Column(name = "task_type", nullable = false)
    private String taskType; // 任务类型：维修/养护/清扫

    @Column(name = "dorm_id")
    private Long dormId; // 关联宿舍ID

    @Column(name = "dorm_number")
    private String dormNumber; // 宿舍号

    @Column(name = "building")
    private String building; // 楼栋

    @Column(name = "description", nullable = false)
    private String description; // 任务描述

    @Column(name = "assign_staff_id")
    private Long assignStaffId; // 分配人员ID

    @Column(name = "assign_staff_name")
    private String assignStaffName; // 分配人员姓名

    @Column(name = "status", nullable = false)
    private String status; // 状态：待处理/处理中/已完成/已取消

    @Column(name = "priority")
    private String priority; // 优先级：高/中/低

    @Column(name = "create_time", nullable = false)
    private String createTime; // 创建时间

    @Column(name = "start_time")
    private String startTime; // 开始时间

    @Column(name = "complete_time")
    private String completeTime; // 完成时间

    @Column(name = "handler")
    private String handler; // 处理人

    @Column(name = "remark")
    private String remark; // 备注
}