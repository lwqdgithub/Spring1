package com.lwq.dao.impl;

import com.lwq.dao.IAccountDao;
import com.lwq.domain.Account;
import jdk.nashorn.internal.ir.IfNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lwq
 * @date 2020/4/8 -18:50
 */

/**
 * 账户的持久层实体类
 */
@Repository("accountDao")
public class AccountDaoImpl  implements IAccountDao {
    @Autowired
      private  JdbcTemplate jdbcTemplate;

    public Account findAccountById(Integer accountId) {
        List<Account> accounts =jdbcTemplate.query("select * from account where id=?", new BeanPropertyRowMapper<Account>(Account.class), accountId);
        return  accounts.isEmpty()?null:accounts.get(0);
    }


    public Account findAccountByName(String accountName) {
        List<Account> accounts = jdbcTemplate.query("select * from account where name=?", new BeanPropertyRowMapper<Account>(Account.class), accountName);
        if(accounts.isEmpty()){
            return null;
        }
        if (accounts.size()>1){
            throw new RuntimeException("结果集不统一");
        }

        return  accounts.get(0);
    }

    public void updateAccount(Account account) {
     jdbcTemplate.update("update  account set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());

    }


    }

