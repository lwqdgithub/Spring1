package com.lwq.jdbctemplate;

/**
 * @author lwq
 * @date 2020/4/8 -13:24
 */
//BeanPropertyRowMapper       spring自带的很好用
import com.lwq.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * jdbcTemplate的CURD操作
 */
public class JdbcTemplateDemo2 {
    public static void main(String[] args) {

         //1.获取容器
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        //2.获取连接对象
        JdbcTemplate jt=ac.getBean("jdbcTemplate",JdbcTemplate.class);
        //3.执行操作
        //保存
//        jt.update("insert  into account(name,money)values (?,?)","eee",33333f);
        //更新
//        jt.update("update account set name=?,money=? where id=?","test",4567f,7);
        //删除
//        jt.update("delete from account where id=?","9");
        //查询所有
//        List<Account> accounts = jt.query("select * from account where money>?", new BeanPropertyRowMapper<Account>(Account.class), 1000f);
//        for (Account account : accounts) {
//            System.out.println(account);
//        }
        //查询一个
//        List<Account> accounts = jt.query("select * from account where id=?", new BeanPropertyRowMapper<Account>(Account.class), 20);
//        System.out.println(accounts.isEmpty()?"没有内容":accounts.get(0));
        //查询返回一行一列（使用聚合函数，但是不加group by字句）
        String s = jt.queryForObject("select count(*) from account where money>?", String.class, 1000f);
        System.out.println(s);

    }

}
