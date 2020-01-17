package thread.semaphore;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * 信号箱，一个萝卜一个坑
 *
 * @author qidi
 * @date 2020-01-17 19:03
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        //建立流量池
        ExecutorService service = new ThreadPoolExecutor(10, 15, 0, TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>(1024));
//        ExecutorService service = Executors.newCachedThreadPool();

        //3个进入量
        final Semaphore semaphore = new Semaphore(3);
        System.out.println("初始化：当前有" + (3 - semaphore.availablePermits() + "个并发"));

        //创建10个任务，上面的缓存线程池就会创建10个对应的线程去执行
        for (int index = 0; index < 10; index++) {
            final int NO = index;  //记录第几个任务
            Runnable run = new Runnable() {
                @Override
                public void run() {
                    try {
                        //获取进入权限
                        semaphore.acquire();
                        System.out.println(Thread.currentThread().getName() + "获取许可" + "(" + NO + ")，" + "剩余：" + semaphore.availablePermits());
                        Thread.sleep(1000);
                        // 访问完后记得释放 ，否则在控制台只能打印3条记录，之后线程一直阻塞
                        semaphore.release();  //释放许可
                        System.out.println(Thread.currentThread().getName() + "释放许可" + "(" + NO + ")，" + "剩余：" + semaphore.availablePermits());

                    } catch (InterruptedException e) {
                        System.out.println("获取失败");
                        e.printStackTrace();
                    }
                }
            };
            service.submit(run);
        }
        //关闭
        service.shutdown();
    }
}
