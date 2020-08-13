package com.spike.jdkRead.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @author: Spike
 * @date: 2020-08-09 17:23
 **/

public class LockTest implements  Runnable{

    LockTest(){
        System.out.println(Thread.currentThread().getName()+":"+Thread.currentThread().getState());
    }

    private static Lock reentrantLock = new ReentrantLock();
    static int i = 0 ;

    private static  void A(){
        reentrantLock.lock();
        System.out.println("A is processed");
    }

    private static void B(){
        reentrantLock.lock();
        System.out.println("B is processed");
    }

    private  void test(){



    }


    public static void main(String[] args) {
//        long time = System.currentTimeMillis();
//
//        A();
//
//        B();
//
//        if(System.currentTimeMillis() - time > 10000){
//            System.out.println("dead");
//            System.exit(0);
//        }
//
//        System.out.println("normal");

        LockTest lockTest = new LockTest();
        Thread thread = new Thread(lockTest);
        System.out.println(thread.getName()+":"+thread.getState());
        thread.start();
        try {
            Thread.sleep(10000);
            System.out.println(thread.getName()+":"+thread.getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(thread.getName()+":"+thread.getState());


    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+":"+Thread.currentThread().getState());
    }
}
