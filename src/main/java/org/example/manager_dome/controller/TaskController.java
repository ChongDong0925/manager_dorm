package org.example.manager_dome.controller;

import org.example.manager_dome.entity.MaintainTask;
import org.example.manager_dome.service.MaintainTaskService;
import org.example.manager_dome.service.MaintainStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private MaintainTaskService maintainTaskService;

    @Autowired
    private MaintainStaffService maintainStaffService;

    // 任务列表页面
    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("tasks", maintainTaskService.findAll());
        return "task/task_list";
    }

    // 新增任务页面
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("staffs", maintainStaffService.findAll());
        return "task/task_add";
    }

    // 编辑任务页面
    @GetMapping("/edit")
    public String edit(@RequestParam("id") Long id, Model model) {
        model.addAttribute("task", maintainTaskService.findById(id));
        model.addAttribute("staffs", maintainStaffService.findAll());
        return "task/task_edit";
    }

    // 任务详情页面
    @GetMapping("/detail")
    public String detail(@RequestParam("id") Long id, Model model) {
        model.addAttribute("task", maintainTaskService.findById(id));
        return "task/task_detail";
    }

    // 保存任务
    @PostMapping("/save")
    public String save(@RequestParam(value = "id", required = false) Long id,
                      @RequestParam("taskType") String taskType,
                      @RequestParam("dormNumber") String dormNumber,
                      @RequestParam("building") String building,
                      @RequestParam("description") String description,
                      @RequestParam("assignStaffId") Long assignStaffId,
                      @RequestParam("priority") String priority) {
        MaintainTask task;
        if (id != null) {
            task = maintainTaskService.findById(id);
        } else {
            task = new MaintainTask();
        }
        task.setTaskType(taskType);
        task.setDormNumber(dormNumber);
        task.setBuilding(building);
        task.setDescription(description);
        task.setAssignStaffId(assignStaffId);
        task.setAssignStaffName(maintainStaffService.findById(assignStaffId).getName());
        task.setPriority(priority);
        if (id == null) {
            task.setStatus("待处理");
            task.setCreateTime(java.time.LocalDateTime.now().toString());
        }
        maintainTaskService.save(task);
        return "redirect:/task/list";
    }

    // 更新任务
    @PostMapping("/update")
    public String update(@RequestParam("id") Long id,
                        @RequestParam("taskType") String taskType,
                        @RequestParam("dormNumber") String dormNumber,
                        @RequestParam("building") String building,
                        @RequestParam("description") String description,
                        @RequestParam("assignStaffId") Long assignStaffId,
                        @RequestParam("priority") String priority,
                        @RequestParam("status") String status,
                        @RequestParam("remark") String remark) {
        MaintainTask task = maintainTaskService.findById(id);
        task.setTaskType(taskType);
        task.setDormNumber(dormNumber);
        task.setBuilding(building);
        task.setDescription(description);
        task.setAssignStaffId(assignStaffId);
        task.setAssignStaffName(maintainStaffService.findById(assignStaffId).getName());
        task.setPriority(priority);
        task.setStatus(status);
        task.setRemark(remark);
        maintainTaskService.save(task);
        return "redirect:/task/list";
    }

    // 删除任务
    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
        maintainTaskService.deleteById(id);
        return "redirect:/task/list";
    }

    // 分配任务
    @PostMapping("/assign")
    public String assign(@RequestParam("taskId") Long taskId,
                        @RequestParam("staffId") Long staffId) {
        maintainTaskService.assignTask(taskId, staffId, maintainStaffService.findById(staffId).getName());
        return "redirect:/task/list";
    }

    // 更新任务状态
    @PostMapping("/updateStatus")
    public String updateStatus(@RequestParam("taskId") Long taskId,
                              @RequestParam("status") String status) {
        maintainTaskService.updateTaskStatus(taskId, status);
        return "redirect:/task/list";
    }
}