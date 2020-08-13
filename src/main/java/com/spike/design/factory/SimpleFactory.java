package com.spike.design.factory;

/**
 * @description: 简单工厂类
 * @author: Spike
 * @date: 2020-05-13 15:38
 **/

/**
 * 简单工厂类，一个模块仅仅需要一个工厂，没有必要把他产生出来
 */
public class SimpleFactory {

    public static <T extends AbstractProduct> T createProduct(Class<T> c) {
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
