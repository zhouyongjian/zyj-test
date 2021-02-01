package com.zyj.suns.basic;

public interface UserDao<User> {
    void register(User user);
    void login(String name, String password);
}
