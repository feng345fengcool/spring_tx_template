package com.indi.biz.impl;

import com.indi.biz.AccountBiz;
import com.indi.dao.AccountDao;
import com.indi.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AccountBizImpl implements AccountBiz {

    @Autowired
    private AccountDao accountDao;

    @Override
    public Account findAccountById(Long id) {
        return accountDao.findAccountById(id);
    }

    @Override
    public Account findAccountByName(String name) {
        return accountDao.findAccountByName(name);
    }

    @Override
    @Transactional
    public void transfer(String sourceName, String targetName, Integer money) {
        Account source = accountDao.findAccountByName(sourceName);
        Account target = accountDao.findAccountByName(targetName);
        source.setBalance(source.getBalance() - money);
        target.setBalance(target.getBalance() + money);
        accountDao.updateAccount(source);

//        int i = 1/0;

        accountDao.updateAccount(target);
    }
}
