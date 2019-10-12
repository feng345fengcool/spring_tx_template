package com.indi.test;

import com.indi.biz.AccountBiz;
import com.indi.config.SpringConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig.class})
public class AccountBizTest {

    @Autowired
    private AccountBiz accountBiz;

    @Test
    public void testTransfer() {
        accountBiz.transfer("zhangsan", "lisi", 50);
    }

}
