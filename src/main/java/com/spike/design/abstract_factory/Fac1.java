package com.spike.design.abstract_factory;

/**
 * @description: 工厂1只能生产等级1的商品
 * @author: Spike
 * @date: 2020-05-13 17:22
 **/

public class Fac1 extends AbstractFac {
    @Override
    public AbstractProd create(String type) {
        if("A".equals(type)){
            return new ProdA1();
        }else {
            return new ProdB1();
        }
    }
}
