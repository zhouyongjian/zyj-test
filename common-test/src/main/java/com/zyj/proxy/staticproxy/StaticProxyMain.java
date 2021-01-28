package com.zyj.proxy.staticproxy;

public class StaticProxyMain {
    public static void main(String[] args) {
        Rule rule = new RuleInfo();
        ProxyRule proxyRule = new ProxyRule(rule);
        System.out.println(proxyRule.retrunRule("hhh"));

    }
}
