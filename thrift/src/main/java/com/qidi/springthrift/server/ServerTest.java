package com.qidi.springthrift.server;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: qidima
 * @date: 2018/5/3
 * Time: 11:41
 */
public class ServerTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext_server.xml");
        UserServiceServer userServiceServer = (UserServiceServer) context.getBean(UserServiceServer.class);
        userServiceServer.start();

    }
}
