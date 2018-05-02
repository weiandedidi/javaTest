package com.qidi.thrift.server;

import com.qidi.thrift.service.HelloServiceImpl;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: qidima
 * @date: 2018/5/2
 * Time: 15:01
 */
public class ServerDemo {
    public static void main(String[] args) throws TTransportException {
        Logger logger = LoggerFactory.getLogger(ServerDemo.class);
        int port= 9000 ;
        // *) 传输层(Transport), 设置监听端口为9000
        TServerSocket serverTransport = new TServerSocket(port);

        // *) 协议层
        TBinaryProtocol.Factory protocolFactory = new TBinaryProtocol.Factory(true, true);
        // *) 处理层(Processor)
        HelloServiceImpl handler = new HelloServiceImpl();
//        HelloService.Processor<HelloServiceImpl> processor = new HelloService.Processor<HelloServiceImpl>(handler);

        // *) 服务层(Server)
//        TServer server = new TThreadPoolServer(
//                new TThreadPoolServer.Args(serverTransport)
//                        .protocolFactory(protocolFactory)
//                        .processor(processor));

        // *) 启动监听服务
//        server.serve();
        logger.info("服务已经启动，端口为："+port);
    }
}
