package com.spike.design.proxy.normal;

/**
 * @description: 普通模式的代理者
 * @author: Spike
 * @date: 2020-05-19 14:27
 **/

public class NProxy implements ISubject {
    private ISubject iSubject = null;

    //通过构造函数进行传递被代理对象
    public NProxy(String type){
        try{
            iSubject = new RSubject(this,type);
        }catch (Exception e){
            // TODO
        }
    }


    @Override
    public void doBiz() {
        this.iSubject.doBiz();

    }

    @Override
    public void doBizA(String param) {
        this.iSubject.doBizA(param);
    }
}
