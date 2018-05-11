package com.qidi.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: qidima
 * @date: 2018/5/9
 * Time: 16:45
 */
@Component("animal")
public class Animal {
    @Autowired
    private Person person;

    public void printName() {
        System.out.println(person.getName());
    }

    /**
     * spring bean 的初始化方法，有三种实现
     * 1. 注解 @PostConstruct 方法上加
     * 2. xml 定义 <bean id="person" class="com.qidi.bean.Person" init-method="init" destroy-method="destory">
     * 3. 实现InitializingBean接口中的afterPropertiesSet()
     */
    @PostConstruct
    public void init() {
        System.out.println("我是" + Animal.class.getName() + "的初始化方法");
    }
    /**
     * spring bean 的销毁方法，有三种实现
     * 1. 注解 @PreDestroy 方法上加
     * 2. xml 定义 <bean id="person" class="com.qidi.bean.Person" init-method="init" destroy-method="destory">
     * 3. 实现InitializingBean接口中的afterPropertiesSet()
     */
    @PreDestroy
    public void destory() {
        System.out.println("我是" + Animal.class.getName() + "的销毁方法方法");
    }



}
