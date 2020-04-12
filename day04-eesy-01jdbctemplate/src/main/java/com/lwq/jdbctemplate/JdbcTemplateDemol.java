package com.lwq.jdbctemplate;

/**
 * @author lwq
 * @date 2020/4/8 -13:24
 */

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.DriverManager;

/**
 * jdbcTemplate的最基本的用法
 */
public class JdbcTemplateDemol {
    public static void main(String[] args) {
        //准备数据源：spring的内置数据源
        DriverManagerDataSource ds= new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/eesy?serverTimezone=GMT");
        ds.setUsername("root");
        ds.setPassword("9527");
        //1.创建jdbcTemplate对象
        JdbcTemplate jt = new JdbcTemplate();
        //给jt设置数据源
        jt.setDataSource(ds);
        //2.执行操作
        jt.execute("insert  into  account(name,money) values ('ccc',1000)");
    }

}
