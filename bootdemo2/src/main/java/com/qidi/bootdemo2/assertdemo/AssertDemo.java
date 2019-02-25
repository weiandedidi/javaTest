package com.qidi.bootdemo2.assertdemo;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;

/**
 * 断言测试类
 *
 * @author qidi
 * @date 2019-02-25 14:39
 */
@Component
public class AssertDemo {
    /**
     * 测试断言类 是null是合理的，不是null报异常
     */
    public void isNull(String params) {
        Assert.isNull(params, "params is should be null");

    }


    /**
     * 测试断言类 null报异常
     */
    public void notNull(String params) {
        Assert.notNull(params, "params is can not be null");

    }

    /**
     * 不为空，为空报错
     *
     * @param ids
     */
    public void notEmpty(List<Long> ids) {
        Assert.isTrue(CollectionUtils.isNotEmpty(ids), "ids is empty");
    }
}
