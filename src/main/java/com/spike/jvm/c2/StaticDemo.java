package com.spike.jvm.c2;

import java.util.concurrent.Executors;

/**
 * @description:
 * @author: Spike
 * @date: 2020-07-08 09:49
 **/

public class StaticDemo {
    //静态代码块
    static {
        System.out.println("父类的静态代码块");
    }

    //构造方法
    public StaticDemo() {
        System.out.println("父类的构造方法");
    }

    //非静态代码块
    {
        System.out.println("父类的非静态代码块");
    }
}


