package com.zyj.suns.life;


import org.springframework.beans.factory.InitializingBean;

public class Product implements InitializingBean {
    public Product() {
        System.out.printf("Product.Product");
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("Product.afterPropertiesSet");
    }

    public void myInit(){
        System.out.println("Product.myInit");
    }
}
