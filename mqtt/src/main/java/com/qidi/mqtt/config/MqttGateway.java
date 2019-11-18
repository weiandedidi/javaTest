package com.qidi.mqtt.config;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.handler.annotation.Header;

/**
 * 配置MqttGateway消息推送接口类
 * 配置信息处理的网管接口
 *
 * @author qidi
 * @date 2019-11-18 16:57
 */

@MessagingGateway(defaultRequestChannel = "mqttOutboundChannel")
public interface MqttGateway {

    /**
     * 发送mqtt消息
     *
     * @param data  需要发送的数据
     * @param topic
     */
    void sendToMqtt(String data, @Header(MqttHeaders.TOPIC) String topic);
}
