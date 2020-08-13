package com.spike.design.builder;

/**
 * 导演类
 * 导演类起到封装的作用，避免高层模块深入到建造者内部的实现类。当然，在建造者模式比较庞大时，导演类可以有多个
 * @author: Spike
 * @date: 2020-05-19 09:47
 **/

public class Director {
    private Builder builder = new ConcreteBuilder();
    //构造不通的产品
    public Product buildProduct(){
        builder.setPart();

        //这是不同的零件，产生不同的产品
        return builder.buildProduct();
    }

    //构造不通的产品
    public Product buildProductA(){
        builder.setPart();

        //这是不同的零件，产生不同的产品
        return (Product) builder.buildProductWithAbstract();
    }
}
