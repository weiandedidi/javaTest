package lock.shared.zookeeper.noreentrantlock;

import lock.shared.zookeeper.FakeLimitedResource;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessSemaphoreMutex;

import java.util.concurrent.TimeUnit;

/**
 * 线程被阻塞再第二个acquire上。直到超时报异常
 * 因为锁不可以重入
 *
 * @author qidi
 * @date 2019-01-18 17:13
 */
public class ExampleClientNotReentrantLock {
    /**
     * 不可重入锁 Shared Lock
     */
    private final InterProcessSemaphoreMutex lock;

    /**
     * 共享资源
     */
    private final FakeLimitedResource resource;
    /**
     * 客户端名称
     */
    private final String clientName;


    public ExampleClientNotReentrantLock(CuratorFramework client, String path, FakeLimitedResource resource, String clientName) {
        this.resource = resource;
        this.clientName = clientName;
        lock = new InterProcessSemaphoreMutex(client, path);
    }


    public void doWork(long time, TimeUnit unit) throws Exception {
        if (!lock.acquire(time, unit)) {
            throw new IllegalStateException(clientName + " could not acquire the lock");
        }
        System.out.println(clientName + " has the lock");
        if (!lock.acquire(time, unit)) {
            throw new IllegalStateException(clientName + " could not acquire the lock");
        }
        System.out.println(clientName + " has the lock again");
        try {
            //操作资源
            resource.use();
        } finally {
            System.out.println(clientName + " releasing the lock");
            lock.release(); //总是在Final块中释放锁。
            lock.release(); //调用两次acquire释放两次
        }
    }
}
