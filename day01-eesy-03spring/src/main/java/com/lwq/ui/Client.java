package com.lwq.ui;

/**
 * @author lwq
 * @date 2020/3/28 -19:41
 */

import com.lwq.dao.IAccountDao;
import com.lwq.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {
    /**
     * 获取spring的IOC核心容器，并根据id获取对象
     *
     *  ApplicationContext的三大常用实现类：
     *       ClassPathXmlApplicationContext: 它可以加载类路径下的配置文件，要求配置文件必须在类路径下。不在的话，加载不了。
     *       FileSystemXmlApplicationContext：它可以加载磁盘任意下的配置文件（必须有访问权限）
     *
     *       AnnotationConfigApplicationContext：它是用于读取注解创建容器的。
     *
     * 核心容器的两个接口引发的问题：
     *   ApplicationContext:   单例对象适用
     *        他在构建容器的时候，创建对象采取的策略是采用立即加载的方式，也就是说，只要一读完配置文件马上就是创建配置文件中的配置对象
     *   BeanFactory:   多例对象适用
     *       它在构造核心容器的时候，创建对象采取的策略是采用延迟加载的方式。也就是说什么时候根据id获取对象了，什么时候才真正的创建对象。
     *
     * @param args
     */
    public static void main(String[] args) {
        //1.获取核心容器对象
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取bean对象
        IAccountService as = (IAccountService) ac.getBean("accountService");
        IAccountDao adao=ac.getBean("accountDao",IAccountDao.class);
        System.out.println(as);
        System.out.println(adao);

        as.saveAccount();


    }
}
