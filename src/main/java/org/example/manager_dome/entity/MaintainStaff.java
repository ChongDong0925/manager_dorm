package org.example.manager_dome.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "maintain_staff")
@Data
public class MaintainStaff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "staff_id", unique = true, nullable = false)
    private String staffId; // 工号

    @Column(name = "name", nullable = false)
    private String name; // 姓名

    @Column(name = "phone")
    private String phone; // 电话

    @Column(name = "department")
    private String department; // 所属部门

    @Column(name = "team")
    private String team; // 所属班组

    @Column(name = "position")
    private String position; // 职位

    @Column(name = "status")
    private String status; // 状态：在职/离职

    @Column(name = "create_time")
    private String createTime;

    @Column(name = "update_time")
    private String updateTime;
}