package com.spike.jdkRead.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: 题目：三个售票员 卖出 30张票
 * <p>
 * 笔记：如何编写企业级的多线程代码
 * <p>
 * 固定的编程套路+模版
 * <p>
 * 1，在高内聚低耦合的前提下，线程 操作 资源类
 * 1.1  先创建-个资源类
 * @author: Spike
 * @date: 2020-08-03 14:56
 **/


class Ticket { // 资源类 = 实例变量 + 实例方法

    private int num = 30;

    Lock lock = new ReentrantLock();

    public void sale() {
        lock.lock();
        try {
            if (num > 0) {
                System.out.println(Thread.currentThread().getName()+"\t卖出第："+(num--)+"\t 还剩下："+num);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
public class SalesTicketTest {

    public static void main(String[] args) {

        Ticket ticket = new Ticket();


        //线程.start后不是立即运行，会等待底层操作系统与cpu的调度
        //线程的状态 一共 有 6 种 : new ; runnable ; block ; waiting ; timed_waiting ; terminated
        //Thread.State;


        new Thread(()->{ for (int i = 1; i <= 40; i++) ticket.sale();},"D").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 40; i++) {
                    ticket.sale();
                }
            }
        },"A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 40; i++) {
                    ticket.sale();
                }
            }
        },"B").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 40; i++) {
                    ticket.sale();
                }
            }
        },"C").start();

    }
}

