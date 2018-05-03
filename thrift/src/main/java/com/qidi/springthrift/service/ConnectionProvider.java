package com.qidi.springthrift.service;

import org.apache.thrift.transport.TSocket;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: qidima
 * @date: 2018/5/3
 * Time: 10:16
 */
public interface ConnectionProvider {
    /**
     * 取链接池中的一个链接
     * @return TSocket
     */
    TSocket getConnection();

    /**
     * 返回链接
     * @param socket
     */
    void returnCon(TSocket socket);

}
