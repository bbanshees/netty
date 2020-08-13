package com.spike.design.proxy.dynamic;

import com.spike.design.proxy.Subject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @description: 强制代理模式的场景类
 * @author: Spike
 * @date: 2020-05-19 14:40
 **/

public class Client {


    public static void main(String[] args) {
        test();
    }


    private static void test() {
        //定义一个对象
        IFSubject subject = new FRSubject("spike");
        //定义一个handler
        InvocationHandler handler = new DyProxyHandler(subject);
        //获得class loader
        ClassLoader classLoader = subject.getClass().getClassLoader();
        //动态产生一个代理者
//        IFSubject proxy = (IFSubject) Proxy.newProxyInstance(classLoader, new Class[]{IFSubject.class}, handler);
        IFSubject proxy = (IFSubject) Proxy.newProxyInstance(classLoader, FRSubject.class.getInterfaces(), handler);
        //业务实现
        proxy.doBiz();



    }

    private static void test1() {
        //定义一个对象
        IFSubject subject = new FRSubject("spike");
        //定义一个handler
        InvocationHandler handler = new DyProxyHandler(subject);
        //定义对象的代理
        IFSubject proxy = DynamicProxy.newProxyInstance(subject.getClass().getClassLoader(),
                subject.getClass().getInterfaces(), handler);
        //业务实现
        proxy.doBiz();
        proxy.doBizA("pw:123");
    }

    private static void test2() {
        //定义一个主题
        IFSubject subject = new FRSubject("spike");
        //定义主题的代理
        IFSubject proxy = SubjectDynamicProxy.newProxyInstance(subject);
        //代理的行为
        proxy.doBizA("testttt");
        proxy.doBiz();
    }

}
