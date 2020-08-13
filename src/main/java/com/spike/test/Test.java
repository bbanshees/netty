package com.spike.test;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @description: 各种奇奇怪怪的test
 * @author: Spike
 * @date: 2019-12-03 10:23
 **/

public class Test {
        public static void latch() {
        final CountDownLatch latch = new CountDownLatch(2);
        new Thread(() -> {
            try {
                System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
                Thread.sleep(3000);
                System.out.println("子线程"+Thread.currentThread().getName()+"执行完毕");
                latch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
                Thread.sleep(3000);
                System.out.println("子线程"+Thread.currentThread().getName()+"执行完毕");
                latch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        try {
            System.out.println("等待2个子线程执行完毕...");
            latch.await();
            System.out.println("2个子线程已经执行完毕");
            System.out.println("继续执行主线程");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private static void test1(){
        new Thread(() -> {
            try {
                System.out.println("1 " + test());
            } catch (Exception e) {
                System.out.println("1 异常啦! " + e.getMessage());
            }
        }).start();
        new Thread(() -> {
            try {
                System.out.println("2 " + test());
            } catch (Exception e) {
                System.out.println("2 异常啦! " + e.getMessage());
            }
        }).start();
        new Thread(() -> {
            try {
                System.out.println("3 " + test());
            } catch (Exception e) {
                System.out.println("3 异常啦! " + e.getMessage());
            }
        }).start();
        new Thread(() -> {
            try {

                System.out.println("4 " + test());
            } catch (Exception e) {
                System.out.println("4 异常啦! " + e.getMessage());
            }
        }).start();
    }
    private static ExecutorService newFixedThreadPool() {
        return new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(1), new ThreadFactoryBuilder()
                .setNameFormat("pool-%d").build(), new ThreadPoolExecutor.AbortPolicy());
    }
    private static ExecutorService executorService = newFixedThreadPool();
    private static String test() {


        FutureTask<String> task = new FutureTask<>(() -> {
            System.out.println("running:" + Thread.currentThread().getId());
//            Thread.sleep(10000);
            return "当前：" + Thread.currentThread().getId();
        });
        try {
            executorService.submit(task);
            return "result:" + task.get();
        } catch (Exception e) {
            return "内部异常啦! " + e.getMessage();
        }

    }



    private static void tes2() {
        Test test = new Test();
        test.callPrice(49000, 75,12);
    }
    private void callPrice(int price, int... discounts) {
        float knockdown = price;
        for (int discount : discounts) {
            knockdown = knockdown * discount / 100;
        }
        System.out.println(knockdown);
    }
    private void callPrice(int price, int discount) {
        float knockdown = price;

        knockdown = knockdown * discount / 100;

        System.out.println(knockdown);
    }

    public static void main(String[] args) {
                test1();
    }
}


