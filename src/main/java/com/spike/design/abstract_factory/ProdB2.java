package com.spike.design.abstract_factory;

/**
 * @description: 产品B2
 * @author: Spike
 * @date: 2020-05-13 17:19
 **/

public class ProdB2 extends AbstractProdB {
    @Override
    public void doBizB() {
        System.out.println("BB2");
    }

    @Override
    public void doBiz() {
        System.out.println("B2");
    }
}
