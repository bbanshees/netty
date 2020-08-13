package com.spike.jdkRead.juc;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: redis 分布式锁实现
 * @author: Spike
 * @date: 2020-08-09 15:47
 **/

public class RedisDistributeLock {

    private static Integer inventory = 1001;
    private static final int NUM = 1000;

    private static LinkedBlockingDeque blockingDeque = new LinkedBlockingDeque();

    static ReentrantLock reentrantLock = new ReentrantLock();
    static RedisLock redisLock = new RedisLock();

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(inventory, inventory, 10L, TimeUnit.SECONDS, blockingDeque);

        final CountDownLatch countDownLatch = new CountDownLatch(NUM);

        long start = System.currentTimeMillis();

        for (int i = 0; i < NUM; i++) {
            threadPoolExecutor.execute(() -> {

                inventory--;
                System.out.println("thread process : " + Thread.currentThread().getName() + " ; inventory : " + inventory);
                countDownLatch.countDown();
            });
        }

        threadPoolExecutor.shutdown();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("time used:" + (System.currentTimeMillis() - start));

        System.out.println("num of thread : " + NUM + " ; inventory : " + inventory);
    }
}

class RedisLock {
    RedisLock() {
    }

    // key name
    private static String LOCK_KEY = "redis_lock";
    // 自动失效时间
    private static long EX_RELEASE_TIME = 10L;
    // 超时时间，拿不到key就退出
    private long time_out = 30000;

    private static Jedis jedis = new JedisPool("", 6379).getResource();


    public boolean lock(String id) {

        long start = System.currentTimeMillis();

        try{
            for (; ; ) {
                String lock = jedis.set(LOCK_KEY, id, "nx", "px", EX_RELEASE_TIME);
                if ("OK".equals(lock)) {
                    return true;
                }

                long time = System.currentTimeMillis() - start ;
                if (time > time_out){
                    return false;
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }finally {
            jedis.close();
        }

    }

    public boolean unlock(String id){
        String script =
                "if redis.call('get',KEYS[1]) == ARGV[1] then" +
                        "   return redis.call('del',KEYS[1]) " +
                        "else" +
                        "   return 0 " +
                        "end";
        try{
            String result = jedis.eval(script, Collections.singletonList(LOCK_KEY),Collections.singletonList(id)).toString();
            return "1".equals(result);
        }finally {
            jedis.close();
        }
    }

}
