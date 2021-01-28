package com.zyj.proxy.staticproxy;

public class ProxyRule implements Rule {

    private Rule rule;

    public ProxyRule(Rule rule) {
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
