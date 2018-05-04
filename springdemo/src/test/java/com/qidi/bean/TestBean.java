package com.qidi.bean;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: qidima
 * @date: 2018/5/4
 * Time: 16:51
 */
public class TestBean {

    @Test
    public void testCreateBean(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        Person person = context.getBean(Person.class);
        person.xxx();
        System.out.println(person.getName());
        System.out.println(person.getAge());
        context.close();

    }

}
