package com.lwq.dao.impl;

import com.lwq.dao.IAccountDao;
import com.lwq.domain.Account;
import jdk.nashorn.internal.ir.IfNode;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

/**
 * @author lwq
 * @date 2020/4/8 -18:50
 */

/**
 * 账户的持久层实体类
 */
public class AccountDaoImpl extends JdbcDaoSupport implements IAccountDao {


    public Account findAccountById(Integer accountId) {
        List<Account> accounts =  super.getJdbcTemplate().query("select * from account where id=?", new BeanPropertyRowMapper<Account>(Account.class), accountId);
        return  accounts.isEmpty()?null:accounts.get(0);
    }


    public Account findAccountByName(String accountName) {
        List<Account> accounts = super.getJdbcTemplate().query("select * from account where name=?", new BeanPropertyRowMapper<Account>(Account.class), accountName);
        if(accounts.isEmpty()){
            return null;
        }
        if (accounts.size()>1){
            throw new RuntimeException("结果集不统一");
        }

        return  accounts.get(0);
    }

    public void updateAccount(Account account) {
        super.getJdbcTemplate().update("update  account set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());

    }


    }

