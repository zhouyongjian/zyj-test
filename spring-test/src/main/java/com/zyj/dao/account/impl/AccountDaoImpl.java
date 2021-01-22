package com.zyj.dao.account.impl;

import com.zyj.dao.account.IAccountDao;
import com.zyj.pojo.Account;
import org.springframework.stereotype.Repository;


@Repository
public class AccountDaoImpl implements IAccountDao {

    @Override
    public Account getById(int id) {
        return new Account(id,"hh", 1.1d);
    }
}
