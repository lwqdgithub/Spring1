package com.lwq.service;

/**
 * @author lwq
 * @date 2020/4/9 -15:30
 */

import com.lwq.domain.Account;

/**
 * 账户的业务层实现接口
 */
public interface IAccountService {
    /**
     * 根据ID查询用户信息
     * @param accountId
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 转账
     * @param sourceName  转出账户名称
     * @param targetName     转入账户名称
     * @param money      转入金额
     */
    void transfer(String sourceName,String targetName,Float money);

}
