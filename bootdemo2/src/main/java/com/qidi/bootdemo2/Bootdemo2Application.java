package com.qidi.bootdemo2;

import com.qidi.bootdemo2.nio.httpsocket.HttpServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Bootdemo2Application {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(Bootdemo2Application.class, args);
        //启动http的server通讯
        int port = 8081;
        new HttpServer(port).start();
    }

}

