package com.zyj.springmybatis.dao.service.impl;

import com.zyj.springmybatis.dao.UserDAO;
import com.zyj.springmybatis.dao.service.Userservice;
import com.zyj.springmybatis.entity.User;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class UserServiceImpl implements Userservice {

    private UserDAO userDAO;

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    public void register(User user) {
        userDAO.save(user);
        int i = 1/0;
    }
}
