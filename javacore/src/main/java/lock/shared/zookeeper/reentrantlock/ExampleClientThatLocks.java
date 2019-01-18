package lock.shared.zookeeper.reentrantlock;

import lock.shared.zookeeper.FakeLimitedResource;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.*;

import java.util.concurrent.TimeUnit;

/**
 * acquire()获取锁时，
 * release()进行释放
 * <p>
 * <p>
 * 如果该线程多次调用 了acquire()获取锁，则如果只调用 一次release()该锁仍然会被该线程持有。
 * 原因：
 * 利用zookeeper进行分布式锁的本质是通过创建子节点的方式，如果释放一次，暂存的节点还在，如果服务停掉，
 * zookeeper的节点超过指定时间会自己消失
 *
 * @author qidi
 * @date 2019-01-18 15:14
 */
public class ExampleClientThatLocks {
    /**
     * 可重入锁 Shared Reentrant Lock
     * http://curator.apache.org/curator-recipes/shared-reentrant-lock.html
     */
    private final InterProcessMutex lock;
    /**
     * 不可重入锁 Shared Lock
     * http://curator.apache.org/curator-recipes/shared-lock.html
     */
//    private final InterProcessSemaphoreMutex lock;
    /**
     * 可重入读写锁 Shared Reentrant Read Write Lock
     * http://curator.apache.org/curator-recipes/shared-reentrant-read-write-lock.html
     */
//    private final InterProcessReadWriteLock lock;
    /**
     * 共享信号量 Shared Semaphore
     */
//    private final InterProcessSemaphoreV2 lock;
    /**
     * 多共享锁 Multi Shared Lock
     */
//    private final InterProcessMultiLock lock;


    /**
     * 共享资源
     */
    private final FakeLimitedResource resource;
    /**
     * 客户端名称
     */
    private final String clientName;

    public ExampleClientThatLocks(CuratorFramework client, String lockPath, FakeLimitedResource resource, String clientName) {
        this.resource = resource;
        this.clientName = clientName;
        lock = new InterProcessMutex(client, lockPath);
    }

    public void doWork(long time, TimeUnit unit) throws Exception {
        if (!lock.acquire(time, unit)) {
            throw new IllegalStateException(clientName + " could not acquire the lock");
        }
        try {
            System.out.println(clientName + " has the lock");
            //重复获取锁
//            lock.acquire(time, unit);
            resource.use();
            Thread.sleep(1000);
        } finally {
            System.out.println(clientName + " releasing the lock");
            lock.release(); // 总是在Final块中释放锁。

//            lock.release();
        }
    }
}
