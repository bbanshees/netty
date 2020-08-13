package com.spike.design.singleton;

/**
 * @description:
 * @author: Spike
 * @date: 2020-05-11 15:53
 **/

public class TestMain {

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        Singleton singleton1 =Singleton.getInstance();
        System.out.println(singleton.toString());
        System.out.println(singleton1.toString());

        System.out.println(transformedBeanName("&&&73&2132131w"));
    }

    public static String transformedBeanName(String name) {

        String beanName;
        for(beanName = name; beanName.startsWith("&"); beanName = beanName.substring("&".length())) {
        }

        return beanName;
    }
}
