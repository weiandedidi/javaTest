package com.qidi.netty.demo.receiver;

import com.alibaba.fastjson.JSON;
import com.qidi.netty.demo.dto.CommonDto;
import org.springframework.stereotype.Component;

/**
 * @author qidi
 * @date 2019-04-25 11:00
 */
@Component
public class ReceiverDemoServiceImpl implements ReceiverDemoService {
    @Override
    public String parseMessage(String message) {
        CommonDto dto = JSON.parseObject(message, CommonDto.class);
        return "success";
    }
}
