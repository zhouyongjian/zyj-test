package com.zyj.suns.basic;

public class UserDaoImpl implements UserDao<User> {
    @Override
    public void register(User user) {
        System.out.println("User = " + user);
    }

    @Override
    public void login(String name, String password) {
        System.out.println("login " + name + ":"+password);
    }
}
