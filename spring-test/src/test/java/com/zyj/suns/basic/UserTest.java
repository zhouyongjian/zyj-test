package com.zyj.suns.basic;


import org.junit.Test;

public class UserTest {
    @Test

    public void test(){

//        UserService userService = new UserServiceImpl();
        UserService userService = BeanFactory.getUserService();
        userService.register(new User("zyj", "123456"));

        UserService userService1 = (UserService)BeanFactory.getInstance("userService");
        userService1.login("zyj", "123456");

        UserService userService2 = BeanFactory.getInstanceStong(UserService.class);
        userService1.login("zyj123", "88888");

    }
}
