package org.example.manager_dome.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "attendance")
@Data
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "attendance_date", nullable = false)
    private String attendanceDate; // 考勤日期

    @Column(name = "staff_id", nullable = false)
    private Long staffId; // 人员ID

    @Column(name = "staff_name")
    private String staffName; // 人员姓名

    @Column(name = "check_in_time")
    private String checkInTime; // 上班打卡时间

    @Column(name = "check_out_time")
    private String checkOutTime; // 下班打卡时间

    @Column(name = "status", nullable = false)
    private String status; // 出勤状态：正常/迟到/早退/缺勤/请假

    @Column(name = "remark")
    private String remark; // 备注

    @Column(name = "create_time")
    private String createTime;

    @Column(name = "update_time")
    private String updateTime;
}