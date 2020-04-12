package com.lwq.jdbctemplate;

/**
 * @author lwq
 * @date 2020/4/8 -13:24
 */
//BeanPropertyRowMapper       spring自带的很好用

import com.lwq.dao.IAccountDao;
import com.lwq.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * jdbcTemplate的CURD操作
 */
public class JdbcTemplateDemo4 {
    public static void main(String[] args) {

        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取连接对象
        IAccountDao dao = ac.getBean("accountDao", IAccountDao.class);
        //根据ID查询用户
        Account account = dao.findAccountById(1);
        System.out.println(account);
        //更新账户
        account.setMoney(150000f);
        dao.updateAccount(account);

    }
}