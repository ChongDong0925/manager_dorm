package org.example.manager_dome.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class FileConfig implements WebMvcConfigurer {

    @Value("${video.access.path}")
    private String videoAccessPath;

    @Value("${video.storage.path}")
    private String videoStoragePath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 视频文件访问配置
        registry.addResourceHandler(videoAccessPath)
                .addResourceLocations(videoStoragePath);
        
        // 其他文件资源访问配置
        registry.addResourceHandler("/file/**")
                .addResourceLocations("classpath:/static/file/");
    }
}