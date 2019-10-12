package com.indi.biz;

import com.indi.domain.Account;

public interface AccountBiz {

    Account findAccountById(Long id);

    Account findAccountByName(String name);

    void transfer(String source, String target, Integer money);

}
