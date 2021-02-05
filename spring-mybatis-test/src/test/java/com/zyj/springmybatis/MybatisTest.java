package com.zyj.springmybatis;

import com.zyj.springmybatis.dao.service.Userservice;
import com.zyj.springmybatis.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MybatisTest {

    @Test
    public void test(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/applicationContext.xml");

        Userservice userDAO = ctx.getBean("userService", Userservice.class);
        User user = new User();
        user.setName("wangwu");

        user.setPassword("3434343");
        userDAO.register(user);
    }
}
