package com.spike.design.singleton;

import com.spike.design.factory.SingletonFactory;

/**
 * @description: 单例类A
 * @author: Spike
 * @date: 2020-05-13 16:22
 **/

public class SingletonA extends AbstractSingletonFactory {

    private SingletonA(){}

    @Override
    public void doBiz() {
        System.out.println("SA");
    }
}
