package com.zyj.anno;

import com.zyj.anno.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnnotation {
    @Test
    public void test(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        User bean = ctx.getBean(User.class);
        System.out.println(bean);
    }
}
