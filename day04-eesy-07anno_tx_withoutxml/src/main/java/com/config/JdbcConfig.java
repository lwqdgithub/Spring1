package com.config;

/**
 * @author lwq
 * @date 2020/4/9 -20:03
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.DriverManager;

/**
 * 和连接数据库相关的配置类
 */

public class JdbcConfig {
    @Value("${jdbc.driver}")
    private  String driver;
    @Value("${jdbc.url}")
    private  String  url;
    @Value("${jdbc.username}")
    private  String username;
    @Value("${jdbc.password}")
    private  String password;
    /**
     * 创建jdbcTemplate对象
     * @param dataSource
     * @return
     */
    @Bean(name = "jdbcTemplate")
    public JdbcTemplate createJdbcTemplate(DataSource  dataSource){
        return  new JdbcTemplate(dataSource);
    }

    /**
     * 创建一个数据源对象
     * @return
     */
    @Bean(name ="dataSource")
    public DataSource createDataSource(){
        DriverManagerDataSource ds=new DriverManagerDataSource();
        ds.setDriverClassName(driver);
        ds.setUrl(url);
        ds.setPassword(password);
        ds.setUsername(username);
        return  ds;
    }
}
