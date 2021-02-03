package com.zyj.suns.dynamic;

import com.zyj.suns.proxy.RuleService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PointCutTest {

    @Test
    public void  test() {
        ClassPathXmlApplicationContext atc = new ClassPathXmlApplicationContext("/spring/beans3.xml");
        RuleService ruleService = atc.getBean("ruleService", RuleService.class);// 此时获取的是代理对象
        ruleService.retrunRule("zyj" );
    }
}
