package com.zyj.suns.proxy.cglib;

import com.zyj.suns.basic.User;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibTest {
    public static void main(final String[] args) {
        // 1. 创建原始对象
        final UserService userService = new UserService();

        /*
             2.通过cglic方式创建代理对象
         */
        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(UserService.class.getClassLoader());
        enhancer.setSuperclass(userService.getClass());


        MethodInterceptor methodInterceptor = new MethodInterceptor() {// 注意，这个MethodInterceptor 是org.springframework.cglib.proxy.MethodInterceptor
            // 等同于InvocationHandler中的invode方法
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("cglib interceptor before");
                Object invoke = method.invoke(userService, objects);
                System.out.println("cglib interceptor before");
                return invoke;
            }
        };
        enhancer.setCallback(methodInterceptor);
        UserService userServiceProxy = (UserService)enhancer.create();
        userServiceProxy.register(new User());
        userServiceProxy.login("zyj", "123456");


    }
}
