package com.spike.jvm.c2;

/**
 * @description:
 * @author: Spike
 * @date: 2020-07-02 15:49
 **/

public class ClassLoaderTest2 {

    public static void main(String[] args) {

        try{
            //1.
            ClassLoader classLoader = Class.forName("java.lang.String").getClassLoader();
            System.out.println(classLoader);
            //2.
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            System.out.println(contextClassLoader);
            //3.
            ClassLoader parent = ClassLoader.getSystemClassLoader().getParent();
            System.out.println(parent);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
