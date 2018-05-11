package com.qidi.bean;


/**
 * 测试生命周期
 *
 * @author: qidima
 * @date: 2018/5/4
 * Time: 16:36
 */
public class Person {
    private String name;
    private int age;

    public Person() {
        System.out.println("这是一个无参构造函数");
//        throw new OutOfMemoryError();

    }

    public Person(String name) {
        this.name = name;
        System.out.println(name + "参数的构造函数");
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
        System.out.println("带有名字=" + name + "和年龄=" + age + "参数的构造函数");
    }

    public void init() {
        System.out.println("我是bean的初始化方法...");
    }

    public void destory() {
        System.out.println("我是bean的销毁方法...");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void xxx() {
        System.out.println("调用bean的方法");
    }
}
