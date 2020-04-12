package com.lwq.service.impl;

/**
 * @author lwq
 * @date 2020/4/2 -20:16
 */

import com.lwq.dao.IAccountDao;
import com.lwq.service.IAccountService;
import com.lwq.service.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 账户的业务层实现类
 */
@Service("accountService")
public class AccountServiceImpl implements IAccountService {
    @Autowired
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


}
