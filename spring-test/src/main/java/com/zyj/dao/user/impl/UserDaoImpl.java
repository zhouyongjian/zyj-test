package com.zyj.dao.user.impl;

import com.zyj.dao.base.impl.BaseDaoImpl;
import com.zyj.dao.user.IUserDao;
import com.zyj.pojo.User;

public class UserDaoImpl  extends BaseDaoImpl <User> implements IUserDao {

    @Override
    public User getUser(int id) {
        return new User(id,"test");
    }
}
