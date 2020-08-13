package com.spike.design.model;

/**
 * @description: 具体模版类B
 * @author: Spike
 * @date: 2020-05-14 15:35
 **/

public class ConcreteClassB extends AbstractClass {

    @Override
    protected void doBiz() {
        //具体执行
        System.out.println("B");
    }

    @Override
    protected void doSomething() {
        //具体执行
        System.out.println("BB");
    }
    //勾子方法
    protected boolean isTrue(){
        return false;
    }


}
