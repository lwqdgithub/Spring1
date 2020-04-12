package com.lwq.ui;

/**
 * @author lwq
 * @date 2020/3/28 -19:41
 */

import com.lwq.factory.BeanFactory;
import com.lwq.service.IAccountService;
import com.lwq.service.impl.AccountServiceImpl;

/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {
    public static void main(String[] args) {
//        IAccountService service = new AccountServiceImpl();
        for(int i=0; i<5;i++){
            IAccountService service= (IAccountService) BeanFactory.getBean("accountService");
            System.out.println(service);
            service.saveAccount();
        }


    }
}
