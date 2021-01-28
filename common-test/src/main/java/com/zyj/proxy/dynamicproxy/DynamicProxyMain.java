package com.zyj.proxy.dynamicproxy;

import com.zyj.proxy.staticproxy.Rule;
import com.zyj.proxy.staticproxy.RuleInfo;

public class DynamicProxyMain {
    public static void main(String[] args) {

        MyInvocationHandler<Rule> myInvocationHandker = new MyInvocationHandler(new RuleInfo());
        Rule object = myInvocationHandker.getObject();

        Rule rule1 = myInvocationHandker.getProxyInstance();
        rule1.retrunRule("dynamic1");
        System.out.println("over");

    }
}
