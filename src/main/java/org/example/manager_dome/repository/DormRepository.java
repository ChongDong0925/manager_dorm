package org.example.manager_dome.repository;

import org.example.manager_dome.entity.Dorm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DormRepository extends JpaRepository<Dorm, Long> {
    // 根据宿舍号查询宿舍
    Dorm findByDormNumber(String dormNumber);
    
    // 根据楼栋查询宿舍列表
    List<Dorm> findByBuilding(String building);
    
    // 根据状态查询宿舍列表
    List<Dorm> findByStatus(String status);
    
    // 根据房间类型查询宿舍列表
    List<Dorm> findByRoomType(String roomType);
}