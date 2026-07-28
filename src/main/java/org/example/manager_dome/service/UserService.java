package org.example.manager_dome.service;

import org.example.manager_dome.entity.User;
import java.util.List;

public interface UserService {
    // 根据ID查询用户
    User findById(Long id);
    
    // 根据用户名查询用户
    User findByUsername(String username);
    
    // 查询所有用户
    List<User> findAll();
    
    // 根据角色查询用户
    List<User> findByRole(String role);
    
    // 保存用户
    User save(User user);
    
    // 删除用户
    void deleteById(Long id);
    
    // 更新用户
    User update(User user);
    
    // 用户登录
    User login(String username, String password);
    
    // 用户注册
    User register(User user);
}