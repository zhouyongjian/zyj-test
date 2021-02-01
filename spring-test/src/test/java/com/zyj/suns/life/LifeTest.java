package com.zyj.suns.life;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifeTest {

    @Test
    public void test(){
        ClassPathXmlApplicationContext atc = new ClassPathXmlApplicationContext("/spring/beans.xml");
    }
}
