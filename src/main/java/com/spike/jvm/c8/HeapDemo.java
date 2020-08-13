package com.spike.jvm.c8;

import java.util.ArrayList;
import java.util.Random;

/**
 * @description: heap
 * @author: Spike
 * @date: 2020-07-20 13:56
 **/

public class HeapDemo {

    public static void main(String[] args) {

        System.out.println("start");
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end");



//        test();

    }

    byte[] buffer = new byte[new Random().nextInt(1024*2)];
    private static void test(){
        ArrayList<HeapDemo> list = new ArrayList<>();
        while(1==1){
            list.add(new HeapDemo());
            try{
                Thread.sleep(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }


    }

}
