package com.zyj.myspring.service;

import com.zyj.myspring.anno.Component;
import com.zyj.myspring.definition.BeanPostProcessor;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        System.out.println(beanName + "初始化之前");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {

        System.out.println(beanName + "初始化之后");
        return bean;
    }
}
