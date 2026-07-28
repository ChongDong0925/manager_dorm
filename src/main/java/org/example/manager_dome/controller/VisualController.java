package org.example.manager_dome.controller;

import org.example.manager_dome.service.VisualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@RequestMapping("/api/visual")
public class VisualController {

    @Autowired
    private VisualService visualService;

    // 获取任务统计数据
    @GetMapping("/taskStatistics")
    public Map<String, Object> getTaskStatistics() {
        return visualService.getTaskStatistics();
    }

    // 获取出勤趋势数据
    @GetMapping("/attendanceTrend")
    public Map<String, Object> getAttendanceTrend() {
        return visualService.getAttendanceTrend();
    }

    // 获取任务完成率数据
    @GetMapping("/taskCompletionRate")
    public Map<String, Object> getTaskCompletionRate() {
        return visualService.getTaskCompletionRate();
    }

    // 获取考勤状态数据
    @GetMapping("/attendanceStatus")
    public Map<String, Object> getAttendanceStatus() {
        return visualService.getAttendanceStatus();
    }
}