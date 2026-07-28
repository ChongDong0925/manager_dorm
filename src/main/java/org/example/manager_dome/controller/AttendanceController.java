package org.example.manager_dome.controller;

import org.example.manager_dome.entity.Attendance;
import org.example.manager_dome.service.AttendanceService;
import org.example.manager_dome.service.MaintainStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    private MaintainStaffService maintainStaffService;

    // 考勤列表页面
    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("attendances", attendanceService.findAll());
        return "attendance/attendance_list";
    }

    // 考勤打卡页面
    @GetMapping("/check")
    public String check(Model model) {
        // 获取所有员工列表
        model.addAttribute("staffs", maintainStaffService.findAll());
        return "attendance/attendance_check";
    }

    // 考勤统计页面
    @GetMapping("/stat")
    public String stat() {
        return "attendance/attendance_stat";
    }

    // 上班打卡
    @PostMapping("/checkIn")
    public String checkIn(@RequestParam("staffId") Long staffId,
                         @RequestParam("attendanceDate") String attendanceDate,
                         Model model) {
        String checkInTime = java.time.LocalDateTime.now().toString();
        Attendance attendance = attendanceService.checkIn(staffId, maintainStaffService.findById(staffId).getName(), attendanceDate, checkInTime);
        if (attendance != null) {
            model.addAttribute("message", "打卡成功");
        } else {
            model.addAttribute("message", "打卡失败");
        }
        // 获取所有员工列表
        model.addAttribute("staffs", maintainStaffService.findAll());
        return "attendance/attendance_check";
    }

    // 下班打卡
    @PostMapping("/checkOut")
    public String checkOut(@RequestParam("staffId") Long staffId,
                          @RequestParam("attendanceDate") String attendanceDate,
                          Model model) {
        String checkOutTime = java.time.LocalDateTime.now().toString();
        Attendance attendance = attendanceService.checkOut(staffId, attendanceDate, checkOutTime);
        if (attendance != null) {
            model.addAttribute("message", "打卡成功");
        } else {
            model.addAttribute("message", "打卡失败");
        }
        // 获取所有员工列表
        model.addAttribute("staffs", maintainStaffService.findAll());
        return "attendance/attendance_check";
    }
}