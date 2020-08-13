package com.spike.jdkRead.juc;

import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @description: juc test
 * @author: Spike
 * @date: 2020-06-18 13:33
 **/

public class JUC {


//    private static volatile boolean flag =true;
    private static  boolean flag =true;

    public static void main(String[] args) throws Exception{


//        ExecutorService executor = Executors.newFixedThreadPool(10);
//        Future future = executor.submit(()->"12");
//        Object o = future.get();
//        System.out.println(o);


        new Thread(()->{
            System.out.println("A is running");
            while(flag){

            }
            System.out.println("A is ending");

        }).start();

        Thread.sleep(10);

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("B is running");

                flag = false;

                System.out.println("B is ending");
            }
        }).start();


        Lock lock = new Lock() {
            @Override
            public void lock() {

            }

            @Override
            public void lockInterruptibly() throws InterruptedException {

            }

            @Override
            public boolean tryLock() {
                return false;
            }

            @Override
            public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
                return false;
            }

            @Override
            public void unlock() {

            }

            @Override
            public Condition newCondition() {
                return null;
            }
        };




    }

}
