package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @description: n 求和 用递归
 * @author: Spike
 * @date: 2020-06-02 10:48
 **/

public class SumN {

    public static void main(String[] args) {

//        System.out.println( sumNums(2));
//        System.out.println( sumNums1(2));
        System.out.println(sumNums2(2));

    }


    static int[] test = new int[]{0};

    static int sumNums(int n) {
        try {
            return test[n];
        } catch (Exception e) {
            e.printStackTrace();
            return n + sumNums(n - 1);
        }
    }

    //利用逻辑运算符的短路性质
    static int sumNums1(int n) {
        boolean flag = n > 0 && (n += sumNums1(n - 1)) > 0;
        return n;
    }

    static int sumNums2(int n) {
        final int[] res = {0};
        Stream.iterate(0, i -> i + 1).limit(n + 1).forEach(i -> {
            res[0] += i;
        });
        return res[0];
    }


}
