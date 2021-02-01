package com.zyj.suns.basic;

public class UserServiceImpl implements UserService {

    private UserDao userDao = BeanFactory.getUserDao();
    @Override
    public void register(User user) {
        userDao.register(user);
    }

    @Override
    public void login(String name, String password) {
        userDao.login(name, password);
    }
}
