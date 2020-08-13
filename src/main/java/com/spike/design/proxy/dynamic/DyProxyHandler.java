package com.spike.design.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @description: 动态代理handler
 * @author: Spike
 * @date: 2020-05-29 11:16
 **/

public class DyProxyHandler implements InvocationHandler {


    //被代理者
    Class cls = null;
    //被代理的实例
    private Object target = null;
    //我要代理谁,通过构造方法传递一个对象
    public DyProxyHandler(Object obj){
        this.target = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(this.target,args);
    }
}
