package com.zyj.suns.proxy.cglib;

import com.zyj.suns.basic.User;

public class UserService {
    public void login(String name, String pwd){
        System.out.println("UserService.login");

    }
    public void register(User user){
        System.out.println("UserService.register");
    }
}
