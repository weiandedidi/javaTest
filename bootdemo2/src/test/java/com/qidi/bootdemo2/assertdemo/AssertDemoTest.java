package com.qidi.bootdemo2.assertdemo;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author qidi
 * @date 2019-02-25 14:57
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AssertDemoTest {

    @Autowired
    AssertDemo assertDemo;

    @Test
    public void testAssert() {
        String params = "ab";
        assertDemo.isNull(params);
    }

    @Test
    public void testAssertV3() {
        String params = null;
        assertDemo.notNull(params);
    }

    @Test
    public void testAssertV2() {
        List<Long> ids = Lists.newArrayList();
        assertDemo.notEmpty(ids);
    }
}