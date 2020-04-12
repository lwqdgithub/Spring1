package com.lwq.service.impl;

/**
 * @author lwq
 * @date 2020/4/2 -20:16
 */

import com.lwq.dao.IAccountDao;
import com.lwq.service.IAccountService;
import com.lwq.service.domain.Account;
import com.lwq.utils.TransactionManager;

import java.util.List;

/**
 * 账户的业务层实现类
 * <p>
 * 事务控制应该都在业务层的
 */
public class AccountServiceImpl_OLD implements IAccountService {
    private IAccountDao accountDao;
    private TransactionManager transactionManager;

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public List<Account> findAllAccount() {
        try {
            //1.开启事务
            transactionManager.beginTransaction();
            //2.执行操作事务
            List<Account> accounts = accountDao.findAllAccount();
            //3.提交事务
            transactionManager.commit();
            //4.返回结果
            return accounts;
        } catch (Exception e) {
            //5.回滚操作
            transactionManager.rollback();
            throw new RuntimeException(e);
        } finally {
            //6.释放连接
            transactionManager.release();
        }
    }

    public Account findAccountById(Integer accountId) {
        try {
            //1.开启事务
            transactionManager.beginTransaction();
            //2.执行操作事务
            Account account = accountDao.findAccountById(accountId);
            //3.提交事务
            transactionManager.commit();
            //4.返回结果
            return account;

        } catch (Exception e) {
            //5.回滚操作
            transactionManager.rollback();
            throw new RuntimeException(e);
        } finally {
            //6.释放连接
            transactionManager.release();
        }

    }

    public void saveAccount(Account account) {
        try {
            //1.开启事务
            transactionManager.beginTransaction();
            //2.执行操作事务
            accountDao.saveAccount(account);
            //3.提交事务
            transactionManager.commit();
        } catch (Exception e) {
            //5.回滚操作
            transactionManager.rollback();
        } finally {
            //6.释放连接
            transactionManager.release();
        }

    }

    public void updateAccount(Account account) {
        try {
            //1.开启事务
            transactionManager.beginTransaction();
            //2.执行操作事务
            accountDao.updateAccount(account);
            //3.提交事务
            transactionManager.commit();
        } catch (Exception e) {
            //5.回滚操作
            transactionManager.rollback();
        } finally {
            //6.释放连接
            transactionManager.release();
        }
        accountDao.updateAccount(account);
    }

    public void deleteAccount(Integer accountId) {
        try {
            //1.开启事务
            transactionManager.beginTransaction();
            //2.执行操作事务
            accountDao.deleteAccount(accountId);
            //3.提交事务
            transactionManager.commit();
        } catch (Exception e) {
            //5.回滚操作
            transactionManager.rollback();
        } finally {
            //6.释放连接
            transactionManager.release();
        }
        accountDao.deleteAccount(accountId);
    }

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void transfer(String sourceName, String targetName, Float money) {
        try {
            //1.开启事务
            transactionManager.beginTransaction();
            //2.执行操作事务
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
            //2.6.更新转入账户
            int i=1/0;
            accountDao.updateAccount(target);
            //3.提交事务
            transactionManager.commit();
        } catch (Exception e) {
            //4.回滚操作
            transactionManager.rollback();
            e.printStackTrace();
        } finally {
            //5.释放连接
            transactionManager.release();
        }
     }
}
