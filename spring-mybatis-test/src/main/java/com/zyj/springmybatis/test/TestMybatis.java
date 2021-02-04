package com.zyj.springmybatis.test;

import com.zyj.springmybatis.entity.User;
import com.zyj.springmybatis.dao.UserDAO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class TestMybatis {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = build.openSession();
        UserDAO mapper = sqlSession.getMapper(UserDAO.class);
        User user = new User();
        user.setName("zyj");
        user.setPassword("123456");
        mapper.save(user);
        sqlSession.commit();
        sqlSession.close();



    }
}
