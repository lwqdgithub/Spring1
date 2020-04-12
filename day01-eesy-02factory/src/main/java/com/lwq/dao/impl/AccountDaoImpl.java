package com.lwq.dao.impl;

import com.lwq.dao.IAccountDao;

/**
 * @author lwq
 * @date 2020/3/28 -19:38
 */

/**
 * 账户的持久层实现类
 */
public class AccountDaoImpl implements IAccountDao {
    public void saveAccount() {
        System.out.println("保存了账户");
    }
}
