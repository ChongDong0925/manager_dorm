package org.example.manager_dome.service;

import org.example.manager_dome.entity.Attendance;
import java.util.List;

public interface AttendanceService {
    // 根据ID查询考勤
    Attendance findById(Long id);
    
    // 查询所有考勤
    List<Attendance> findAll();
    
    // 根据考勤日期查询考勤
    List<Attendance> findByAttendanceDate(String attendanceDate);
    
    // 根据人员ID查询考勤
    List<Attendance> findByStaffId(Long staffId);
    
    // 根据状态查询考勤
    List<Attendance> findByStatus(String status);
    
    // 保存考勤
    Attendance save(Attendance attendance);
    
    // 删除考勤
    void deleteById(Long id);
    
    // 更新考勤
    Attendance update(Attendance attendance);
    
    // 上班打卡
    Attendance checkIn(Long staffId, String staffName, String attendanceDate, String checkInTime);
    
    // 下班打卡
    Attendance checkOut(Long staffId, String attendanceDate, String checkOutTime);
}