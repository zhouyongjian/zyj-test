package com.zyj.service;

import com.zyj.pojo.Account;
import com.zyj.pojo.User;

public interface IAccountService
{
    Account getById(int id);
    public User getUser(int id);
}
