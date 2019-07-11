package com.spike.netty;


import java.nio.channels.Channel;

public class Test3<C extends Channel> extends Father implements Test31<C>{
    @Override
    public void get() {

    }
    Test3(){}

//
//    public Test3(Class<? extends C> clazz) {
//        if (clazz == null) {
//            throw new NullPointerException("clazz");
//        }
//    }
    public <C> Test3(Class<? extends C> clazz) {
        if (clazz == null) {
            throw new NullPointerException("clazz");
        }
    }

    @Override
    public void run() {

    }
}
