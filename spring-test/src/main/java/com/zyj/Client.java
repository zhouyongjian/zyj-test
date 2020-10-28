package com.zyj;

import com.zyj.service.IAccountService;
import com.zyj.service.impl.AccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ApplicationContext ，在荣建构建的时候，，创建对象采取的策略是立即加在，也就是说，只要读取完配置文件就创建配置文件中的实例对象
 * BeanFactory  在构早容器时，创建对象采取的策略是延迟加在的发昂视，也就是说，什么时候根据id获取对象，什么时候创建对象
 */
public class Client {
    public static void main(String[] args) {
//        IAccountService accountService = new AccountServiceImpl();
//        System.out.println(accountService.getById(1));
//
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring/beans.xml");
        IAccountService accountService1 = ac.getBean("accountService", IAccountService.class);
        System.out.println(accountService1.getById(3));



//


    }
}
