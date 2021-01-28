package com.zyj.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvocationHandler<T> implements InvocationHandler {

    private T object;

    public MyInvocationHandler(T object) {
        this.object = object;
    }

    public  T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        methodBefore();
        Object invoke = method.invoke(object, args);
        methodAfter();
        return invoke;
    }


    public <T> T getProxyInstance(){
        return (T)Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), this);
    }



    public void  methodBefore(){
        System.out.println("dynamic before");
    }

    public void  methodAfter(){
        System.out.println(" dynamic after");
    }
}
