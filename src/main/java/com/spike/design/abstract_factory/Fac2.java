package com.spike.design.abstract_factory;

/**
 * @description: 工厂2只能生产等级为2的商品
 * @author: Spike
 * @date: 2020-05-13 17:25
 **/

public class Fac2 extends AbstractFac {
    @Override
    public AbstractProd create(String type) {
        if("A".equals(type)){
            return new ProdA2();
        }else {
            return new ProdB2();
        }
    }
}
