package com.zyj.dao.base.impl;

import com.zyj.dao.base.BaseDao;

public abstract class BaseDaoImpl<T> implements BaseDao<T> {
    @Override
    public int insert(T t) {
        return 1;
    }
}
