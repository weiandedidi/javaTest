package com.qidi.thrift.service;

import org.apache.thrift.TException;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: qidima
 * @date: 2018/5/2
 * Time: 15:02
 */
public class HelloServiceImpl implements HelloService.Iface {
    @Override
    public String hello(String name) throws TException {
        return "Hi," + name + " welcome to thrift demo world";
    }
}
