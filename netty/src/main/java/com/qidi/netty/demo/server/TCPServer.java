package com.qidi.netty.demo.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.net.InetSocketAddress;

/**
 * TCP的启动类，初始化的时候启动netty
 * User: qidi
 * Date: 2018/11/1
 * Time: 下午3:33
 */
@Component
@Slf4j
public class TCPServer {
    @Autowired
    @Qualifier("serverBootstrap")
    private ServerBootstrap serverBootstrap;

    @Autowired
    @Qualifier("tcpSocketAddress")
    private InetSocketAddress tcpPort;

    private ChannelFuture serverChannelFuture;

    @PostConstruct
    public void start() throws Exception {
        log.info("Starting server port {} ===============", tcpPort);
        serverChannelFuture = serverBootstrap.bind(tcpPort).sync();
    }

    @PreDestroy
    public void stop() throws Exception {
        serverChannelFuture.channel().closeFuture().sync();
    }

    public ServerBootstrap getServerBootstrap() {
        return serverBootstrap;
    }

    public void setServerBootstrap(ServerBootstrap serverBootstrap) {
        this.serverBootstrap = serverBootstrap;
    }

    public InetSocketAddress getTcpPort() {
        return tcpPort;
    }

    public void setTcpPort(InetSocketAddress tcpPort) {
        this.tcpPort = tcpPort;
    }

    public ChannelFuture getServerChannelFuture() {
        return serverChannelFuture;
    }

    public void setServerChannelFuture(ChannelFuture serverChannelFuture) {
        this.serverChannelFuture = serverChannelFuture;
    }
}
