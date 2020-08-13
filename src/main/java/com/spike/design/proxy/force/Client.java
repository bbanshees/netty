package com.spike.design.proxy.force;

/**
 * @description: 强制代理模式的场景类
 * @author: Spike
 * @date: 2020-05-19 14:40
 **/

public class Client {


    //强制代理：你必须通过真实角色查找到代理角色，否则你不能访问，通过代理去访问真实角色的方法
    public static void main(String[] args) {
        test2();
    }


    // 直接通过具体对象无法访问，无法访问
    private static void test(){
        IFSubject subject = new FRSubject("spike");
        subject.doBizA("你好");
        subject.doBiz();
    }
    // 强制代理的场景类
    private static void test2(){
        IFSubject subject = new FRSubject("spike");
        IFSubject proxy = subject.getProxy();
        proxy.doBizA("你好");
        proxy.doBiz();
    }
}
