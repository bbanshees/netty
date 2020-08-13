package com.spike.design.abstract_factory;

/**
 * 产品A1
 * @author: Spike
 * @date: 2020-05-13 17:14
 **/

public class ProdA1 extends AbstractProdA {

    @Override
    public void doBizA() {
        System.out.println("AA1");
    }

    @Override
    public void doBiz() {
        System.out.println("A1");
    }
}
