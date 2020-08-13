package com.spike.design.builder;

/**
 * @description: 建造者实现
 * @author: Spike
 * @date: 2020-05-19 09:42
 **/

public class ConcreteBuilder extends Builder {

    private AbstractProduct abstractProduct = new Product();
    //或者
    private Product product =  new Product();

    @Override
    public void setPart() {
        //产品的具体内部业务逻辑处理
        this.product.doBiz();
        this.abstractProduct.doBiz();
        this.product.doSomething();

    }

    @Override
    public AbstractProduct buildProductWithAbstract() {
        return this.abstractProduct;
    }

    @Override
    public Product buildProduct() {
        return this.product;
    }
}
