package com.algorithm.leetcode;

import java.util.HashMap;

/**
 * @description: 地上有一个m行n列的方格，从坐标 [0, 0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，
 * 因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * @author: Spike
 * @date: 2020-07-13 16:42
 **/

public class RobotMoveSteps {
    private static HashMap<String, String> map = new HashMap<>();


    public static void main(String[] args) {

        boolean visit[][] = new boolean[38][15];
        move(38, 15, 9, 0, 0);
        System.out.println(map.size());

//        System.out.println(movingCount(38,15,9));
    }




    private static void move(int m, int n, int k, int currentX, int currentY) {


        if ((sumNum(currentX) + sumNum(currentY)) > k) {
            return;
        }
        if (map.containsKey(currentX + "," + currentY)) {
            return;
        }
        if (currentX  == m) { //向下
            return;
        }
        if (currentY  == n) { //向右
            return;
        }

        map.put(currentX + "," + currentY, "true");
        System.out.println(currentX + "," + currentY);

        move(m, n, k, currentX + 1, currentY);
        move(m, n, k, currentX, currentY + 1);

    }


    private static int sumNum(int n) {
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n = n / 10;
        }
        return sum;
    }

    public static int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(0, 0, m, n, k, visited);
    }

    private static int dfs(int i, int j, int m, int n, int k, boolean visited[][]) {
        if (i < 0 || i >= m || j < 0 || j >= n || (i / 10 + i % 10 + j / 10 + j % 10) > k || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        System.out.println(i + "," + j);
        return dfs(i + 1, j, m, n, k, visited) + dfs(i - 1, j, m, n, k, visited) +
                dfs(i, j + 1, m, n, k, visited) + dfs(i, j - 1, m, n, k, visited) + 1;
    }
}
