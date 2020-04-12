package com.lwq.service;

/**
 * @author lwq
 * @date 2020/4/7 -13:13
 */

/**
 * 账户的业务层接口
 */
public interface IAccountService {
    /**
     * 模拟保存用户
     */
    void saveAccount();

    /**
     * 模拟更新操作
     * @param i
     */
    void updateAccount(int i);

    /**
     * 删除操作
     * @return
     */
    int deleteAccount();

}
