package com.spike.design.factory;

/**
 * @description: 具体工厂实现类
 * @author: Spike
 * @date: 2020-05-13 15:17
 **/

public class ConcreteFactory extends AbstractFactory {
    @Override
    public <T extends AbstractProduct> T createProduct(Class<T> c) {
        AbstractProduct abstractProduct;
        try{
            abstractProduct = (AbstractProduct) Class.forName(c.getName()).newInstance();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return (T)abstractProduct;
    }
}
