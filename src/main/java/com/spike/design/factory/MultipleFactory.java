package com.spike.design.factory;

/**
 * @description: 多工厂模式
 * @author: Spike
 * @date: 2020-05-13 15:46
 **/

public abstract class MultipleFactory {

    /**
     * 每个不同职责的具体实现工厂都再具体实现时再去做业务上的分割，不用再传递参数
     *
     */
    public abstract AbstractProduct createProduct();
}
