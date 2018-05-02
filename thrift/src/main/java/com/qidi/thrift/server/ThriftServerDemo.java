package com.qidi.thrift.server;

import com.qidi.thrift.service.HelloServiceImpl;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TBinaryProtocol.Factory;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;
import org.apache.thrift.transport.TTransportFactory;

/**
 * 简单的单线程服务模型，一般用于测试。
 * 编写服务端server代码：ThriftServer.java
 *
 * @author: qidima
 * @date: 2018/5/2
 * Time: 16:15
 */
public class ThriftServerDemo {
    public void startServer() {
        try {
            System.out.println("Starting Thrift Server......");

            // *) 传输层(Transport), 设置监听端口为8191
            TServerSocket serverTransport = new TServerSocket(8191);

            // *) 协议层 使用二进制传输
            TTransportFactory transportFactory = new TFramedTransport.Factory();
            Factory factory = new TBinaryProtocol.Factory();
            // *) 处理层(Processor)
            TProcessor processor = new HelloService.Processor<HelloService.Iface>(new HelloServiceImpl());
            TServer.Args tArgs = new TServer.Args(serverTransport);
            tArgs.protocolFactory(factory);
            tArgs.transportFactory(transportFactory);
            tArgs.processor(processor);

            // *) 服务层(Server)
            // 简单的单线程服务模型，一般用于测试
            TServer server = new TSimpleServer(tArgs);
            // *) 启动监听服务
            server.serve();

        } catch (TTransportException e) {
            System.out.println("Starting Thrift Server......Error!!!");
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        ThriftServerDemo server = new ThriftServerDemo();
        server.startServer();
    }


}
