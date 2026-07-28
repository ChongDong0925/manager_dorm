package org.example.manager_dome.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "org.example.manager_dome.repository")
public class JpaConfig {
    // JPA配置，默认使用Spring Boot的自动配置
    // 如需自定义配置，可以在此添加相关Bean
}