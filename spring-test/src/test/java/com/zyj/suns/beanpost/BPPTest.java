package com.zyj.suns.beanpost;

import com.zyj.suns.life.Product;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BPPTest {

    /**
     * 测试beanPosstProcessor
     */
    @Test
    public void test(){
        ClassPathXmlApplicationContext atc = new ClassPathXmlApplicationContext("/spring/beans.xml");
        Categroy c = atc.getBean("c", Categroy.class);
        System.out.println(c);
        atc.close();
    }
}
