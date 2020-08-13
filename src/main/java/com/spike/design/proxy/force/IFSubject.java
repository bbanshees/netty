package com.spike.design.proxy.force;

public interface IFSubject {

    public void doBiz();
    public void doBizA(String param);
    //每个人可以找到自己的代理
    public IFSubject getProxy();
}
