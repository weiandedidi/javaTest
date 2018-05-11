package com.qidi.bean;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Created with IntelliJ IDEA.
 *
 * @author: qidima
 * @date: 2018/5/4
 * Time: 17:57
 */
public class PersonTest {

    @Test
    public void testLife() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
//        Person person = context.getBean(Person.class);
//        Animal animal = (Animal) context.getBean("animal");
        Animal animal =  context.getBean(Animal.class);
        animal.printName();
        context.close();
    }

    /**
     * 修改scope="prototype"
     */
    @Test
    public void testSingleton() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        Person person = context.getBean(Person.class);
        person.setName("我不是单例的小红");
        Animal animal =  context.getBean(Animal.class);
        System.out.println("============================================");
        animal.printName();
        context.close();
    }
}