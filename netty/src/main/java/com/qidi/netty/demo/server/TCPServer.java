package com.qidi.netty.demo.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${so.keepalive}")
    private boolean keepAlive;

    @Value("${so.backlog}")
    private int backlog;

    @Value("${tcp.port}")
    private int tcpPort;

    @Autowired
    @Qualifier("springProtocolInitializer")
    private StringProtocolInitalizer protocolInitalizer;

    /**
     * acceptor group
     */
    private NioEventLoopGroup parentGroup;
    /**
     * client group
     */
    private NioEventLoopGroup childGroup;
    /**
     * 保存server的异步结果
     */
    private ChannelFuture serverChannelFuture;

    @PostConstruct
    public void start() throws Exception {
        parentGroup = new NioEventLoopGroup();
        childGroup = new NioEventLoopGroup();

        ServerBootstrap server = new ServerBootstrap();
        server.group(parentGroup, childGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(protocolInitalizer);

        //option定义
        server.option(ChannelOption.SO_KEEPALIVE, keepAlive);
        server.option(ChannelOption.SO_BACKLOG, backlog);

        log.info("==============Starting server port {} ====================", tcpPort);
        serverChannelFuture = server.bind(tcpPort).sync();
    }

    @PreDestroy
    public void stop() {
        try {
            serverChannelFuture.channel().closeFuture().sync();

        } catch (InterruptedException e) {
            log.error("serverChannelFuture InterruptedException e={}, msg={}", e.getMessage(), e.getCause());
        } finally {
            parentGroup.shutdownGracefully();
            childGroup.shutdownGracefully();
        }
    }
}
