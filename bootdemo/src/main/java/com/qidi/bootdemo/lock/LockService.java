package com.qidi.bootdemo.lock;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 锁的工具类
 *
 * @author qidi
 * @date 2019-01-24 11:31
 */
@Service
public class LockService {

    @Autowired
    RedissonClient redissonClient;

    public RLock getLock(String lockName) {
        return redissonClient.getLock(lockName);
    }


}
