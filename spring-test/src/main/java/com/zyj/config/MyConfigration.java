package com.zyj.config;


import com.zyj.refistrar.MyBeanDefinitionRegistrar;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(value = "com.zyj")
@Import(MyBeanDefinitionRegistrar.class) // 引入新增BeanDefinetion配置类
public class MyConfigration {
}
