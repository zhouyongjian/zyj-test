package com.zyj.proxy.staticproxy;

public class RuleInfo implements Rule {
    @Override
    public String retrunRule(String info) {
        System.out.println("into etrunRule");
        return "RuleInfo = " + info;
    }
}
