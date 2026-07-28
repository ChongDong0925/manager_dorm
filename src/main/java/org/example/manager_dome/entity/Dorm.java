package org.example.manager_dome.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "dorm")
@Data
public class Dorm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dorm_number", unique = true, nullable = false)
    private String dormNumber; // 宿舍号

    @Column(name = "building", nullable = false)
    private String building; // 楼栋

    @Column(name = "floor")
    private Integer floor; // 楼层

    @Column(name = "room_type")
    private String roomType; // 房间类型

    @Column(name = "capacity")
    private Integer capacity; // 容纳人数

    @Column(name = "status")
    private String status; // 状态：可用/维修中/禁用

    @Column(name = "description")
    private String description; // 描述

    @Column(name = "create_time")
    private String createTime;

    @Column(name = "update_time")
    private String updateTime;
}