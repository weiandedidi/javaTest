package com.qidi.mqtt.service;

import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

/**
 * @author qidi
 * @date 2019-11-18 20:40
 */
@Service
public class TopicManagerImpl implements TopicManager {
    /**
     * 信息处理
     *
     * @param topic
     * @param message
     */
    @Override
    public void dealTopic(String topic, Message<?> message) {
        if ("hello".equalsIgnoreCase(topic)) {
            //处理问题
            System.out.println("hello,fuckXX," + message.getPayload().toString());
        } else if ("hello1".equalsIgnoreCase(topic)) {
            //消息处理类
            System.out.println("hello1,fuckXX," + message.getPayload().toString());
        }
    }
}
