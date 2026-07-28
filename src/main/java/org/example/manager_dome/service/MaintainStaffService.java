package org.example.manager_dome.service;

import org.example.manager_dome.entity.MaintainStaff;
import java.util.List;

public interface MaintainStaffService {
    // 根据ID查询维护人员
    MaintainStaff findById(Long id);
    
    // 根据工号查询维护人员
    MaintainStaff findByStaffId(String staffId);
    
    // 查询所有维护人员
    List<MaintainStaff> findAll();
    
    // 根据部门查询维护人员
    List<MaintainStaff> findByDepartment(String department);
    
    // 根据班组查询维护人员
    List<MaintainStaff> findByTeam(String team);
    
    // 保存维护人员
    MaintainStaff save(MaintainStaff maintainStaff);
    
    // 删除维护人员
    void deleteById(Long id);
    
    // 更新维护人员
    MaintainStaff update(MaintainStaff maintainStaff);
}