package com.zyj.refistrar;

import com.zyj.dao.user.impl.UserDaoImpl;
import com.zyj.postprocessor.MyFactoryBean;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;


/**
 * 此类可以通过registerBeanDefinitions 方法registry 多个BeanDefinition
 */
public class MyBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition();
        AbstractBeanDefinition beanDefinition = builder.getBeanDefinition();
        beanDefinition.setBeanClass(MyFactoryBean.class);
        beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(UserDaoImpl.class);
        registry.registerBeanDefinition("userDao", beanDefinition);


    }
}
