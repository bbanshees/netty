package com.spike.design.abstract_factory;

/**
 * @description: 场景类
 * @author: Spike
 * @date: 2020-05-13 17:27
 **/

public class Client {

    public static void main(String[] args) {
        AbstractFac abstractFac1 = new Fac1();
        AbstractFac abstractFac2 = new Fac2();

        abstractFac1.create("A").doBiz();
        abstractFac1.create("B").doBiz();
        abstractFac2.create("A").doBiz();
        abstractFac2.create("B").doBiz();
    }
}
