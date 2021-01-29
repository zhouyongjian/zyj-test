package com.zyj.myspring;

import com.zyj.myspring.config.AppConfig;
import com.zyj.myspring.service.TestTest;
import com.zyj.myspring.service.UserService;

public class MySpringMain {
    public static void main(String[] args) {
        try {
            MyAnnotationContext context = new MyAnnotationContext(AppConfig.class);

            UserService userService = (UserService)context.getBean("userService");

            System.out.println("==========================");
            System.out.println(context.getBean("testTest"));
            System.out.println(context.getBean("user"));
            userService.test();
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
