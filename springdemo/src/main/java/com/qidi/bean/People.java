package com.qidi.bean;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: qidima
 * @date: 2018/5/14
 * Time: 17:23
 */
public class People {
    private String name;
    private int age;

    public People() {

    }

    public People(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("构造方法调用name,age...");
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
