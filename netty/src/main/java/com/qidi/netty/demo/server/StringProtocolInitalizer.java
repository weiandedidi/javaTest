package com.qidi.netty.demo.server;

import com.qidi.netty.demo.server.handlers.DispatcherHandler;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 初始化的相关配置，在springboot启动时候初始化 字符类型的初始化类
 * <p>
 * 使用$$做分割符号
 * <p>
 * User: qidi
 * Date: 2018/11/1
 * Time: 下午3:24
 */
@Component("springProtocolInitializer")
public class StringProtocolInitalizer extends ChannelInitializer<SocketChannel> {

    @Autowired
    StringDecoder stringDecoder;

    @Autowired
    StringEncoder stringEncoder;

    @Value("${message.length}")
    private int length;


    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {

        ChannelPipeline pipeline = socketChannel.pipeline();

//        创建ssl单向验证服务
//        SSLEngine engine = factory.getServerContext(path).createSSLEngine();
//        engine.setUseClientMode(false);      //设置为服务器模式
//        pipeline.addLast("ssl", new SslHandler(engine));

//        分隔符 拆包不能单例
        String delimiter = "$$";
        ByteBuf byteBuf = Unpooled.copiedBuffer(delimiter, CharsetUtil.UTF_8);
        pipeline.addLast("framer", new DelimiterBasedFrameDecoder(length, byteBuf));

        //编码是@Sharable 随意可以注入当成单例使用
        pipeline.addLast("decoder", stringDecoder);
        pipeline.addLast("encoder", stringEncoder);

        //消息处理 如果不是全局的统计，不能使用单例的，因为客户端断了重连会爆 is not a @Sharable handler错误
        pipeline.addLast(new DispatcherHandler());
    }

}
