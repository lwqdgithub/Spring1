package com.lwq.dao;

/**
 * @author lwq
 * @date 2020/4/2 -20:19
 */

import com.lwq.service.domain.Account;

import java.util.List;

/**
 * 账户的业务层实体类
 */
public interface IAccountDao  {
    /**
     * 查询所有
     * @return
     */
    List<Account> findAllAccount();


    /**
     * 查询一个
     * @return
     */
    Account findAccountById(Integer accountId);


    /**
     * 增
     */
    void saveAccount(Account account);

    /**
     *改
     */
    void updateAccount(Account account);

    /**
     *删
     */
    void deleteAccount(Integer accountId);
}
