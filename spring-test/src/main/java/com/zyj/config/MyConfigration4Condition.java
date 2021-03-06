package com.zyj.config;


import com.zyj.condition.LinuxCondition;
import com.zyj.pojo.Color;
import com.zyj.pojo.SystemName;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(Color.class)
public class MyConfigration4Condition {
    @Bean("window")
    public SystemName p1(){
        return new SystemName("vwindow");
    }
    @Bean("linux")
    @Conditional(LinuxCondition.class)
    public SystemName p2(){
        return new SystemName("linux");
    }
}
