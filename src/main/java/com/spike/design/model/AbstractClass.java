package com.spike.design.model;

/**
 * @description: 模版方法类
 * @author: Spike
 * @date: 2020-05-14 10:43
 **/

/**
 * 模板方法模式确实非常简单，仅仅使用了Java的继承机制，但它是一个应用非常广泛的模式。
 * 其中，AbstractClass叫做抽象模板，它的方法分为两类：
 * ●基本方法
 * 基本方法也叫做基本操作，是由子类实现的方法，并且在模板方法被调用。
 * ●模板方法
 * 可以有一个或几个，一般是一个具体方法，也就是一个框架，实现对基本方法的调度，完成固定的逻辑
 *
 * 注意 为了防止恶意的操作，一般模板方法都加上final关键字，不允许被覆写
 *
 *
 * 还有一个一个角色：具体模板。
 * ConcreteClass1和ConcreteClass2属于具体模板，实现父类所定义的一个或多个抽象方法，也就是父类定义的基本方法在子类中得以实现。
 */
public abstract class AbstractClass {

    /**
     * 注意 抽象模板中的基本方法尽量设计为protected类型，符合迪米特法则，不需要暴露的属性或方法尽量不要设置为protected类型。
     * 实现类若非必要，尽量不要扩大父类中的访问权限。
     */
    //基本方法
    protected abstract void doBiz();
    //基本方法
    protected abstract void doSomething();
    //模版方法
    final public void templateMethod(){
        //调用基本方法，完成相关逻辑
        this.doBiz();
        //由入参来控制基本方法
        if(this.isTrue()){
            this.doSomething();
        }

    }
    //勾子方法
    protected boolean isTrue(){
        return true;
    }



}
