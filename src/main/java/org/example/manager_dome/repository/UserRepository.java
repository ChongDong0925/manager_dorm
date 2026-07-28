package org.example.manager_dome.repository;

import org.example.manager_dome.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // 根据用户名查询用户
    User findByUsername(String username);
    
    // 根据角色查询用户列表
    List<User> findByRole(String role);
    
    // 根据状态查询用户列表
    List<User> findByStatus(Integer status);
}