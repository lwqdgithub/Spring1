package com.lwq.test;

/**
 * @author lwq
 * @date 2020/4/3 -19:49
 */

import com.lwq.service.IAccountService;
import com.lwq.service.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 使用junit单元测试，测试我们的配置
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {
    @Autowired
    private IAccountService as;
    @Test
    public  void  testFindAll(){
        //3.执行方法
        List<Account> accounts=as.findAllAccount();
        for (Account account : accounts) {
            System.out.println(account);
        }

    }
    @Test
    public  void  testFindOne(){
        Account byId = as.findAccountById(1);
        System.out.println(byId);
    }
    @Test
    public  void  testSave(){
        Account account=new Account();
        account.setId(10);
        account.setMoney(12345f);
        account.setName("张三");
        as.saveAccount(account);
    }
    @Test
   //    改
    public  void  testUpdate(){
        Account account=new Account();
        account.setName("张三啊");
        account.setMoney(6547f);
        account.setId(4);
        as.updateAccount(account);


    }
    @Test
    public  void  testDelete(){
        as.deleteAccount(4);

    }
}
