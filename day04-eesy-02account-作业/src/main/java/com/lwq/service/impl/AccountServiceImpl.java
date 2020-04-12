package com.lwq.service.impl;

/**
 * @author lwq
 * @date 2020/4/2 -20:16
 */

import com.lwq.dao.IAccountDao;
import com.lwq.service.IAccountService;
import com.lwq.service.domain.Account;
import com.lwq.utils.TransactionManager;
import org.springframework.stereotype.Service;
import sun.instrument.TransformerManager;

import java.util.List;

/**
 * 账户的业务层实现类
 * <p>
 * 事务控制应该都在业务层的
 */
public class AccountServiceImpl implements IAccountService {
    private IAccountDao accountDao;

    public List<Account> findAllAccount() {

        return accountDao.findAllAccount();
    }

    public Account findAccountById(Integer accountId) {

        return accountDao.findAccountById(accountId);
    }

    public void saveAccount(Account account) {

        accountDao.saveAccount(account);
    }

    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    public void deleteAccount(Integer accountId) {
        accountDao.deleteAccount(accountId);
    }

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
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