package com.zyj.myspring.service;


import com.zyj.myspring.anno.Autowired;
import com.zyj.myspring.anno.Component;
import com.zyj.myspring.definition.BeanNameAware;
import com.zyj.myspring.definition.InitializingBean;

@Component(value = "userService")
public class UserService implements BeanNameAware, InitializingBean {


    @Autowired
    private  User user;

    private String beanName;
    private String xxx;

    @Override
    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public void test(){
        System.out.println("user = " + user);
        System.out.println("beanName = " + beanName);
        System.out.println("xxx = " + xxx);
    }


    @Override
    public void afterPropertiesSet() {
        this.xxx = "xxx";
    }
}
