package com.spike.design.proxy.flex;

/**
 * @description: 强制代理模式下 增加了代理者自身的业务
 * @author: Spike
 * @date: 2020-05-19 14:40
 **/

public class Client {


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
