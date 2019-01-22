package lock.shared.redis;

import redis.clients.jedis.Jedis;

import java.util.Collections;

/**
 * 单机redis的不可重入锁的工具类
 * 使用Jedis
 *
 * @author qidi
 * @date 2019-01-22 20:43
 */
public class RedisLockTool {
    private static final String LOCK_SUCCESS = "OK";
    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIRE_TIME = "PX";
    /**
     * 解锁成功
     */
    private static final Long RELEASE_SUCCESS = 1L;


    /**
     * 尝试获取分布式锁
     * 底层是 SET KEY VALUE [EX seconds] [PX milliseconds] [NX|XX]
     * 参考：https://redis.io/topics/distlock
     * <p>
     * 原理：如果key存在就尝试锁，并且设置失效时间，防止锁定的程序宕机，造成死锁
     * 如果不存在就不锁
     * <p>
     * 使用错误参考： https://www.cnblogs.com/linjiqin/p/8003838.html
     *
     * @param jedis      Redis客户端
     * @param lockKey    锁
     * @param requestId  请求标识
     * @param expireTime 超期时间
     * @return 是否获取成功
     */
    public static boolean tryGetDistributedLock(Jedis jedis, String lockKey, String requestId, int expireTime) {

        String result = jedis.set(lockKey, requestId, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime);

        if (LOCK_SUCCESS.equals(result)) {
            return true;
        }
        return false;
    }

    /**
     * 释放分布式锁
     *
     * @param jedis     Redis客户端
     * @param lockKey   锁
     * @param requestId 请求标识
     * @return 是否释放成功
     */
    public static boolean releaseDistributedLock(Jedis jedis, String lockKey, String requestId) {
        //lua的脚本语言
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        Object result = jedis.eval(script, Collections.singletonList(lockKey), Collections.singletonList(requestId));

        if (RELEASE_SUCCESS.equals(result)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws InterruptedException {
        Jedis jedis = new Jedis("localhost", 6379);
        //true  能获取锁
        System.out.println(tryGetDistributedLock(jedis, "abc", "abc-id", 3000));
        //false 不能获取锁
        System.out.println(tryGetDistributedLock(jedis, "abc", "abc-id", 3000));
        //true 能解锁
        System.out.println(releaseDistributedLock(jedis, "abc", "abc-id"));
        Thread.sleep(3000);
        //false 锁已经被解锁，不能继续解锁
        System.out.println(releaseDistributedLock(jedis, "abc", "abc-id"));

    }

}
