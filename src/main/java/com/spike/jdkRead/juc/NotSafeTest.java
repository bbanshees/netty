package com.spike.jdkRead.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @description:
 *
 *  1，故障现象
 *  2，导致原因
 *  3，解决方案
 *  4，优化建议
 *
 *
 * @author: Spike
 * @date: 2020-08-03 17:26
 **/

public class NotSafeTest {




    public static void main(String[] args) {
        List<String > list = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0,8));
            }, String.valueOf(i)).start();
        }



    }
}
