package org.example.manager_dome.controller;

import org.example.manager_dome.entity.Schedule;
import org.example.manager_dome.service.ScheduleService;
import org.example.manager_dome.service.MaintainStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private MaintainStaffService maintainStaffService;

    // 排班列表页面
    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("schedules", scheduleService.findAll());
        return "schedule/schedule_list";
    }

    // 新增排班页面
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("staffs", maintainStaffService.findAll());
        return "schedule/schedule_add";
    }

    // 编辑排班页面
    @GetMapping("/edit")
    public String edit(@RequestParam("id") Long id, Model model) {
        model.addAttribute("schedule", scheduleService.findById(id));
        model.addAttribute("staffs", maintainStaffService.findAll());
        return "schedule/schedule_edit";
    }

    // 保存排班
    @PostMapping("/save")
    public String save(@RequestParam(value = "id", required = false) Long id,
                      @RequestParam("scheduleDate") String scheduleDate,
                      @RequestParam("staffId") Long staffId,
                      @RequestParam("shift") String shift,
                      @RequestParam("startTime") String startTime,
                      @RequestParam("endTime") String endTime,
                      @RequestParam("position") String position,
                      @RequestParam("status") String status,
                      @RequestParam("remark") String remark) {
        Schedule schedule;
        if (id != null) {
            schedule = scheduleService.findById(id);
        } else {
            schedule = new Schedule();
        }
        schedule.setScheduleDate(scheduleDate);
        schedule.setStaffId(staffId);
        schedule.setStaffName(maintainStaffService.findById(staffId).getName());
        schedule.setShift(shift);
        schedule.setStartTime(startTime);
        schedule.setEndTime(endTime);
        schedule.setPosition(position);
        schedule.setStatus(status);
        schedule.setRemark(remark);
        scheduleService.save(schedule);
        return "redirect:/schedule/list";
    }

    // 更新排班
    @PostMapping("/update")
    public String update(@RequestParam("id") Long id,
                        @RequestParam("scheduleDate") String scheduleDate,
                        @RequestParam("staffId") Long staffId,
                        @RequestParam("shift") String shift,
                        @RequestParam("startTime") String startTime,
                        @RequestParam("endTime") String endTime,
                        @RequestParam("position") String position,
                        @RequestParam("status") String status,
                        @RequestParam("remark") String remark) {
        Schedule schedule = scheduleService.findById(id);
        schedule.setScheduleDate(scheduleDate);
        schedule.setStaffId(staffId);
        schedule.setStaffName(maintainStaffService.findById(staffId).getName());
        schedule.setShift(shift);
        schedule.setStartTime(startTime);
        schedule.setEndTime(endTime);
        schedule.setPosition(position);
        schedule.setStatus(status);
        schedule.setRemark(remark);
        scheduleService.save(schedule);
        return "redirect:/schedule/list";
    }

    // 删除排班
    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
        scheduleService.deleteById(id);
        return "redirect:/schedule/list";
    }
}