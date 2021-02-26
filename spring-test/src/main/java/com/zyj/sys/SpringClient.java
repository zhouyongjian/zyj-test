package com.zyj.sys;

import com.zyj.suns.life.Product;
import oracle.jvm.hotspot.jfr.Producer;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

public class SpringClient {
    public static void main(String[] args) {
        Resource resource = new ClassPathResource("spring/beans.xml");

        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        BeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
        beanDefinitionReader.loadBeanDefinitions(resource);
        Product product = defaultListableBeanFactory.getBean("product", Product.class);
        System.out.println(product.getName());
    }
}
