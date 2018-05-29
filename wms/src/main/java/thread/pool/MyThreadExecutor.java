package thread.pool;

import java.util.concurrent.ExecutorService;

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

}
