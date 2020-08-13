package com.spike.design.model;

/**
 * @description: 具体模版类A
 * @author: Spike
 * @date: 2020-05-14 15:34
 **/

public class ConcreteClassA extends AbstractClass{

    private boolean isTrue = true;
    @Override
    protected void doBiz() {
        System.out.println("A");
    }

    @Override
    protected void doSomething() {
        System.out.println("AA");
    }

    //勾子方法
    protected boolean isTrue(){
        return this.isTrue;
    }



    //由入参来控制基本方法
    public void setTrue(boolean isTrue){
        this.isTrue = isTrue;
    }
}
