package com.qidi.bootdemo2.nio.nio;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.oio.OioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.oio.OioServerSocketChannel;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

/**
 * 1. Channel，表示一个连接，可以理解为每一个请求，就是一个Channel
 * 2. ChannelHandler，核心处理业务就在这里，用于处理业务请求。
 * 3. ChannelHandlerContext，用于传输业务数据。
 * 4. ChannelPipeline，用于保存处理过程需要用到的ChannelHandler和ChannelHandlerContext
 * <p>
 * ChannelInboundHandlerAdapter inbound的管道是先进先出，所以pipeline.add(1,2,3,4,5)，操作就是1，2，3，4，5操作
 * ChannelOutboundHandlerAdapter outbound的管道是先进后出，所以pipeline.add(1,2,3,4,5)，操作就是5，4，3，2，1
 *
 * @author qidi
 * @date 2019-03-25 16:50
 */
public class NettyOioServer {
    public void server(int port) throws Exception {
        final ByteBuf buf = Unpooled.unreleasableBuffer(
                Unpooled.copiedBuffer("Hi!\r\n", Charset.forName("UTF-8")));
        EventLoopGroup group = new OioEventLoopGroup();
        try {
            //1.引导器
            ServerBootstrap bootstrap = new ServerBootstrap();
            //2.加载channel池
            bootstrap.group(group)
                    .channel(OioServerSocketChannel.class)
                    .localAddress(new InetSocketAddress(port))
                    //放入channel
                    .childHandler(
                            //ChannelInitializer初始化器
                            new ChannelInitializer<SocketChannel>() {
                                @Override
                                public void initChannel(SocketChannel ch) throws Exception {
                                    //pipeline管道放入处理器集合
                                    ch.pipeline().addLast(new ChannelInboundHandlerAdapter() {
                                        @Override
                                        public void channelActive(ChannelHandlerContext ctx) throws Exception {
                                            ctx.writeAndFlush(buf.duplicate()).addListener(ChannelFutureListener.CLOSE);
                                        }
                                    });
                                }
                            });
            ChannelFuture f = bootstrap.bind().sync();  //6
            f.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully().sync();        //7
        }
    }
}
