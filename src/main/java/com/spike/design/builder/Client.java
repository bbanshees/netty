package com.spike.design.builder;

/**
 * @description: 场景类
 * @author: Spike
 * @date: 2020-05-19 10:04
 **/

public class Client {
    public static void main(String[] args) {
        Director director = new Director();
        director.buildProduct().doBiz();
        director.buildProduct().doSomething();
        director.buildProductA().doSomething();
        director.buildProductA().doBiz();
    }
}
