package com.spike.jdkRead.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: 循环打印Abc
 * @author: Spike
 * @date: 2020-08-10 00:36
 **/

public class CircleABC {

    public static void main(String[] args) {
        final Demo ad = new Demo();

        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 2; i++) {
                    ad.loopA(i);
                }

            }
        },"A").start();

        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 2; i++) {
                    ad.loopB(i);
                }

            }
        },"B").start();

        new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 2; i++) {
                    ad.loopC(i);
                }
            }
        },"C").start();

    }

}

class Demo{

    private int num =1 ;
    private Lock lock = new ReentrantLock();

    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void loopA(int loop){

        lock.lock();

        try {
            //1.判断
            if(num != 1){
                condition1.await();
            }

            //2.打印
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName()+"-"+"第"+loop+"轮"+"-第"+i+"次");
            }

            //3.唤醒
            num = 2;
            condition2.signal();
        } catch (Exception e) {
            // TODO: handle exception
        }finally{
            lock.unlock();
        }
    }

    public void loopB(int loop){
        lock.lock();
       try {
           if(num !=2 ){
               condition2.await();
           }

           //2.打印
           for (int i = 0; i < 3; i++) {
               System.out.println(Thread.currentThread().getName()+"-"+"第"+loop+"轮"+"-第"+i+"次");
           }

           num = 3;
           condition3.signal();

       }catch (Exception e){

       }finally {
           lock.unlock();
       }
    }

    public void loopC(int loop){
        lock.lock();
        try {
            if(num !=3 ){
                condition3.await();
            }

            //2.打印
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName()+"-"+"第"+loop+"轮"+"-第"+i+"次");
            }

            num = 1;
            condition1.signal();

        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }

}
