package com.qidi.springthrift.service;

import com.qidi.springthrift.service.ConnectionProvider;
import org.apache.thrift.transport.TSocket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 连接池管理器
 *
 * @author: qidima
 * @date: 2018/5/3
 * Time: 10:15
 */
@Service
public class ConnectionManager {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    /** 保存local对象 */
    ThreadLocal<TSocket> socketThreadSafe = new ThreadLocal<TSocket>();
    /** 连接提供池 */
    @Autowired
    private ConnectionProvider connectionProvider;

    public TSocket currentSocket() {
        return socketThreadSafe.get();
    }
    public void close() {
        connectionProvider.returnCon(socketThreadSafe.get());
        socketThreadSafe.remove();
    }
    public TSocket getSocket() {
        TSocket socket = null;
        try {
            socket = connectionProvider.getConnection();
            socketThreadSafe.set(socket);
            return socket;
        } catch (Exception e) {
            logger.error("error ConnectionManager.invoke()", e);
        }
        return socket;
    }


}
