package lock.reentrantlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁工具
 * <p>
 * ReentrantLock是Lock接口的一个实现类
 * 支持重入性，表示能够对共享资源能够重复加锁，即当前线程获取该锁再次获取不会被阻塞
 * <p>
 * 不加锁的结果
 * Thread-1 328492
 * Thread-0 328487
 * Thread-0 328494
 * Thread-1 328493
 * <p>
 * 加锁的结果
 * Thread-0 506873
 * Thread-0 506874
 * Thread-0 506875
 * Thread-1 506876
 * Thread-1 506877
 *
 * @author qidi
 * @date 2019-07-10 17:10
 */
public class ReentrantLockDemo extends Thread {

    private String name;

    public ReentrantLockDemo(String name) {
        this.name = name;
    }

    @Override
    public void run() {

        for (int j = 0; j < 10000000; j++) {
            SourceDemo.lock.lock();
            try {
                System.out.println(this.getName() + " " + SourceDemo.count);
                SourceDemo.count++;
            } finally {
                SourceDemo.lock.unlock();
            }

        }
    }

    /**
     * 主方法
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {

        ReentrantLockDemo test1 = new ReentrantLockDemo("thread1");
        ReentrantLockDemo test2 = new ReentrantLockDemo("thread2");

        test1.start();
        test2.start();
        test1.join();
        test2.join();
        System.out.println(SourceDemo.count);
    }

}
