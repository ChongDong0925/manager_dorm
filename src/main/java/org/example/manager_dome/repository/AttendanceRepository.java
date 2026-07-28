package org.example.manager_dome.repository;

import org.example.manager_dome.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    // 根据考勤日期查询考勤列表
    List<Attendance> findByAttendanceDate(String attendanceDate);
    
    // 根据人员ID查询考勤列表
    List<Attendance> findByStaffId(Long staffId);
    
    // 根据状态查询考勤列表
    List<Attendance> findByStatus(String status);
    
    // 根据考勤日期和人员ID查询考勤
    Attendance findByAttendanceDateAndStaffId(String attendanceDate, Long staffId);
}