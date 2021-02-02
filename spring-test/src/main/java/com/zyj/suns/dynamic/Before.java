package com.zyj.suns.dynamic;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class Before implements MethodBeforeAdvice {
    /**
     * 作用：需要把运行在原始方法执行之前运行的额外功能，书写在before方法中
     * @param method 额外功能所增加给的哪个原始方法
     * @param objects 原始方法的参数
     * @param o 原始对象
     * @throws Throwable
     */
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println(method.getName());
        System.out.println("------Method before advice log -----");

    }
}
