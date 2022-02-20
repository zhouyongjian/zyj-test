package com.zyj.anno.config;


import com.zyj.anno.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyAnnoConfig {

    @Bean
    public User user(){
        return new User();
    }
}


