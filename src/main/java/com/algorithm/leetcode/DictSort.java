package com.algorithm.leetcode;

/**
 * @description: 字典排序
 * @author: Spike
 * @date: 2020-05-26 10:03
 **/

import java.util.*;

/**
 * 给定一个整数 n, 返回从 1 到 n 的字典顺序。
 * <p>
 * 例如，
 * <p>
 * 给定 n =1 3，返回 [1,10,11,12,13,2,3,4,5,6,7,8,9] 。
 * <p>
 * 请尽可能的优化算法的时间复杂度和空间复杂度。 输入的数据 n 小于等于 5,000,000。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lexicographical-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


/**
 * 3种解法：1，dfs；2，遍历10叉树；3，Collection.sort() sort 字符串
 * dfs最优
 */
public class DictSort {
    public static void main(String[] args) {
//        Solution.lexicalOrder(12);
//        Solution.lexicalOrderWhitDFS(12);
        DFS.lexicalOrder(2).forEach(System.out::println);
//        Solution.lexicalOrderWhitTree(122);

    }

    static class DFS {

        static List<Integer> lexicalOrder(int n) {
            List<Integer> res = new ArrayList<>();
            for (int i = 1; i < 10; i++) {
                dfs(res,i, n);
            }
            return res;
        }

        private static void dfs(List<Integer> res,int start, int n) {
            if (start > n) {
                return;
            }
            res.add(start);
            start *= 10;
            for (int i = 0; i < 10; i++) {
                if (start + i <= n) {
                    dfs(res,start + i, n);
                }
            }
        }

    }

    static class Solution {
        public static List<Integer> lexicalOrder(int n) {
//            List<Integer> result = new ArrayList<>();
//            sort(result,0,n);
//            result.forEach(System.out::println);
//            return result;

            List<String> res = new ArrayList<String>();
            List<Integer> resInt = new ArrayList<Integer>();
            for (int i = 1; i <= n; i++) {
                res.add(String.valueOf(i));
            }
            res.forEach(e -> {
                System.out.println(e + ":" + stringToAscii(e));
            });

            Collections.sort(res);

            for (String r : res) {
                resInt.add(Integer.valueOf(r));
            }

//            resInt.forEach(System.out::println);
            return resInt;

        }

        public static String stringToAscii(String value) {
            StringBuffer sbu = new StringBuffer();
            char[] chars = value.toCharArray();

            for (int i = 0; i < chars.length; i++) {
                if (i != chars.length - 1) {
                    sbu.append((int) chars[i]).append(",");
                } else {
                    sbu.append((int) chars[i]);
                }
            }
            return sbu.toString();


        }

        //前序遍历 10 叉树
        static List<Integer> lexicalOrderWhitTree(int n) {
            List<Integer> res = new ArrayList<Integer>();
            //last-in-first-out
            Stack<Integer> tree = new Stack<Integer>();
            if (n < 10) {
                //放入第一列（不足10的整数）
                for (int i = n; i > 0; i--) {
                    tree.push(i);
                }
            } else {
                //放入第一列（比10大的整数 就是放1-9）
                for (int i = 9; i > 0; i--) {
                    tree.push(i);
                }
            }
            int t, m;
            while (!tree.empty()) {
                //获取该层第一个节点
                t = tree.peek();
                //删除第一个节点
                tree.pop();
                res.add(t);

                if (t * 10 > n) {
                    //如果这个节点大于限制，则进入同一层的下一个节点
                    continue;
                } else {
                    //获取该节点下一层的子节点的数量（小于10的 说明是10个节点，大于10的 说明不足10个节点）
                    m = n - t * 10;
                    if (m > 9) {
                        m = 9;
                    }
                }
                for (int i = m; i >= 0; i--) {
                    //将该节点下一层的子节点加入栈
                    tree.push(t * 10 + i);
                }
            }
            return res;
        }


        //山谷里有座千年古刹，一日，方丈收到一个任务，将1-n的字典排序进行输出；
        //思绪良久，方丈找来9个大法师，对第一个大法师说：“大弟子，我现在给你一个任务，我给你一个数字1，你负责把这个数字开头的，并且不大于n的所有数字按照字典排序交付于我。”
        //接着又对第二个大法师说：“二弟子，我也给你一个任务，我给你一个数字2，你负责把这个数字开头的，并且不大于n的所有数字按照字典排序交付于我。”
        //如是依次对剩下弟子说了一遍，各大法师领命依次离去；
        //大法师归于禅室，思虑良久：方觉方丈之策可复行之，乃唤来座下大弟子十人，依次要求将10,11,12...19开头的并且不大于n的所有数字交付于己。众大弟子离去，效法以行
//        public static void sort(List<Integer> result,Integer currentValue,int maxNum){
//
//            if(currentValue != null && currentValue > maxNum){
//                return;
//            }
//
//            if(currentValue != null) {
//                result.add(currentValue);
//            }
//            for(int nextBit = 0; nextBit <= 9;nextBit++){
//                if(currentValue == null ){
//                    if(nextBit == 0) {
//                        continue;
//                    } else {
//                        currentValue = 0;
//                    }
//                }
//                dsadsa(result,currentValue*10+nextBit,maxNum);
//            }
//        }


        public static List<Integer> lexicalOrderWhitDFS(int n) {
            List<Integer> result = new ArrayList<>();
            sort(result, 0, n);
            result.forEach(System.out::println);
            return result;
        }

        private static void sort(List<Integer> result, Integer i, int n) {

            if (i != 0) {
                result.add(i);
            }
            for (int k = 0; k < 10; k++) {
                if (i == 0) {
                    if (k == 0) {
                        continue;
                    }
                }
                if(i*10+k <= n){
                    sort(result, i * 10 + k, n);
                }
            }

        }


    }


}
