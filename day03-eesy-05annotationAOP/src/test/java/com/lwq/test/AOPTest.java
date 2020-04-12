package com.lwq.test;

import com.lwq.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lwq
 * @date 2020/4/7 -14:06
 */
public class AOPTest {
    public static void main(String[] args) {
        //1.获取容器
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        //2.获取连接对象
        IAccountService as= (IAccountService) ac.getBean("accountService");
        //3.执行方法
        as.saveAccount();

    }
}
