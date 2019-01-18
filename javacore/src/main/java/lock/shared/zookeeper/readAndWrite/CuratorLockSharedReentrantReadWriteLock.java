package lock.shared.zookeeper.readAndWrite;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessReadWriteLock;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * 读写锁
 * 创建InterProcessReadWriteLock
 * 通过readLock()和writeLock()分别获取锁类型
 * 通过acquire()获取锁
 *
 * @author qidi
 * @date 2019-01-18 17:32
 */
public class CuratorLockSharedReentrantReadWriteLock {

    private static final int SECOND = 1000;
    private static final String PATH = "/examples/locks";
    private static final String CONNECTION_STRING = "192.168.58.42:2181";

    public static void main(String[] args) {
        CuratorFramework client = CuratorFrameworkFactory.newClient(CONNECTION_STRING, new ExponentialBackoffRetry(1000, 3, Integer.MAX_VALUE));
        client.start();
        // todo 在此可添加ConnectionStateListener监听
        System.out.println("Server connected...");
        final InterProcessReadWriteLock lock = new InterProcessReadWriteLock(client, PATH);
        final CountDownLatch down = new CountDownLatch(1);
        for (int i = 0; i < 30; i++) {
            final int index = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        down.await();
                        if (index % 2 == 0) {
                            lock.readLock().acquire();
                            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss|SSS");
                            String orderNo = sdf.format(new Date());
                            System.out.println("[READ]生成的订单号是:" + orderNo);
                        } else {
                            lock.writeLock().acquire();
                            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss|SSS");
                            String orderNo = sdf.format(new Date());
                            System.out.println("[WRITE]生成的订单号是:" + orderNo);
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            if (index % 2 == 0) {
                                lock.readLock().release();
                            } else {
                                lock.writeLock().release();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
        // 保证所有线程内部逻辑执行时间一致
        down.countDown();
        try {
            Thread.sleep(10 * SECOND);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (client != null) {
            client.close();
        }
        System.out.println("Server closed...");
    }

}
