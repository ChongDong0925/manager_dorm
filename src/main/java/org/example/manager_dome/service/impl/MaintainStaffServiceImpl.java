package org.example.manager_dome.service.impl;

import org.example.manager_dome.entity.MaintainStaff;
import org.example.manager_dome.repository.MaintainStaffRepository;
import org.example.manager_dome.service.MaintainStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MaintainStaffServiceImpl implements MaintainStaffService {

    @Autowired
    private MaintainStaffRepository maintainStaffRepository;

    @Override
    public MaintainStaff findById(Long id) {
        return maintainStaffRepository.findById(id).orElse(null);
    }

    @Override
    public MaintainStaff findByStaffId(String staffId) {
        return maintainStaffRepository.findByStaffId(staffId);
    }

    @Override
    public List<MaintainStaff> findAll() {
        return maintainStaffRepository.findAll();
    }

    @Override
    public List<MaintainStaff> findByDepartment(String department) {
        return maintainStaffRepository.findByDepartment(department);
    }

    @Override
    public List<MaintainStaff> findByTeam(String team) {
        return maintainStaffRepository.findByTeam(team);
    }

    @Override
    public MaintainStaff save(MaintainStaff maintainStaff) {
        return maintainStaffRepository.save(maintainStaff);
    }

    @Override
    public void deleteById(Long id) {
        maintainStaffRepository.deleteById(id);
    }

    @Override
    public MaintainStaff update(MaintainStaff maintainStaff) {
        MaintainStaff existingStaff = maintainStaffRepository.findById(maintainStaff.getId()).orElse(null);
        if (existingStaff != null) {
            // 只更新非空字段
            if (maintainStaff.getStaffId() != null) {
                existingStaff.setStaffId(maintainStaff.getStaffId());
            }
            if (maintainStaff.getName() != null) {
                existingStaff.setName(maintainStaff.getName());
            }
            if (maintainStaff.getPhone() != null) {
                existingStaff.setPhone(maintainStaff.getPhone());
            }
            if (maintainStaff.getDepartment() != null) {
                existingStaff.setDepartment(maintainStaff.getDepartment());
            }
            if (maintainStaff.getTeam() != null) {
                existingStaff.setTeam(maintainStaff.getTeam());
            }
            if (maintainStaff.getPosition() != null) {
                existingStaff.setPosition(maintainStaff.getPosition());
            }
            if (maintainStaff.getStatus() != null) {
                existingStaff.setStatus(maintainStaff.getStatus());
            }
            return maintainStaffRepository.save(existingStaff);
        }
        return null;
    }
}