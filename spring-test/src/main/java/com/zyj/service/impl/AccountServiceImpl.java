package com.zyj.service.impl;

import com.zyj.dao.IAccountDao;
import com.zyj.pojo.Account;
import com.zyj.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "accountService")
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao accountDao;


    @Override
    public Account getById(int id) {
        return accountDao.getById(id);
    }
}
