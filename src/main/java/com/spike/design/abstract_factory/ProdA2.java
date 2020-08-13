package com.spike.design.abstract_factory;

/**
 * 产品A2
 * @author: Spike
 * @date: 2020-05-13 17:16
 **/

public class ProdA2 extends AbstractProdA {
    @Override
    public void doBizA() {
        System.out.println("AA2");
    }

    @Override
    public void doBiz() {
        System.out.println("A2");
    }
}
