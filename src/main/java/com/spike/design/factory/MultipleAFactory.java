package com.spike.design.factory;

/**
 * @description: 多工厂模式，具体实现工厂A
 * @author: Spike
 * @date: 2020-05-13 15:50
 **/

public class MultipleAFactory extends MultipleFactory{
    @Override
    public AbstractProduct createProduct() {
        return new ConcreteProduct1();
    }
}
