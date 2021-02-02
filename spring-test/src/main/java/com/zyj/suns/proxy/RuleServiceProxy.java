package com.zyj.suns.proxy;

public class RuleServiceProxy implements RuleService {

    private RuleService rule;

    public RuleServiceProxy(RuleService rule) {
        this.rule = rule;
    }

    @Override
    public String retrunRule(String info) {
        try {
            methodBefore();
           return  rule.retrunRule("info");
        }finally {
            methodAfter();
        }
    }


    public void  methodBefore(){
        System.out.println("before");
    }

    public void  methodAfter(){
        System.out.println("after");
    }
}
