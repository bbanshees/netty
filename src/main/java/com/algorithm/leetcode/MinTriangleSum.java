package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * <p>
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * <p>
 * 例如，给定三角形：
 * <p>
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: Spike
 * @date: 2020-07-14 13:23
 **/

public class MinTriangleSum {

    int total = 0;


    public static void main(String[] args) {
        MinTriangleSum minTriangleSum = new MinTriangleSum();
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> inner1 = new ArrayList<>();
        inner1.add(2);
        List<Integer> inner2 = new ArrayList<>();
        inner2.add(3);
        inner2.add(4);
        List<Integer> inner3 = new ArrayList<>();
        inner3.add(6);
        inner3.add(5);
        inner3.add(7);
        List<Integer> inner4 = new ArrayList<>();
        inner4.add(4);
        inner4.add(1);
        inner4.add(8);
        inner4.add(3);

        triangle.add(inner1);
        triangle.add(inner2);
        triangle.add(inner3);
        triangle.add(inner4);


        minTriangleSum.minimumTotal(triangle);
//        minTriangleSum.test(triangle);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        total = sum(triangle, 0, 0);
        System.out.println("result:" + total);
        return total;

    }


    /**
     * inner1.add(-1);
     * <p>
     * inner2.add(2);
     * inner2.add(3);
     * <p>
     * inner3.add(1);
     * inner3.add(-1);
     * inner3.add(-3);
     */
    private int sum(List<List<Integer>> triangle, int i, int j) {
        if (i == triangle.size()) {
            return 0;
        }

        int current = sum(triangle, i + 1, j);
//        System.out.println("j:" + j + " current sum:" + current);
        int next = sum(triangle, i + 1, j + 1);
//        System.out.println("j:" + (j + 1) + " next sum:" + next);


        int tmp = Math.min(current, next) + triangle.get(i).get(j);
        return tmp;


    }

    private int test(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] f = new int[n][n];
        f[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; ++i) {
            f[i][0] = f[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; ++j) {
                f[i][j] = Math.min(f[i - 1][j - 1], f[i - 1][j]) + triangle.get(i).get(j);
            }
            f[i][i] = f[i - 1][i - 1] + triangle.get(i).get(i);
        }
        int minTotal = f[n - 1][0];
        for (int i = 1; i < n; ++i) {
            minTotal = Math.min(minTotal, f[n - 1][i]);
        }
        System.out.println(minTotal);
        return minTotal;

    }


}
