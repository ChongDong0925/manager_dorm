package org.example.manager_dome.controller;

import org.example.manager_dome.entity.MaintainStaff;
import org.example.manager_dome.service.MaintainStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/staff")
public class MaintainStaffController {

    @Autowired
    private MaintainStaffService maintainStaffService;

    // 维护人员列表页面
    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("staffs", maintainStaffService.findAll());
        return "staff/staff_list";
    }

    // 新增维护人员页面
    @GetMapping("/add")
    public String add() {
        return "staff/staff_add";
    }

    // 编辑维护人员页面
    @GetMapping("/edit")
    public String edit(@RequestParam("id") Long id, Model model) {
        model.addAttribute("staff", maintainStaffService.findById(id));
        return "staff/staff_edit";
    }

    // 保存维护人员
    @PostMapping("/save")
    public String save(@RequestParam(value = "id", required = false) Long id,
                      @RequestParam("staffId") String staffId,
                      @RequestParam("name") String name,
                      @RequestParam("phone") String phone,
                      @RequestParam("department") String department,
                      @RequestParam("team") String team,
                      @RequestParam("position") String position,
                      @RequestParam("status") String status) {
        MaintainStaff staff;
        if (id != null) {
            staff = maintainStaffService.findById(id);
        } else {
            staff = new MaintainStaff();
        }
        staff.setStaffId(staffId);
        staff.setName(name);
        staff.setPhone(phone);
        staff.setDepartment(department);
        staff.setTeam(team);
        staff.setPosition(position);
        staff.setStatus(status);
        if (id == null) {
            staff.setCreateTime(java.time.LocalDateTime.now().toString());
        }
        staff.setUpdateTime(java.time.LocalDateTime.now().toString());
        maintainStaffService.save(staff);
        return "redirect:/staff/list";
    }

    // 更新维护人员
    @PostMapping("/update")
    public String update(@RequestParam("id") Long id,
                        @RequestParam("staffId") String staffId,
                        @RequestParam("name") String name,
                        @RequestParam("phone") String phone,
                        @RequestParam("department") String department,
                        @RequestParam("team") String team,
                        @RequestParam("position") String position,
                        @RequestParam("status") String status) {
        MaintainStaff staff = maintainStaffService.findById(id);
        staff.setStaffId(staffId);
        staff.setName(name);
        staff.setPhone(phone);
        staff.setDepartment(department);
        staff.setTeam(team);
        staff.setPosition(position);
        staff.setStatus(status);
        staff.setUpdateTime(java.time.LocalDateTime.now().toString());
        maintainStaffService.save(staff);
        return "redirect:/staff/list";
    }

    // 删除维护人员
    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
        maintainStaffService.deleteById(id);
        return "redirect:/staff/list";
    }
}
