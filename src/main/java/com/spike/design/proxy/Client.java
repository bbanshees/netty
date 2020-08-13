package com.spike.design.proxy;

/**
 * @description: 场景类
 * @author: Spike
 * @date: 2020-05-19 14:31
 **/

public class Client {

    public static void main(String[] args) {


        Proxy proxy = new Proxy(new RealSubject());
        proxy.request();
    }
}
