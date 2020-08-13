package com.spike.design.singleton;

/**
 * @description: 单例类B
 * @author: Spike
 * @date: 2020-05-13 16:23
 **/

public class SingletonB extends AbstractSingletonFactory {

    private SingletonB() {}

    @Override
    public void doBiz() {
        System.out.println("SB");
    }
}
