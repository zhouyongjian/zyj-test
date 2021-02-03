package com.zyj.suns.proxy;

public class RuleServiceImpl implements RuleService {
    @Override
    public String retrunRule(String info) {
        System.out.println("into retrunRule");

        if (true){
            throw new RuntimeException("测试异常");
        }
        return "RuleServiceImpl = " + info;
    }
}
