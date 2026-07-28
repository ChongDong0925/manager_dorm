package org.example.manager_dome.service.impl;

import org.example.manager_dome.entity.Schedule;
import org.example.manager_dome.repository.ScheduleRepository;
import org.example.manager_dome.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Override
    public Schedule findById(Long id) {
        return scheduleRepository.findById(id).orElse(null);
    }

    @Override
    public List<Schedule> findAll() {
        return scheduleRepository.findAll();
    }

    @Override
    public List<Schedule> findByScheduleDate(String scheduleDate) {
        return scheduleRepository.findByScheduleDate(scheduleDate);
    }

    @Override
    public List<Schedule> findByStaffId(Long staffId) {
        return scheduleRepository.findByStaffId(staffId);
    }

    @Override
    public List<Schedule> findByShift(String shift) {
        return scheduleRepository.findByShift(shift);
    }

    @Override
    public List<Schedule> findByStaffIdAndScheduleDate(Long staffId, String scheduleDate) {
        return scheduleRepository.findByScheduleDateAndStaffId(scheduleDate, staffId);
    }

    @Override
    public Schedule save(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    @Override
    public void deleteById(Long id) {
        scheduleRepository.deleteById(id);
    }

    @Override
    public Schedule update(Schedule schedule) {
        Schedule existingSchedule = scheduleRepository.findById(schedule.getId()).orElse(null);
        if (existingSchedule != null) {
            // 只更新非空字段
            if (schedule.getScheduleDate() != null) {
                existingSchedule.setScheduleDate(schedule.getScheduleDate());
            }
            if (schedule.getStaffId() != null) {
                existingSchedule.setStaffId(schedule.getStaffId());
            }
            if (schedule.getStaffName() != null) {
                existingSchedule.setStaffName(schedule.getStaffName());
            }
            if (schedule.getShift() != null) {
                existingSchedule.setShift(schedule.getShift());
            }
            if (schedule.getStartTime() != null) {
                existingSchedule.setStartTime(schedule.getStartTime());
            }
            if (schedule.getEndTime() != null) {
                existingSchedule.setEndTime(schedule.getEndTime());
            }
            if (schedule.getPosition() != null) {
                existingSchedule.setPosition(schedule.getPosition());
            }
            if (schedule.getStatus() != null) {
                existingSchedule.setStatus(schedule.getStatus());
            }
            if (schedule.getRemark() != null) {
                existingSchedule.setRemark(schedule.getRemark());
            }
            return scheduleRepository.save(existingSchedule);
        }
        return null;
    }
}