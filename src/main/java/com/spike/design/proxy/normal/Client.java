package com.spike.design.proxy.normal;

/**
 * @description: 普通模式的场景类
 * @author: Spike
 * @date: 2020-05-19 14:40
 **/

public class Client {

    //普通模式：它的要求就是客户端只能访问代理角色，而不能访问真实角色，这是比较简单的
    public static void main(String[] args) {
        ISubject proxy = new NProxy("spike");
        proxy.doBizA("你好");
        proxy.doBiz();
    }
}
