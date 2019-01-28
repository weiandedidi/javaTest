package com.qidi.bootdemo.lock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * tryLock(long waitTime, long leaseTime, TimeUnit unit) 是不可重入的锁
 *
 * @author qidi
 * @date 2019-01-24 11:42
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LockServiceTest {

    @Autowired
    LockService lockService;

    @Test
    public void getLock() throws InterruptedException {
        int userId = 2;
        String key = "service";

        String lockName = userId + "_" + key;
        RLock rLock = lockService.getLock(lockName);
        //解锁
        System.out.println(rLock.forceUnlock());
        //上锁
        System.out.println(rLock.tryLock(3, 4, TimeUnit.MINUTES));

    }
}