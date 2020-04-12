package com.lwq.service.impl;

/**
 * @author lwq
 * @date 2020/4/2 -20:16
 */

import com.lwq.dao.IAccountDao;
import com.lwq.domain.Account;
import com.lwq.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import sun.instrument.TransformerManager;

import java.util.List;

/**
 * 账户的业务层实现类
 * <p>
 * 事务控制应该都在业务层的
 */
@Service("accountService")
@Transactional(propagation = Propagation.SUPPORTS ,readOnly = true)  //只读型事务的配置
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountDao accountDao;


    public Account findAccountById(Integer accountId) {

        return accountDao.findAccountById(accountId);
    }


    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    public void transfer(String sourceName, String targetName, Float money) {
        System.out.println(".....");
        //2.1.根据名称查询转出账户
        Account source = accountDao.findAccountByName(sourceName);
        //2.2.根据名称查询转入账户
        Account target = accountDao.findAccountByName(targetName);
        //2.3.转出账户减钱
        source.setMoney(source.getMoney() - money);
        //2.4.转入账户加钱
        target.setMoney(target.getMoney() + money);
        //2.5.更新转出账户
        accountDao.updateAccount(source);

//       int i = 1 / 0;
        //2.6.更新转入账户
        accountDao.updateAccount(target);

    }
}