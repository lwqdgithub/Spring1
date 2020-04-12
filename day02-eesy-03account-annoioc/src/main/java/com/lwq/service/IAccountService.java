package com.lwq.service;

/**
 * @author lwq
 * @date 2020/4/2 -20:07
 */

import com.lwq.service.domain.Account;

import java.util.List;

/**
 * 账户的业务层接口
 */
public interface IAccountService {

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
