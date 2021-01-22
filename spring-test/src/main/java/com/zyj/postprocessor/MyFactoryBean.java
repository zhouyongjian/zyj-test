package com.zyj.postprocessor;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 可以通过getObject方法返回指定mapper的对象，默认单例（FactoryBean.isSingleton）
 */
public class MyFactoryBean implements FactoryBean {

    private Class mapper;

    public MyFactoryBean(Class mapper) {

        this.mapper = mapper;
    }

    @Override
    public Object getObject() throws Exception {
//        Object o = Proxy.newProxyInstance(MyFactoryBean.class.getClassLoader(), new Class[]{mapper}, new InvocationHandler() {
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                return proxy;
//            }
//        });
        return mapper.newInstance();
    }
    @Override
    public Class<?> getObjectType() {
        return mapper;
    }
}
