package com.spike.design.model;

import java.util.Random;

/**
 * @description: 场景类
 * @author: Spike
 * @date: 2020-05-14 15:36
 **/

public class Client {

    public static void main(String[] args) {
        AbstractClass abstractClassA = new ConcreteClassA();
        AbstractClass abstractClassB = new ConcreteClassB();

        int i = new Random().nextInt(10) + 1;
        System.out.println(i);
        //调用模版方法
        if(i==4){
            ((ConcreteClassA) abstractClassA).setTrue(false);
        }
        abstractClassA.templateMethod();
        abstractClassB.templateMethod();

    }
}
