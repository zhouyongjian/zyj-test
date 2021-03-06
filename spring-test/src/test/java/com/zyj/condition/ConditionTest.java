package com.zyj.condition;

import com.zyj.config.MyConfigration4Condition;
import com.zyj.pojo.Color;
import com.zyj.pojo.SystemName;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

public class ConditionTest {

    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfigration4Condition.class);


    @Test
    public void test02(){
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        String[] beanNamesForType = beanDefinitionNames;

        for (String s : beanNamesForType) {
            System.out.println(s);
        }

    }

    @Test
    public void test01(){
        String[] beanNamesForType = applicationContext.getBeanNamesForType(SystemName.class);

        for (String s : beanNamesForType) {
            System.out.println(s);
        }

        Environment environment = applicationContext.getEnvironment();
        String property = environment.getProperty("os.name");
        System.out.println("sys = " + property);

    }
}
