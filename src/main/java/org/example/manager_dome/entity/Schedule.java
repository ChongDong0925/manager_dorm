package org.example.manager_dome.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "schedule")
@Data
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "schedule_date", nullable = false)
    private String scheduleDate; // 排班日期

    @Column(name = "staff_id", nullable = false)
    private Long staffId; // 人员ID

    @Column(name = "staff_name")
    private String staffName; // 人员姓名

    @Column(name = "shift", nullable = false)
    private String shift; // 班次：早班/中班/晚班

    @Column(name = "start_time")
    private String startTime; // 开始时间

    @Column(name = "end_time")
    private String endTime; // 结束时间

    @Column(name = "position")
    private String position; // 值班岗位

    @Column(name = "status")
    private String status; // 状态：正常/调班/请假

    @Column(name = "remark")
    private String remark; // 备注

    @Column(name = "create_time")
    private String createTime;

    @Column(name = "update_time")
    private String updateTime;
}