package org.example.manager_dome.repository;

import org.example.manager_dome.entity.MaintainTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MaintainTaskRepository extends JpaRepository<MaintainTask, Long> {
    // 根据任务编号查询任务
    MaintainTask findByTaskId(String taskId);
    
    // 根据任务类型查询任务列表
    List<MaintainTask> findByTaskType(String taskType);
    
    // 根据状态查询任务列表
    List<MaintainTask> findByStatus(String status);
    
    // 根据分配人员ID查询任务列表
    List<MaintainTask> findByAssignStaffId(Long assignStaffId);
    
    // 根据宿舍号查询任务列表
    List<MaintainTask> findByDormNumber(String dormNumber);
    
    // 根据楼栋查询任务列表
    List<MaintainTask> findByBuilding(String building);
}