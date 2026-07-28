package org.example.manager_dome.service.impl;

import org.example.manager_dome.entity.Dorm;
import org.example.manager_dome.repository.DormRepository;
import org.example.manager_dome.service.DormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DormServiceImpl implements DormService {

    @Autowired
    private DormRepository dormRepository;

    @Override
    public Dorm findById(Long id) {
        return dormRepository.findById(id).orElse(null);
    }

    @Override
    public Dorm findByDormNumber(String dormNumber) {
        return dormRepository.findByDormNumber(dormNumber);
    }

    @Override
    public List<Dorm> findAll() {
        return dormRepository.findAll();
    }

    @Override
    public List<Dorm> findByBuilding(String building) {
        return dormRepository.findByBuilding(building);
    }

    @Override
    public List<Dorm> findByStatus(String status) {
        return dormRepository.findByStatus(status);
    }

    @Override
    public Dorm save(Dorm dorm) {
        return dormRepository.save(dorm);
    }

    @Override
    public void deleteById(Long id) {
        dormRepository.deleteById(id);
    }

    @Override
    public Dorm update(Dorm dorm) {
        Dorm existingDorm = dormRepository.findById(dorm.getId()).orElse(null);
        if (existingDorm != null) {
            // 只更新非空字段
            if (dorm.getDormNumber() != null) {
                existingDorm.setDormNumber(dorm.getDormNumber());
            }
            if (dorm.getBuilding() != null) {
                existingDorm.setBuilding(dorm.getBuilding());
            }
            if (dorm.getFloor() != null) {
                existingDorm.setFloor(dorm.getFloor());
            }
            if (dorm.getRoomType() != null) {
                existingDorm.setRoomType(dorm.getRoomType());
            }
            if (dorm.getCapacity() != null) {
                existingDorm.setCapacity(dorm.getCapacity());
            }
            if (dorm.getStatus() != null) {
                existingDorm.setStatus(dorm.getStatus());
            }
            if (dorm.getDescription() != null) {
                existingDorm.setDescription(dorm.getDescription());
            }
            return dormRepository.save(existingDorm);
        }
        return null;
    }
}