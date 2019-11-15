package com.qidi.mqtt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qidi
 * @date 2019-11-15 22:43
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping("/hi")
    public Object hi() {

        return "你好";
    }
}
