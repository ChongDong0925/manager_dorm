package org.example.manager_dome.service.impl;

import org.example.manager_dome.entity.MaintainTask;
import org.example.manager_dome.repository.MaintainTaskRepository;
import org.example.manager_dome.service.MaintainTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class MaintainTaskServiceImpl implements MaintainTaskService {

    @Autowired
    private MaintainTaskRepository maintainTaskRepository;

    @Override
    public MaintainTask findById(Long id) {
        return maintainTaskRepository.findById(id).orElse(null);
    }

    @Override
    public MaintainTask findByTaskId(String taskId) {
        return maintainTaskRepository.findByTaskId(taskId);
    }

    @Override
    public List<MaintainTask> findAll() {
        return maintainTaskRepository.findAll();
    }

    @Override
    public List<MaintainTask> findByTaskType(String taskType) {
        return maintainTaskRepository.findByTaskType(taskType);
    }

    @Override
    public List<MaintainTask> findByStatus(String status) {
        return maintainTaskRepository.findByStatus(status);
    }

    @Override
    public List<MaintainTask> findByAssignStaffId(Long assignStaffId) {
        return maintainTaskRepository.findByAssignStaffId(assignStaffId);
    }

    @Override
    public MaintainTask save(MaintainTask maintainTask) {
        // 生成任务编号
        if (maintainTask.getTaskId() == null) {
            String taskId = "TASK" + System.currentTimeMillis() + UUID.randomUUID().toString().substring(0, 6).toUpperCase();
            maintainTask.setTaskId(taskId);
        }
        return maintainTaskRepository.save(maintainTask);
    }

    @Override
    public void deleteById(Long id) {
        maintainTaskRepository.deleteById(id);
    }

    @Override
    public MaintainTask update(MaintainTask maintainTask) {
        MaintainTask existingTask = maintainTaskRepository.findById(maintainTask.getId()).orElse(null);
        if (existingTask != null) {
            // 只更新非空字段
            if (maintainTask.getTaskType() != null) {
                existingTask.setTaskType(maintainTask.getTaskType());
            }
            if (maintainTask.getDormId() != null) {
                existingTask.setDormId(maintainTask.getDormId());
            }
            if (maintainTask.getDormNumber() != null) {
                existingTask.setDormNumber(maintainTask.getDormNumber());
            }
            if (maintainTask.getBuilding() != null) {
                existingTask.setBuilding(maintainTask.getBuilding());
            }
            if (maintainTask.getDescription() != null) {
                existingTask.setDescription(maintainTask.getDescription());
            }
            if (maintainTask.getAssignStaffId() != null) {
                existingTask.setAssignStaffId(maintainTask.getAssignStaffId());
            }
            if (maintainTask.getAssignStaffName() != null) {
                existingTask.setAssignStaffName(maintainTask.getAssignStaffName());
            }
            if (maintainTask.getStatus() != null) {
                existingTask.setStatus(maintainTask.getStatus());
            }
            if (maintainTask.getPriority() != null) {
                existingTask.setPriority(maintainTask.getPriority());
            }
            if (maintainTask.getStartTime() != null) {
                existingTask.setStartTime(maintainTask.getStartTime());
            }
            if (maintainTask.getCompleteTime() != null) {
                existingTask.setCompleteTime(maintainTask.getCompleteTime());
            }
            if (maintainTask.getHandler() != null) {
                existingTask.setHandler(maintainTask.getHandler());
            }
            if (maintainTask.getRemark() != null) {
                existingTask.setRemark(maintainTask.getRemark());
            }
            return maintainTaskRepository.save(existingTask);
        }
        return null;
    }

    @Override
    public MaintainTask assignTask(Long taskId, Long staffId, String staffName) {
        MaintainTask task = maintainTaskRepository.findById(taskId).orElse(null);
        if (task != null) {
            task.setAssignStaffId(staffId);
            task.setAssignStaffName(staffName);
            task.setStatus("处理中");
            return maintainTaskRepository.save(task);
        }
        return null;
    }

    @Override
    public MaintainTask updateTaskStatus(Long taskId, String status) {
        MaintainTask task = maintainTaskRepository.findById(taskId).orElse(null);
        if (task != null) {
            task.setStatus(status);
            // 如果状态为已完成，设置完成时间
            if ("已完成".equals(status)) {
                task.setCompleteTime(java.time.LocalDateTime.now().toString());
            }
            // 如果状态为处理中，设置开始时间
            if ("处理中".equals(status)) {
                task.setStartTime(java.time.LocalDateTime.now().toString());
            }
            return maintainTaskRepository.save(task);
        }
        return null;
    }
}