package com.qidi.bootdemo2.config;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * 异步处理配置类
 *
 * @author: zhuqi
 * @date: 2018/12/4
 * @time: 17:43
 */
@Configuration
@EnableAsync
public class BootAsyncConfigurer implements AsyncConfigurer {

    @Value("${task.corePoolSize}")
    private int corePoolSize;

    @Value("${task.maxPoolSize}")
    private int maxPoolSize;

    @Value("${task.queueCapacity}")
    private int queueCapacity;

    @Value("${task.threadNamePrefix}")
    private String threadNamePrefix;

    @Override
    @Bean
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setThreadNamePrefix(threadNamePrefix);
        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }


}
