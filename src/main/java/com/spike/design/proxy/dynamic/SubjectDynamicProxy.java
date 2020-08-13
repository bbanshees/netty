package com.spike.design.proxy.dynamic;


import java.lang.reflect.InvocationHandler;

/**
 * @description: 业务的动态代理类
 * @author: Spike
 * @date: 2020-05-29 14:02
 **/
//子父类之间代码执行顺序：父类静态代码块—子静态代码块—父构造代码块—父构造方法—子构造代码块—子构造方法
public class SubjectDynamicProxy extends DynamicProxy {

    public static  <T> T newProxyInstance(IFSubject subject){
        //获取class loader
        ClassLoader classLoader = subject.getClass().getClassLoader();
        //获取接口数组
        Class<?>[] classes = subject.getClass().getInterfaces();
        //获取handler
        InvocationHandler handler = new DyProxyHandler(subject);

        return newProxyInstance(classLoader,classes,handler);
    }

}
