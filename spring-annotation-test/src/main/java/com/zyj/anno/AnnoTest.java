package com.zyj.anno;

import com.zyj.anno.config.MyAnnoConfig;
import com.zyj.anno.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnoTest {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(MyAnnoConfig.class);
        User bean = ac.getBean(User.class);
        System.out.println(bean);

    }
}
