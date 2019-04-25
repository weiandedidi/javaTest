package com.qidi.netty.demo.dto;

import lombok.Data;

/**
 * @author qidi
 * @date 2019-04-24 18:02
 */
@Data
public class Header {
    /**
     * 报文的方法名
     */
    private String interfaceName;
    //客户端的系统信息
}
