package com.spike.design.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @description: 动态代理类
 * @author: Spike
 * @date: 2020-05-29 13:12
 **/

public class DynamicProxy<T> {
    public static  <T> T newProxyInstance(ClassLoader loader,
                                       Class<?>[] interfaces,
                                       InvocationHandler h){
        //寻找join point连接点，aop框架使用源数据定义
        if(true){
            //执行一个前置通知
            (new BeforeAdvice()).exec();
        }
        //执行目标，并返回结果
        return (T)Proxy.newProxyInstance(loader,interfaces,h);
    }

}
