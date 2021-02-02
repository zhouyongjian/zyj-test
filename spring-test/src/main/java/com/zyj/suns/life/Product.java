package com.zyj.suns.life;


import lombok.ToString;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PreDestroy;

@ToString
public class Product implements InitializingBean, DisposableBean {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("Product.setName");
        this.name = name;
    }

    public Product() {
        System.out.println("Product.Product");
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("Product.afterPropertiesSet");
    }

    public void myInit(){
        System.out.println("Product.myInit");
    }
    public void myDestroy() throws Exception{
        System.out.println("Product.myDestroy");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Product.destroy");
    }
}
