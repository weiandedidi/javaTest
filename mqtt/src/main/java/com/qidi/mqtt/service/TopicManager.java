package com.qidi.mqtt.service;

import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

/**
 * 消息处理类
 *
 * @author qidi
 * @date 2019-11-18 19:55
 */
public interface TopicManager {

    void dealTopic(String topic, Message<?> message);
}
