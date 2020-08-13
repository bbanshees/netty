package com.spike.design.proxy;

/**
 * @description: 真实主题类
 * RealSubject是一个正常的业务实现类
 * @author: Spike
 * @date: 2020-05-19 11:28
 **/

public class RealSubject implements Subject {
    @Override
    public void request() {
        //业务逻辑处理
        System.out.println("你好");
    }
}
