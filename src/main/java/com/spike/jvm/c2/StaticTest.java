package com.spike.jvm.c2;

/**
 * @description:
 * @author: Spike
 * @date: 2020-07-08 09:50
 **/

public class StaticTest extends StaticDemo {


    /**
     * 静态代码块的特点
     * 随着类的加载而执行，而且只执行一次
     * 静态代码块执行顺序优先于main函数
     */
    static {
        System.out.println("子类的静态代码块");
    }

    {
        System.out.println("子类的非静态代码块");
    }

    public StaticTest() {
        System.out.println("子类的构造方法");
        // TODO Auto-generated constructor stub
    }

    public static void main(String[] args) {
        System.out.println("main函数");
        new com.spike.jvm.c2.StaticTest();
    }
}



