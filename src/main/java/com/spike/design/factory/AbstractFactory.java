package com.spike.design.factory;

/**
 * @description: 抽象工厂类
 * @author: Spike
 * @date: 2020-05-13 14:33
 **/

/**
 * 抽象工厂负责产品的产生
 */
public abstract class AbstractFactory {

    /**
     * 创建一个产品对象，其输入参数类型可以自行设置
     * 通常为
     * @param c
     * @param <T>
     * @return
     */
    public abstract <T extends AbstractProduct> T createProduct(Class<T> c);

}
