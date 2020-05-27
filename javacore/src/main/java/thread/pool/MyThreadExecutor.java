package thread.pool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ①newSingleThreadExecutor
 * 单个线程的线程池，即线程池中每次只有一个线程工作，单线程串行执行任务
 * <p>
 * ②newFixedThreadExecutor(n)
 * 固定数量的线程池，没提交一个任务就是一个线程，直到达到线程池的最大数量，然后后面进入等待队列直到前面的任务完成才继续执行
 * <p>
 * ③newCacheThreadExecutor（推荐使用）
 * 可缓存线程池，当线程池大小超过了处理任务所需的线程，那么就会回收部分空闲（一般是60秒无执行）的线程，当有任务来时，又智能的添加新线程来执行。
 * <p>
 * ④newScheduleThreadExecutor
 * 大小无限制的线程池，支持定时和周期性的执行线程
 */
public class MyThreadExecutor {
    private static final ExecutorService executorService = new ThreadPoolExecutor(
            5,
            10,
            30,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(1000),
            new ThreadFactoryBuilder().setNameFormat("ActionThreadPool-pool-%d").build(),
            new ThreadPoolExecutor.DiscardOldestPolicy()) {

        private ThreadLocal<Long> timeThreadLocal = new ThreadLocal();
    };

    static ExecutorService getExecutor() {
        return executorService;
    }

    public static void main(String[] args) {
        int i = 0;
        do {
            i++;
            createThread();
            if (i == 3) {
                Thread.currentThread().interrupt();
            }
        } while (i < 5);

    }

    public static void createThread() {
        MyThreadExecutor.getExecutor().submit(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName());
                }
            }
        });
    }

}
