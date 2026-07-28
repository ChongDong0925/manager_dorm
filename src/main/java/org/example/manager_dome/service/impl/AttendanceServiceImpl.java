package org.example.manager_dome.service.impl;

import org.example.manager_dome.entity.Attendance;
import org.example.manager_dome.entity.Schedule;
import org.example.manager_dome.repository.AttendanceRepository;
import org.example.manager_dome.service.AttendanceService;
import org.example.manager_dome.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private ScheduleService scheduleService;

    @Override
    public Attendance findById(Long id) {
        return attendanceRepository.findById(id).orElse(null);
    }

    @Override
    public List<Attendance> findAll() {
        return attendanceRepository.findAll();
    }

    @Override
    public List<Attendance> findByAttendanceDate(String attendanceDate) {
        return attendanceRepository.findByAttendanceDate(attendanceDate);
    }

    @Override
    public List<Attendance> findByStaffId(Long staffId) {
        return attendanceRepository.findByStaffId(staffId);
    }

    @Override
    public List<Attendance> findByStatus(String status) {
        return attendanceRepository.findByStatus(status);
    }

    @Override
    public Attendance save(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    @Override
    public void deleteById(Long id) {
        attendanceRepository.deleteById(id);
    }

    @Override
    public Attendance update(Attendance attendance) {
        Attendance existingAttendance = attendanceRepository.findById(attendance.getId()).orElse(null);
        if (existingAttendance != null) {
            // 只更新非空字段
            if (attendance.getAttendanceDate() != null) {
                existingAttendance.setAttendanceDate(attendance.getAttendanceDate());
            }
            if (attendance.getStaffId() != null) {
                existingAttendance.setStaffId(attendance.getStaffId());
            }
            if (attendance.getStaffName() != null) {
                existingAttendance.setStaffName(attendance.getStaffName());
            }
            if (attendance.getCheckInTime() != null) {
                existingAttendance.setCheckInTime(attendance.getCheckInTime());
            }
            if (attendance.getCheckOutTime() != null) {
                existingAttendance.setCheckOutTime(attendance.getCheckOutTime());
            }
            if (attendance.getStatus() != null) {
                existingAttendance.setStatus(attendance.getStatus());
            }
            if (attendance.getRemark() != null) {
                existingAttendance.setRemark(attendance.getRemark());
            }
            return attendanceRepository.save(existingAttendance);
        }
        return null;
    }

    @Override
    public Attendance checkIn(Long staffId, String staffName, String attendanceDate, String checkInTime) {
        // 检查是否已经打卡
        Attendance attendance = attendanceRepository.findByAttendanceDateAndStaffId(attendanceDate, staffId);
        if (attendance == null) {
            // 创建新的考勤记录
            attendance = new Attendance();
            attendance.setStaffId(staffId);
            attendance.setStaffName(staffName);
            attendance.setAttendanceDate(attendanceDate);
            attendance.setCheckInTime(checkInTime);
            // 根据排班时间判断考勤状态
            attendance.setStatus(calculateCheckInStatus(staffId, attendanceDate, checkInTime));
        } else {
            // 更新打卡时间
            attendance.setCheckInTime(checkInTime);
            // 更新考勤状态
            attendance.setStatus(calculateCheckInStatus(staffId, attendanceDate, checkInTime));
        }
        return attendanceRepository.save(attendance);
    }

    // 计算上班打卡状态
    private String calculateCheckInStatus(Long staffId, String attendanceDate, String checkInTime) {
        // 获取当天的排班信息
        List<Schedule> schedules = scheduleService.findByStaffIdAndScheduleDate(staffId, attendanceDate);
        if (schedules.isEmpty()) {
            return "缺勤"; // 没有排班
        }
        
        Schedule schedule = schedules.get(0);
        String startTime = schedule.getStartTime();
        if (startTime == null || startTime.isEmpty()) {
            return "正常"; // 没有设置开始时间，默认正常
        }
        
        // 提取时间部分（HH:MM）
        String checkInHourMinute = checkInTime.substring(11, 16);
        
        // 比较时间
        if (checkInHourMinute.compareTo(startTime) <= 0) {
            return "正常"; // 按时或提前打卡
        } else {
            // 计算迟到时间（分钟）
            int checkInHour = Integer.parseInt(checkInHourMinute.substring(0, 2));
            int checkInMinute = Integer.parseInt(checkInHourMinute.substring(3));
            int startHour = Integer.parseInt(startTime.substring(0, 2));
            int startMinute = Integer.parseInt(startTime.substring(3));
            int lateMinutes = (checkInHour - startHour) * 60 + (checkInMinute - startMinute);
            
            if (lateMinutes <= 30) {
                return "迟到"; // 迟到30分钟以内
            } else {
                return "缺勤"; // 迟到超过30分钟
            }
        }
    }

    @Override
    public Attendance checkOut(Long staffId, String attendanceDate, String checkOutTime) {
        // 查找当天的考勤记录
        Attendance attendance = attendanceRepository.findByAttendanceDateAndStaffId(attendanceDate, staffId);
        if (attendance != null) {
            attendance.setCheckOutTime(checkOutTime);
            // 重新评估整体考勤状态
            String finalStatus = calculateOverallStatus(staffId, attendanceDate, attendance.getCheckInTime(), checkOutTime);
            attendance.setStatus(finalStatus);
            return attendanceRepository.save(attendance);
        }
        return null;
    }

    // 计算整体考勤状态
    private String calculateOverallStatus(Long staffId, String attendanceDate, String checkInTime, String checkOutTime) {
        // 获取当天的排班信息
        List<Schedule> schedules = scheduleService.findByStaffIdAndScheduleDate(staffId, attendanceDate);
        if (schedules.isEmpty()) {
            return "缺勤"; // 没有排班
        }
        
        Schedule schedule = schedules.get(0);
        String startTime = schedule.getStartTime();
        String endTime = schedule.getEndTime();
        
        // 提取时间部分（HH:MM）
        String checkInHourMinute = checkInTime.substring(11, 16);
        String checkOutHourMinute = checkOutTime.substring(11, 16);
        
        // 情况1：上下班都在上班时间之前 → 缺勤
        if (startTime != null && !startTime.isEmpty() && endTime != null && !endTime.isEmpty()) {
            if (checkInHourMinute.compareTo(startTime) <= 0 && checkOutHourMinute.compareTo(startTime) <= 0) {
                return "缺勤";
            }
            
            // 情况2：上下班都在下班时间之前 → 早退
            if (checkOutHourMinute.compareTo(endTime) < 0) {
                // 检查上班是否正常
                if (checkInHourMinute.compareTo(startTime) <= 0) {
                    // 计算早退时间
                    int checkOutHour = Integer.parseInt(checkOutHourMinute.substring(0, 2));
                    int checkOutMinute = Integer.parseInt(checkOutHourMinute.substring(3));
                    int endHour = Integer.parseInt(endTime.substring(0, 2));
                    int endMinute = Integer.parseInt(endTime.substring(3));
                    int earlyMinutes = (endHour - checkOutHour) * 60 + (endMinute - checkOutMinute);
                    
                    if (earlyMinutes <= 30) {
                        return "早退";
                    } else {
                        return "缺勤";
                    }
                }
            }
            
            // 情况3：检查上班是否迟到
            if (checkInHourMinute.compareTo(startTime) > 0) {
                int checkInHour = Integer.parseInt(checkInHourMinute.substring(0, 2));
                int checkInMinute = Integer.parseInt(checkInHourMinute.substring(3));
                int startHour = Integer.parseInt(startTime.substring(0, 2));
                int startMinute = Integer.parseInt(startTime.substring(3));
                int lateMinutes = (checkInHour - startHour) * 60 + (checkInMinute - startMinute);
                
                if (lateMinutes <= 30) {
                    return "迟到";
                } else {
                    return "缺勤";
                }
            }
        }
        
        // 其他情况默认正常
        return "正常";
    }
}