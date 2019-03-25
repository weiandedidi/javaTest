package com.qidi.bootdemo2.nio.httpsocket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;

/**
 * inbound的管道是先进先出，所以pipeline.add(1,2,3,4,5)，操作就是1，2，3，4，5操作
 * outbound的管道是先进后出，所以pipeline.add(1,2,3,4,5)，操作就是5，4，3，2，1
 * <p>
 * ChannelPipeline，用于存放ChannelHandler的容器
 * <p>
 * aggregator，消息聚合器（重要）。为什么能有FullHttpRequest这个东西就是因为有他，
 * HttpObjectAggregator，如果没有他，就不会有那个消息是FullHttpRequest的那段Channel，同样也不会有FullHttpResponse
 * HttpObjectAggregator(512 * 1024)的参数含义是消息合并的数据大小，如此代表聚合的消息内容长度不超过512kb。
 *
 * @author qidi
 * @date 2019-03-25 14:26
 */
public class HttpServer {

    private final int port;

    public HttpServer(int port) {
        this.port = port;
    }

    public void start() throws InterruptedException {
        //启动器
        ServerBootstrap bootstrap = new ServerBootstrap();
        //channel注册器
        NioEventLoopGroup group = new NioEventLoopGroup();
        bootstrap.group(group)
                .channel(NioServerSocketChannel.class)
                .childHandler(
                        new ChannelInitializer<SocketChannel>() {
                            @Override
                            protected void initChannel(SocketChannel ch) throws Exception {
                                System.out.println("initChannel ch:" + ch);
                                ch.pipeline()
                                        .addLast("decoder", new HttpRequestDecoder())
                                        .addLast("encoder", new HttpResponseEncoder())
                                        .addLast("aggregator", new HttpObjectAggregator(512 * 1024))
                                        .addLast("handler", new HttpHandler());
                            }
                        });
        // determining the number of connections queued
        bootstrap.option(ChannelOption.SO_BACKLOG, 128);
        bootstrap.childOption(ChannelOption.SO_KEEPALIVE, Boolean.TRUE);
        bootstrap.bind(port).sync();
    }
}
