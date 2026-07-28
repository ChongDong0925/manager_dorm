package org.example.manager_dome.controller;

import org.example.manager_dome.entity.User;
import org.example.manager_dome.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CommonController {

    @Autowired
    private UserService userService;

    // 登录页面
    @GetMapping("/login")
    public String login() {
        return "common/login";
    }

    // 注册页面
    @GetMapping("/register")
    public String register() {
        return "common/register";
    }

    // 注册处理
    @PostMapping("/register")
    public String register(@RequestParam("username") String username,
                          @RequestParam("password") String password,
                          @RequestParam("name") String name,
                          @RequestParam("phone") String phone,
                          Model model) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setName(name);
        user.setPhone(phone);
        user.setRole("STAFF"); // 默认注册为维护人员
        user.setStatus(1);
        
        User registeredUser = userService.register(user);
        if (registeredUser != null) {
            model.addAttribute("message", "注册成功，请登录");
            return "common/login";
        } else {
            model.addAttribute("message", "注册失败，用户名已存在");
            return "common/register";
        }
    }

    // 退出登录
    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login";
    }

    // 首页
    @GetMapping("/")
    public String index() {
        return "redirect:/dashboard";
    }

    // 仪表盘
    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard/index";
    }
}