package com.qidi.bootdemo2.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author qidi
 * @date 2019-09-18 17:59
 */
@Service
public class HelloImpl implements Hello {

    @Async
    @Override
    public void sayHi() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("我是前面的语句");
    }

    @Override
    public void hiAndCall() throws InterruptedException {
        sayHi();
        System.out.println("我是后面的语句");
    }


}
