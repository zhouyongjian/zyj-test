package com.zyj.service.impl;

import com.zyj.dao.account.IAccountDao;
import com.zyj.dao.user.IUserDao;
import com.zyj.pojo.Account;
import com.zyj.pojo.User;
import com.zyj.service.IAccountService;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "accountService")
public class AccountServiceImpl implements IAccountService, BeanNameAware  {
    public void setBeanName(String name) {
        System.out.println("beanName======"+ name);
//        System.out.println(accountDao.toString());
    }

    @Autowired
    private IAccountDao accountDao;


    @Autowired
    private IUserDao userDao;


    public User getUser(int id) {
        return userDao.getUser(id);
    }


    public Account getById(int id) {
        return accountDao.getById(id);
    }

}
