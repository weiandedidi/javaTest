package com.qidi.bean;

import com.qidi.autowire.Client;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: qidima
 * @date: 2018/5/16
 * Time: 16:03
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})
public class TestFinal {

    @Autowired
    Client client;
    @Test
    public void testFinal() {
        client.printHostUrl();
    }
}
