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

    /**
     * 根据名称查询账户
     * @param accountName
     * @return  如果有唯一的一个结果就返回，如果没有就返回null
     *           如果结果集超过一个就抛异常
     */
    Account findAccountByName(String accountName);
}
