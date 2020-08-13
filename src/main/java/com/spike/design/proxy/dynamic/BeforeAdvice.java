package com.spike.design.proxy.dynamic;

/**
 * @description: 通知接口实现类
 * @author: Spike
 * @date: 2020-05-29 13:18
 **/

public class BeforeAdvice implements IAdvice {
    @Override
    public void exec() {
        System.out.println("i am informed");
    }
}
