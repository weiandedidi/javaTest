package thread;

import java.util.concurrent.*;

/**
 * @author qidi
 * @date 2020-05-21 17:42
 */
public class ThreadInterruptDemo {
    public static long start;
    public static long end;

    public static void main(String[] args) throws Exception {
        ExecutorService es = Executors.newSingleThreadExecutor();
        Future<?> task = es.submit(new TraceRunnable());
        start = System.currentTimeMillis();

        try {
            //限定时间获取结果
            task.get(5, TimeUnit.SECONDS);
        } catch (TimeoutException e) {
            //超时触发线程中止
            end = System.currentTimeMillis();
            System.out.println("thread over time");
        } catch (ExecutionException e) {
            throw e;
        } finally {
            boolean mayInterruptIfRunning = true;
            task.cancel(mayInterruptIfRunning);
        }
    }

    private static class TraceRunnable implements Runnable {

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    //进行各种计算
                    System.out.println("count");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("interrupt");
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("thread stop");

            System.out.println(end - start);
        }
    }
}
