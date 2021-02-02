package com.zyj.suns.proxy;

public class RuleServiceImpl implements RuleService {
    @Override
    public String retrunRule(String info) {
        System.out.println("into retrunRule");
        return "RuleServiceImpl = " + info;
    }
}
