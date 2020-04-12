package com.lwq.jdbctemplate;

import com.lwq.domain.Account;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author lwq
 * @date 2020/4/8 -19:09
 */
class  AccountRowMapper implements RowMapper<Account> {
    /**
     * 把结果集中的数据封装到Account中，然后spring把每个Account加到集合中
     * @param resultSet
     * @param i
     * @return
     * @throws SQLException
     */
    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        Account account = new Account();
        account.setId(resultSet.getInt("id"));
        account.setMoney(resultSet.getFloat("money"));
        account.setName(resultSet.getString("name"));
        return account;
    }
}
