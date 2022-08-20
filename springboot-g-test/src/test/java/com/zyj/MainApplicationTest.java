package com.zyj;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
public class MainApplicationTest {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void test(){
        Long a = jdbcTemplate.queryForObject("select count(*) from t;", Long.class);
        System.out.println(a);

    }
}
