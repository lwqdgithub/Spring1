package com.lwq.dao.impl;

/**
 * @author lwq
 * @date 2020/4/8 -19:23
 */

import org.springframework.jdbc.core.JdbcTemplate;
import sun.font.CreatedFontTracker;

import javax.sql.DataSource;

/**
 * 此类用于抽取dao中的重复代码
 *
public class JdbcDaoSupport {
    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        if(jdbcTemplate==null){
            jdbcTemplate= createJdbcTemplate(dataSource);
        }
    }

    private JdbcTemplate createJdbcTemplate(DataSource dataSource) {
         return new JdbcTemplate(dataSource);
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
}
*/