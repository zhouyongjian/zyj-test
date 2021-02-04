package com.zyj.springmybatis;

import com.zyj.springmybatis.dao.UserDAO;
import com.zyj.springmybatis.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    @org.junit.Test
    public void test(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/applicationContext.xml");

        UserDAO userDAO = ctx.getBean("userDAO", UserDAO.class);
        User user = new User();
        user.setName("hh");

        user.setPassword("pwd");
        userDAO.save(user);
    }
}
