package org.example.manager_dome.service;

import java.util.Map;

public interface VisualService {
    // 获取任务统计数据
    Map<String, Object> getTaskStatistics();
    
    // 获取出勤趋势数据
    Map<String, Object> getAttendanceTrend();
    
    // 获取任务完成率数据
    Map<String, Object> getTaskCompletionRate();
    
    // 获取考勤状态数据
    Map<String, Object> getAttendanceStatus();
}