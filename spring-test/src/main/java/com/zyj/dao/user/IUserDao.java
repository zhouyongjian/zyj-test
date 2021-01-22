package com.zyj.dao.user;

import com.zyj.dao.base.BaseDao;
import com.zyj.pojo.User;

public interface IUserDao extends BaseDao<User> {
    User getUser(int id);
}
