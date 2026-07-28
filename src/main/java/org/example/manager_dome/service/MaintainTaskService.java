package org.example.manager_dome.service;

import org.example.manager_dome.entity.MaintainTask;
import java.util.List;

public interface MaintainTaskService {
    // 根据ID查询任务
    MaintainTask findById(Long id);
    
    // 根据任务编号查询任务
    MaintainTask findByTaskId(String taskId);
    
    // 查询所有任务
    List<MaintainTask> findAll();
    
    // 根据任务类型查询任务
    List<MaintainTask> findByTaskType(String taskType);
    
    // 根据状态查询任务
    List<MaintainTask> findByStatus(String status);
    
    // 根据分配人员ID查询任务
    List<MaintainTask> findByAssignStaffId(Long assignStaffId);
    
    // 保存任务
    MaintainTask save(MaintainTask maintainTask);
    
    // 删除任务
    void deleteById(Long id);
    
    // 更新任务
    MaintainTask update(MaintainTask maintainTask);
    
    // 分配任务
    MaintainTask assignTask(Long taskId, Long staffId, String staffName);
    
    // 更新任务状态
    MaintainTask updateTaskStatus(Long taskId, String status);
}