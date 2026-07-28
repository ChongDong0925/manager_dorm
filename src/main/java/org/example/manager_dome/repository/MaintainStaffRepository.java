package org.example.manager_dome.repository;

import org.example.manager_dome.entity.MaintainStaff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MaintainStaffRepository extends JpaRepository<MaintainStaff, Long> {
    // 根据工号查询维护人员
    MaintainStaff findByStaffId(String staffId);
    
    // 根据姓名查询维护人员列表
    List<MaintainStaff> findByName(String name);
    
    // 根据部门查询维护人员列表
    List<MaintainStaff> findByDepartment(String department);
    
    // 根据班组查询维护人员列表
    List<MaintainStaff> findByTeam(String team);
    
    // 根据状态查询维护人员列表
    List<MaintainStaff> findByStatus(String status);
}