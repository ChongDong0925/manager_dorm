package org.example.manager_dome.service;

import org.example.manager_dome.entity.Dorm;
import java.util.List;

public interface DormService {
    // 根据ID查询宿舍
    Dorm findById(Long id);
    
    // 根据宿舍号查询宿舍
    Dorm findByDormNumber(String dormNumber);
    
    // 查询所有宿舍
    List<Dorm> findAll();
    
    // 根据楼栋查询宿舍
    List<Dorm> findByBuilding(String building);
    
    // 根据状态查询宿舍
    List<Dorm> findByStatus(String status);
    
    // 保存宿舍
    Dorm save(Dorm dorm);
    
    // 删除宿舍
    void deleteById(Long id);
    
    // 更新宿舍
    Dorm update(Dorm dorm);
}