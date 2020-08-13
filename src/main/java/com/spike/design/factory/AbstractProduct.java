package com.spike.design.factory;

/**
 *
 * @description: 工厂抽象类
 * @author: Spike
 * @date: 2020-05-13 14:23
 **/

/**
 * 定义一个用于创建对象的接口，让子类决定实例化哪一个类。工厂方法使一个类的实例化延迟到其子类。
 */
public abstract class AbstractProduct {

    //产品的公共方法
    public void method1(){

    }

    //抽象方法
    public abstract String method2();
}
