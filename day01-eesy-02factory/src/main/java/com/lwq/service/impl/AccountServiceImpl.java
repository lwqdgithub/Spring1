package com.lwq.service.impl;

import com.lwq.dao.impl.AccountDaoImpl;
import com.lwq.factory.BeanFactory;
import com.lwq.service.IAccountService;
import com.lwq.dao.IAccountDao;

/**
 * @author lwq
 * @date 2020/3/28 -19:34
 */

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {
//    private IAccountDao accountDao=new AccountDaoImpl();
private IAccountDao accountDao= (IAccountDao) BeanFactory.getBean("accountDao");
//private  int i=1;
    public void saveAccount() {
        int i=1;
        accountDao.saveAccount();
        System.out.println(i);
            i++;
    }
}
