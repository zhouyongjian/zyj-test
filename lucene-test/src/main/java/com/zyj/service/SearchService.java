package com.zyj.service;

import com.zyj.pojo.ResultModel;

/**
 *
 */
public interface SearchService {

    public ResultModel query(String queryString, String price, Integer page) throws Exception;
}
