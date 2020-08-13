package com.spike.design.builder;

/**
 * @description: 抽象建造者
 * @author: Spike
 * @date: 2020-05-19 09:31
 **/

public abstract class Builder {
    //设置产品的不同部分，以获得不同的产品
    public abstract void setPart();

    //生产产品：可以根据具体需求使用抽象产品 或者具体产品
    public abstract AbstractProduct buildProductWithAbstract();
    public abstract Product buildProduct();

}
