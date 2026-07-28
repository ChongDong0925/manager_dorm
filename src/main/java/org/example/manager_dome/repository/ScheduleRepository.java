package org.example.manager_dome.repository;

import org.example.manager_dome.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    // 根据排班日期查询排班列表
    List<Schedule> findByScheduleDate(String scheduleDate);
    
    // 根据人员ID查询排班列表
    List<Schedule> findByStaffId(Long staffId);
    
    // 根据班次查询排班列表
    List<Schedule> findByShift(String shift);
    
    // 根据状态查询排班列表
    List<Schedule> findByStatus(String status);
    
    // 根据排班日期和人员ID查询排班
    List<Schedule> findByScheduleDateAndStaffId(String scheduleDate, Long staffId);
}