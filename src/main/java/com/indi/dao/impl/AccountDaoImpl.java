package com.indi.dao.impl;

import com.indi.dao.AccountDao;
import com.indi.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private JdbcTemplate jt;

    @Override
    public Account findAccountById(Long id) {
        try {
            String sql = "select * from account where id = ?";
            List<Account> accounts
                    = jt.query(sql, new BeanPropertyRowMapper<>(Account.class), id);
            if (accounts.isEmpty()) return null;
            return accounts.get(0);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account findAccountByName(String name) {
        try {
            String sql = "select * from account where name = ?";
            List<Account> accounts
                    = jt.query(sql, new BeanPropertyRowMapper<>(Account.class), name);
            if (accounts.isEmpty()) return null;
            return accounts.get(0);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateAccount(Account account) {
        try {
            String sql = "update account set name = ?, balance = ? where id = ?";
            jt.update(sql, account.getName(), account.getBalance(), account.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
