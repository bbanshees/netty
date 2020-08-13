package com.spike.design.factory;


import com.spike.design.singleton.AbstractSingletonFactory;
import com.spike.design.singleton.Singleton;
import com.spike.design.singleton.SingletonA;
import com.spike.design.singleton.SingletonB;

/**
 * @description: 场景类
 * @author: Spike
 * @date: 2020-05-13 15:20
 **/
public class Client {
    public static void main(String[] args) {

        /**
         * 通用工厂类模版
         */
        AbstractFactory abstractFactory = new ConcreteFactory();
        AbstractProduct abstractProductA1 = abstractFactory.createProduct(ConcreteProduct1.class);
        AbstractProduct abstractProductA2 = abstractFactory.createProduct(ConcreteProduct2.class);
        //业务
        System.out.println(abstractProductA1.method2());
        System.out.println(abstractProductA2.method2());

        /**
         * 简单工厂类模版,静态工厂模式
         */
        AbstractProduct abstractProductB1 = SimpleFactory.createProduct(ConcreteProduct1.class);
        AbstractProduct abstractProductB2 = SimpleFactory.createProduct(ConcreteProduct2.class);
        //业务
        System.out.println(abstractProductB1.method2());
        System.out.println(abstractProductB2.method2());

        /**
         * 多工厂模式模版;在复杂的应用中一般采用多工厂的方法，然后再增加一个协调类，
         * 避免调用者与各个子工厂交流，协调类的作用是封装子工厂类，对高层模块提供统一的访问接口。
         */
        AbstractProduct abstractProductC1 = (new MultipleAFactory()).createProduct();
        AbstractProduct abstractProductC2 = (new MultipleBFactory()).createProduct();
        //业务
        System.out.println(abstractProductC1.method2());
        System.out.println(abstractProductC2.method2());

        /**
         * 替代单例模式
         */
        //直接获取该单例
        Singleton singletonD1 = SingletonFactory.getSingleton();
        //通过输入类的类型获取一个类的实例对象
        AbstractSingletonFactory singletonD2 = SingletonFactoryWithParams.createSingleton(SingletonA.class);
        AbstractSingletonFactory singletonD3 = SingletonFactoryWithParams.createSingleton(SingletonB.class);
        //业务
        singletonD1.doBiz();
        singletonD2.doBiz();
        singletonD3.doBiz();

        /**
         * 延迟初始化
         */
        AbstractProduct abstractProductE1 = LazyLoadFactory.createProduct("product1");
        AbstractProduct abstractProductE2 = LazyLoadFactory.createProduct("product2");
        //业务
        System.out.println(abstractProductE1.method2());
        System.out.println(abstractProductE2.method2());

    }
}
