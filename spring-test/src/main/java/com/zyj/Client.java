package com.zyj;

import com.zyj.config.MyConfigration;
import com.zyj.pojo.User;
import com.zyj.service.IAccountService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * ApplicationContext ，在容器构建的时候，，创建对象采取的策略是立即加在，也就是说，只要读取完配置文件就创建配置文件中的实例对象
 * BeanFactory  在构造容器时，创建对象采取的策略是延迟加在的发昂视，也就是说，什么时候根据id获取对象，什么时候创建对象
 *
 * 生命周期
 *  class ---> 通过factionBean和BeanDefinitionRegistrar 可以自定义BeanDefinition  ---> 完成所有BeanDefinition（除自定义外，还有注解及配置文件中的bean）
 *  ---> 完成BeanFactory的组建  ---> 执行BeanFactoryPostProcessor逻辑（可以修改BeanDefinition，但是不能新增）
 *  ---> 创建对象实例 ---> 填充属性 ---> 执行Aware子接口的方法 ---> 初始化  ---> AOP ---> 单例池（Map《BeanName, 对象（动态代理）》）
 */
public class Client {
    public static void main(String[] args) {
//        IAccountService accountService = new AccountServiceImpl();
//        System.out.println(accountService.getById(1));
//
//        ApplicationContext ac = new ClassPathXmlApplicationContext("spring/beans.xml");
        AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext(MyConfigration.class);
        IAccountService accountService1 = acac.getBean("accountService", IAccountService.class);
        System.out.println(accountService1.getById(3));
        System.out.println(accountService1.getUser(3));



//


    }
}
