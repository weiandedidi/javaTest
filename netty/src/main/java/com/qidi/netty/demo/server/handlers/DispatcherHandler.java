package com.qidi.netty.demo.server.handlers;

import com.qidi.netty.demo.receiver.ReceiverDemoService;
import com.qidi.netty.demo.utils.SpringUtils;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;

/**
 * 具体实现业务逻辑
 * User: qidi
 * Date: 2018/11/1
 * Time: 下午3:26
 */
@Slf4j
public class DispatcherHandler extends HeartBeatHandler {

    @Override
    protected void handleData(ChannelHandlerContext channelHandlerContext, Object msg) {
        //具体的报文处理方法 分发处理，然后进行相应操作

        //switch分发消息


        //这里service处理方法必须使用spring的Context获取bean而不是注入，因为是new出来的对象，不是注入
        ReceiverDemoService receiverDemoService = SpringUtils.getBean(ReceiverDemoService.class);
        log.info("DispatcherHandler instance receiverDemoService ***********");
        String str = (String) msg;
        String data = receiverDemoService.parseMessage(str);


        //回复报文
        Channel channel = channelHandlerContext.channel();
        //协定报文分隔符
        ChannelFuture channelFuture = channel.writeAndFlush(data + "$$");
        try {
            channelFuture = channelFuture.sync();
        } catch (InterruptedException e) {
            log.info("发送报文中断了, e={}, casues={}", e.getMessage(), e.getCause());
        }
        //发送是否成功
        channelFuture.isSuccess();

    }
}
