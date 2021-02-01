package com.zyj.suns.spring;

import com.zyj.suns.factorybean.ConnectionFactoryBean;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;

public class FactoryBeanTest {

    @Test
    public void testFB(){
        ClassPathXmlApplicationContext act = new ClassPathXmlApplicationContext("spring/beans.xml");
        Connection conn1 = act.getBean("conn", Connection.class);
        try {
            System.out.println(conn1.getTransactionIsolation());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过&直接获取FactoryBean对象
     */
    @Test
    public void testFB1(){
        ClassPathXmlApplicationContext act = new ClassPathXmlApplicationContext("spring/beans.xml");
        ConnectionFactoryBean connectionFactoryBean = act.getBean("&conn", ConnectionFactoryBean.class);
        try {
            System.out.println(connectionFactoryBean.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFBSingleton(){

            ClassPathXmlApplicationContext act = new ClassPathXmlApplicationContext("spring/beans.xml");
            Connection conn1 = act.getBean("conn", Connection.class);
            Connection conn2 = act.getBean("conn", Connection.class);
            System.out.println( "conn = " + conn1);
            System.out.println( "conn = " + conn2);
    }
}
