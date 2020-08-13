package com.spike.design.proxy;

/**
 * @description: 代理类
 * 代理模式的核心在代理类上
 * @author: Spike
 * @date: 2020-05-19 11:30
 **/

public class Proxy implements Subject{
    //要代理哪个实现类
    private Subject subject = null;

    //默认被代理者
    private Proxy(){
        this.subject = new Proxy();
    }
    //通过构造函数传递代理者
    private Proxy(Object... objects){

    }
    //在通常情况下，一个接口只需要一个代理类就可以了，具体代理哪个实现类由高层模块来决定，也就是在代理类的构造函数中传递被代理者
    //你要代理谁就产生该代理的实例，然后把被代理者传递进来，该模式在实际的项目应用中比较广泛。
    public Proxy(Object _subject){
        this.subject = (Subject) _subject;
    }

    @Override
    public void request() {
        this.before();
        this.subject.request();
        this.after();

    }
    //预处理
    private void before(){
        //do something
        System.out.println("before");
    }
    //善后处理
    private void after(){
        //do something
        System.out.println("after");
    }
}
