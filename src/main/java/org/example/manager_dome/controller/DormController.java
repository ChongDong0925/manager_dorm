package org.example.manager_dome.controller;

import org.example.manager_dome.entity.Dorm;
import org.example.manager_dome.service.DormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/dorm")
public class DormController {

    @Autowired
    private DormService dormService;

    // 宿舍列表页面
    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("dorms", dormService.findAll());
        return "dorm/dorm_list";
    }

    // 新增宿舍页面
    @GetMapping("/add")
    public String add() {
        return "dorm/dorm_add";
    }

    // 编辑宿舍页面
    @GetMapping("/edit")
    public String edit(@RequestParam("id") Long id, Model model) {
        model.addAttribute("dorm", dormService.findById(id));
        return "dorm/dorm_edit";
    }

    // 保存宿舍
    @PostMapping("/save")
    public String save(@RequestParam(value = "id", required = false) Long id,
                      @RequestParam("dormNumber") String dormNumber,
                      @RequestParam("building") String building,
                      @RequestParam("floor") Integer floor,
                      @RequestParam("roomType") String roomType,
                      @RequestParam("capacity") Integer capacity,
                      @RequestParam("status") String status,
                      @RequestParam("description") String description) {
        Dorm dorm;
        if (id != null) {
            dorm = dormService.findById(id);
        } else {
            dorm = new Dorm();
        }
        dorm.setDormNumber(dormNumber);
        dorm.setBuilding(building);
        dorm.setFloor(floor);
        dorm.setRoomType(roomType);
        dorm.setCapacity(capacity);
        dorm.setStatus(status);
        dorm.setDescription(description);
        dormService.save(dorm);
        return "redirect:/dorm/list";
    }

    // 更新宿舍
    @PostMapping("/update")
    public String update(@RequestParam("id") Long id,
                        @RequestParam("dormNumber") String dormNumber,
                        @RequestParam("building") String building,
                        @RequestParam("floor") Integer floor,
                        @RequestParam("roomType") String roomType,
                        @RequestParam("capacity") Integer capacity,
                        @RequestParam("status") String status,
                        @RequestParam("description") String description) {
        Dorm dorm = dormService.findById(id);
        dorm.setDormNumber(dormNumber);
        dorm.setBuilding(building);
        dorm.setFloor(floor);
        dorm.setRoomType(roomType);
        dorm.setCapacity(capacity);
        dorm.setStatus(status);
        dorm.setDescription(description);
        dormService.save(dorm);
        return "redirect:/dorm/list";
    }

    // 删除宿舍
    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
        dormService.deleteById(id);
        return "redirect:/dorm/list";
    }
}