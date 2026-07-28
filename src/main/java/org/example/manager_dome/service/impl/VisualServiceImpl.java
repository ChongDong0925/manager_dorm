package org.example.manager_dome.service.impl;

import org.example.manager_dome.entity.Attendance;
import org.example.manager_dome.repository.MaintainTaskRepository;
import org.example.manager_dome.repository.AttendanceRepository;
import org.example.manager_dome.service.VisualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

@Service
public class VisualServiceImpl implements VisualService {

    @Autowired
    private MaintainTaskRepository maintainTaskRepository;

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Override
    public Map<String, Object> getTaskStatistics() {
        Map<String, Object> result = new HashMap<>();
        
        // 获取任务类型统计
        long repairCount = maintainTaskRepository.findByTaskType("维修").size();
        long maintenanceCount = maintainTaskRepository.findByTaskType("养护").size();
        long cleaningCount = maintainTaskRepository.findByTaskType("清扫").size();
        
        // 获取任务状态统计
        long pendingCount = maintainTaskRepository.findByStatus("待处理").size();
        long processingCount = maintainTaskRepository.findByStatus("处理中").size();
        long completedCount = maintainTaskRepository.findByStatus("已完成").size();
        
        result.put("repairCount", repairCount);
        result.put("maintenanceCount", maintenanceCount);
        result.put("cleaningCount", cleaningCount);
        result.put("pendingCount", pendingCount);
        result.put("processingCount", processingCount);
        result.put("completedCount", completedCount);
        
        return result;
    }

    @Override
    public Map<String, Object> getAttendanceTrend() {
        Map<String, Object> result = new HashMap<>();
        
        // 获取最近7天的出勤数据
        String[] dates = new String[7];
        int[] normalCounts = new int[7];
        int[] lateCounts = new int[7];
        int[] absentCounts = new int[7];
        
        for (int i = 6; i >= 0; i--) {
            java.time.LocalDate date = java.time.LocalDate.now().minusDays(i);
            String dateStr = date.toString();
            dates[6 - i] = dateStr;
            
            // 从数据库获取当天的考勤数据
            List<Attendance> attendances = attendanceRepository.findByAttendanceDate(dateStr);
            int normal = 0, late = 0, absent = 0;
            
            for (Attendance attendance : attendances) {
                String status = attendance.getStatus();
                if ("正常".equals(status)) {
                    normal++;
                } else if ("迟到".equals(status)) {
                    late++;
                } else if ("缺勤".equals(status)) {
                    absent++;
                }
            }
            
            normalCounts[6 - i] = normal;
            lateCounts[6 - i] = late;
            absentCounts[6 - i] = absent;
        }
        
        result.put("dates", dates);
        result.put("normalCounts", normalCounts);
        result.put("lateCounts", lateCounts);
        result.put("absentCounts", absentCounts);
        
        return result;
    }

    @Override
    public Map<String, Object> getTaskCompletionRate() {
        Map<String, Object> result = new HashMap<>();
        
        // 获取任务总数
        long totalTasks = maintainTaskRepository.findAll().size();
        // 获取已完成任务数
        long completedTasks = maintainTaskRepository.findByStatus("已完成").size();
        // 计算完成率
        double completionRate = totalTasks > 0 ? (double) completedTasks / totalTasks * 100 : 0;
        
        result.put("totalTasks", totalTasks);
        result.put("completedTasks", completedTasks);
        result.put("completionRate", completionRate);
        
        return result;
    }

    @Override
    public Map<String, Object> getAttendanceStatus() {
        Map<String, Object> result = new HashMap<>();
        
        // 从数据库获取考勤状态数据
        List<Attendance> allAttendances = attendanceRepository.findAll();
        int normal = 0, late = 0, earlyLeave = 0, absent = 0, leave = 0;
        
        for (Attendance attendance : allAttendances) {
            String status = attendance.getStatus();
            if ("正常".equals(status)) {
                normal++;
            } else if ("迟到".equals(status)) {
                late++;
            } else if ("早退".equals(status)) {
                earlyLeave++;
            } else if ("缺勤".equals(status)) {
                absent++;
            } else if ("请假".equals(status)) {
                leave++;
            }
        }
        
        List<Map<String, Object>> statusData = new ArrayList<>();
        statusData.add(Map.of("value", normal, "name", "正常"));
        statusData.add(Map.of("value", late, "name", "迟到"));
        statusData.add(Map.of("value", earlyLeave, "name", "早退"));
        statusData.add(Map.of("value", absent, "name", "缺勤"));
        statusData.add(Map.of("value", leave, "name", "请假"));
        
        result.put("statusData", statusData);
        
        return result;
    }
}