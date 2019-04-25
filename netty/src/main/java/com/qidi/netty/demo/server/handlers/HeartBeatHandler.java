package com.qidi.netty.demo.server.handlers;

import com.alibaba.fastjson.JSON;
import com.qidi.netty.demo.dto.CommonDto;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.UnknownHostException;

/**
 * 基础的心跳类
 *
 * @author maqidi
 * @date 19/04/02
 * @time 下午3:02
 */
@Slf4j
public abstract class HeartBeatHandler extends ChannelInboundHandlerAdapter {


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        if (!(cause instanceof IOException)) {
            log.error("HeartBeatHandler message : {},  throwable cause : {}", cause.getMessage(), ExceptionUtils.getStackTrace(cause));
        }
        ctx.close();
    }


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws UnknownHostException {
        //心跳信息发送
        String receiveJson = (String) msg;
        receiveJson.trim();
        log.info("接到客户端消息 message={}", msg);
        if (StringUtils.isEmpty(receiveJson)) {
            return;
        }

        CommonDto dto = JSON.parseObject(receiveJson, CommonDto.class);
        String interfaceName = dto.getHeader().getInterfaceName();

        //更具报文方法分发
        switch (interfaceName) {
            case "HEART_BEAT":
                ctx.writeAndFlush(JSON.toJSONString(dto) + "\r\n");
                break;
            default:
                try {
                    //业务信息处理
                    handleData(ctx, msg);
                } catch (Exception e) {
                    log.error("处理业务消息异常：{}", msg);
                }
                break;
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws UnsupportedEncodingException {
        log.info("客户端连接成功: remoteAddress={}", ctx.channel().remoteAddress());

    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        //TODO 删除ChannelsHolder
        log.info("客户端断开:" + ctx.channel().remoteAddress());

    }

    /**
     * 消息处理层的业务逻辑
     *
     * @param channelHandlerContext
     * @param msg
     */
    protected abstract void handleData(ChannelHandlerContext channelHandlerContext, Object msg);

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {

        if (evt instanceof IdleStateEvent) {
            IdleStateEvent e = (IdleStateEvent) evt;
            switch (e.state()) {
                case READER_IDLE:
                    handleReaderIdle(ctx);
                    break;
                default:
                    break;
            }
        } else {
            super.userEventTriggered(ctx, evt);
        }

    }

    protected void handleReaderIdle(ChannelHandlerContext ctx) {
        //读空闲的 探活 操作
    }

}
