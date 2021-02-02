package com.zyj.suns.spring;

import com.zyj.suns.life.Product;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;

public class PropTest {
    @Test
    public void test(){
        ClassPathXmlApplicationContext atc = new ClassPathXmlApplicationContext("/spring/beans1.xml");
        Connection conn = atc.getBean("conn", Connection.class);
        System.out.println(conn);

    }
}
