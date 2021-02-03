package com.zyj.suns.dynamic;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
public class Arround implements MethodInterceptor {



    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("Arround.invode.before");

        Object proceed = null;
        try {
            proceed = methodInvocation.proceed();
        } catch (Throwable throwable) {
            System.out.println("Arround.invode.exception");
            throwable.printStackTrace();
        }finally {

            System.out.println("Arround.invode.after");
        }


        return proceed;
    }
}
