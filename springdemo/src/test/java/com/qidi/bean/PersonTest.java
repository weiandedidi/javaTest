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
        Person person = context.getBean(Person.class);
        person.xxx();
        context.close();
    }
}