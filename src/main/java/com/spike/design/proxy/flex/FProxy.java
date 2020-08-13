package com.spike.design.proxy.flex;

/**
 * @description: 普通模式的代理者
 * @author: Spike
 * @date: 2020-05-19 14:27
 **/

public class FProxy implements IFSubject,IProxy {
    private IFSubject iFSubject = null;

    //通过构造函数进行传递被代理对象
    public FProxy(IFSubject subject){
        this.iFSubject = subject;
    }


    @Override
    public void doBiz() {
        this.iFSubject.doBiz();
        this.doBizz();
    }

    @Override
    public void doBizA(String param) {
        this.iFSubject.doBizA(param);
        this.doBizz();
    }

    //代理的代理暂时没有
    @Override
    public IFSubject getProxy() {
        return this;
    }

    @Override
    public void doBizz() {
        System.out.println("proxy business");
    }
}
