package org.example.manager_dome;

import org.example.manager_dome.entity.MaintainStaff;
import org.example.manager_dome.service.MaintainStaffService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MaintainStaffServiceTest {

    @Autowired
    private MaintainStaffService maintainStaffService;

    @Test
    public void testFindAll() {
        List<MaintainStaff> staffs = maintainStaffService.findAll();
        System.out.println("员工列表大小: " + staffs.size());
        for (MaintainStaff staff : staffs) {
            System.out.println("员工ID: " + staff.getId() + ", 姓名: " + staff.getName() + ", 工号: " + staff.getStaffId());
        }
    }
}
