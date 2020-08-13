package com.spike.design.abstract_factory;

/**
 * @description: 产品B1
 * @author: Spike
 * @date: 2020-05-13 17:18
 **/

public class ProdB1 extends AbstractProdB {
    @Override
    public void doBizB() {
        System.out.println("BB1");
    }

    @Override
    public void doBiz() {
        System.out.println("B1");
    }
}
