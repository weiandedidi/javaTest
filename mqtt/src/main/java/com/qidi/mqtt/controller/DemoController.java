package com.qidi.mqtt.controller;

import com.qidi.mqtt.config.MqttGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qidi
 * @date 2019-11-15 22:43
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    MqttGateway mqttGateway;

    @RequestMapping("/hi")
    public Object hi() {
        return "你好";
    }

    @RequestMapping("/mqtt/send.do")
    public String sendMqtt(String sendData, String topic) {
        mqttGateway.sendToMqtt(sendData, topic);
        return "OK";
    }

}
