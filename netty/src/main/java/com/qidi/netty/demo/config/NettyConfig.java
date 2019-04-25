package com.qidi.netty.demo.config;

import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * springboot启动bean的时候，注册一个nettyserver
 * User: qidi
 * Date: 2018/11/1
 * Time: 下午3:19
 */
@Configuration
public class NettyConfig {

    /**
     * 配置需要的解码
     *
     * @return
     */
    @Bean(name = "stringEncoder")
    public StringEncoder stringEncoder() {
        return new StringEncoder(CharsetUtil.UTF_8);
    }

    /**
     * 配置编码
     *
     * @return
     */
    @Bean(name = "stringDecoder")
    public StringDecoder stringDecoder() {
        return new StringDecoder(CharsetUtil.UTF_8);
    }

}
