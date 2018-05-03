package com.qidi.springthrift.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: qidima
 * @date: 2018/5/3
 * Time: 11:57
 */
public class ClientTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext_client.xml");
        UserServiceClient userServiceClient = (UserServiceClient) context.getBean(UserServiceClient.class);
        userServiceClient.invoke();
    }
}
