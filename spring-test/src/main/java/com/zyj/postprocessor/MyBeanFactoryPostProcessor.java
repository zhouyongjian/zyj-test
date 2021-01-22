package com.zyj.postprocessor;

import com.zyj.pojo.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition accountService1 = beanFactory.getBeanDefinition("accountService");
       beanFactory.registerSingleton("testUser", new User(1,"zyj"));// 此时还没有bean创建
        System.out.println("MyBeanFactoryPostProcessor" + "-------------" + accountService1.getBeanClassName());
//accountService1.setBeanClassName("hhhh");

    }
}
