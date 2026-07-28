package org.example.manager_dome.service;

import org.example.manager_dome.entity.Schedule;
import java.util.List;

public interface ScheduleService {
    // 根据ID查询排班
    Schedule findById(Long id);
    
    // 查询所有排班
    List<Schedule> findAll();
    
    // 根据排班日期查询排班
    List<Schedule> findByScheduleDate(String scheduleDate);
    
    // 根据人员ID查询排班
    List<Schedule> findByStaffId(Long staffId);
    
    // 根据班次查询排班
    List<Schedule> findByShift(String shift);
    
    // 根据人员ID和排班日期查询排班
    List<Schedule> findByStaffIdAndScheduleDate(Long staffId, String scheduleDate);
    
    // 保存排班
    Schedule save(Schedule schedule);
    
    // 删除排班
    void deleteById(Long id);
    
    // 更新排班
    Schedule update(Schedule schedule);
}