package com.spike.design.builder;

/**
 * @description: 产品类
 * @author: Spike
 * @date: 2020-05-19 09:28
 **/

public class Product extends AbstractProduct{

    public void doSomething(){
        System.out.println("业务处理");
    }

    @Override
    public void doBiz() {
        System.out.println("可有可无");
    }
}
