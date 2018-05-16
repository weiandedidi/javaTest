package com.qidi.autowire;

/**
 * 测试spring注入的final的拼写的bug
 *
 * @author: qidima
 * @date: 2018/5/16
 * Time: 16:00
 */
public class Client {
    String trafficViolationApiHost;
    //这么写就是傻逼的行为
    public final String AUTO_WZCX_LIST_API = trafficViolationApiHost + Constant.AUTO_TRAFFIC_VILATION_API_URL;

    public String getTrafficViolationApiHost() {
        return trafficViolationApiHost;
    }

    public void setTrafficViolationApiHost(String trafficViolationApiHost) {
        this.trafficViolationApiHost = trafficViolationApiHost;
    }

    public void printHostUrl() {
        System.out.println(this.AUTO_WZCX_LIST_API);
    }
}
