package com.lwq.test;

/**
 * @author lwq
 * @date 2020/4/3 -19:49
 */

import com.lwq.service.IAccountService;
import com.lwq.service.domain.Account;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 使用junit单元测试，测试我们的配置
 */
public class AccountServiceTest {
    @Test
    public  void  testFindAll(){
        //1.获取容器
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
        IAccountService as=ac.getBean("accountService",IAccountService.class);
        //3.执行方法
        List<Account> accounts=as.findAllAccount();
        for (Account account : accounts) {
            System.out.println(account);
        }

    }
    @Test
    public  void  testFindOne(){
        //1.获取容器
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
        IAccountService as=ac.getBean("accountService",IAccountService.class);
        Account byId = as.findAccountById(1);
        System.out.println(byId);
    }
    @Test
    public  void  testSave(){
        Account account=new Account();
        account.setId(10);
        account.setMoney(12345f);
        account.setName("张三");
        //1.获取容器
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
        IAccountService as=ac.getBean("accountService",IAccountService.class);
        as.saveAccount(account);
    }
    @Test
   //    改
    public  void  testUpdate(){
        Account account=new Account();
        account.setName("张三啊");
        account.setMoney(6547f);
        account.setId(4);
        //1.获取容器
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
        IAccountService as=ac.getBean("accountService",IAccountService.class);
        as.updateAccount(account);


    }
    @Test
    public  void  testDelete(){
        //1.获取容器
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
        IAccountService as=ac.getBean("accountService",IAccountService.class);
        as.deleteAccount(4);

    }
}
