package com.zyj.suns.spring;

import com.zyj.suns.basic.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

    /**
     * 通过id获取回object
     */
    @Test
    public void test1(){

        ApplicationContext ac = new ClassPathXmlApplicationContext("spring/beans.xml");

        Person person = (Person) ac.getBean("person");
        System.out.println(person);
    }
    /**
     * 通过id,class获取回泛型
     */
    @Test
    public void test2(){

        ApplicationContext ac = new ClassPathXmlApplicationContext("spring/beans.xml");

        Person person2 = ac.getBean("person2", Person.class);

        System.out.println(person2);
    }

    /**
     * 通过class获取
     * 这种方式获取，只允许一个bean class是person类型的(<bean class=""></bean>)：'com.zyj.suns.basic.Person' available: expected single matching bean but found 2: person,person1
     */
    @Test
    public void test3(){

        ApplicationContext ac = new ClassPathXmlApplicationContext("spring/beans.xml");

        Person bean = ac.getBean(Person.class);// 这种方式获取，只允许一个bean class是person类型的(<bean class=""></bean>)：'com.zyj.suns.basic.Person' available: expected single matching bean but found 2: person,person1
        System.out.println(bean);
    }

    /**
     *获取applicationcontext的一些方法
     */
    @Test
    public void test4(){

        ApplicationContext ac = new ClassPathXmlApplicationContext("spring/beans.xml");
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();// 获取所有bean的id值
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }

        String[] beanNamesForType = ac.getBeanNamesForType(Person.class);
        for (String beanDefinitionName : beanNamesForType) {
            System.out.println(beanDefinitionName);
        }

        System.out.println(ac.containsBeanDefinition("user"));// 是否存在指定id值得bean，不判断别名
        if (ac.containsBean("person")) {// 是否存在指定id值得bean
            System.out.println(true);
        }
    }

}
