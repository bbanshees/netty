package com.algorithm.leetcode.bytedance;

/**
 * @description: 字典序的第K个字符
 * @author: Spike
 * @date: 2020-06-03 15:59
 **/

/**
 * 给定整数 n 和 k，找到 1 到 n 中字典序第 k 小的数字。
 */
public class DictNumK {


    public static void main(String[] args) {
        System.out.println(findKthNumber(100, 12));
    }


    public static int findKthNumber(int n, int k) {

        int prefix = 1; //前缀

        //使用 1 是为了包括某前缀之前所有的数，与下面的 tem + curr > k 相呼应；
        //
        // 比如1-100的第12个位置时，1下面有12个数（包括1），那 12 + 1 = 13 > 12 把1为前缀的数量全都包含进来了；
        // 说明 第12个位置在 前缀1 下面；
        // 1，否则 如果是 0 ： 则会出现 12 + 0 = 12 不大于 12 的情况，那指针就会指向下一个前缀，本来是在前缀1下的数字，
        // 却跑到了前缀2下面；这样造成错误判断
        //
        // 2，那把tem + curr > k 换成 >= 可以吗？；
        // 这样的话，会出现这种情况情况，12 + 0 >= 12；然后往下遍历，此时 curr = 1；pre=10；
        // 计算到 19 时，curr = 11；
        // 这样的话，会比正常的位置 少 1 位，本来19就是第12个位置了应该退出大循环（curr<k）但是还是进入了下一次循环，
        // 这样 tem 这时=1；curr=11；加起来是等于12的；
        // 会进入到19为前缀的子节点中，这是不正确的
        // 所以curr只能=1；不能等于0；
        //
        // 3，那curr等于1 ，能否将tem + curr > k 变成>=呢；答案是否定的；还是按照1-100；12 举例子；本来第11个数的时候，
        // 应该是 1 + 11 = 12 不大于 12；然后进入下一个前缀的；
        // 但是换成等于之后，就会错误判断为12在当前前缀下，就会进入18为前缀的子节点中进行查找；造成错误判断
        int curr = 1;//作为一个指针，指向当前所在位置，当curr==k时，也就是到了排位第k的数
        while (curr < k) {
            int tem = num(n, prefix);

            if (tem + curr > k) {  //第k个数在当前前缀下
                prefix *= 10; //往下层遍历
                curr++;//把指针指向了第一个子节点的位置，比如11乘10后变成110，指针从11指向了110
            } else {//不在当前前缀下
                //注意这里的操作，把指针指向了下一前缀的起点
                prefix++;//换到下一个前缀
                curr += tem;//把之前 前缀 下面的节点数量全加上 并且指针挪到当前前缀
                System.out.println(curr);
            }
        }
        return prefix;
    }

    private static int num(int n, int prefix) {
        //不断向下层遍历可能一个乘10就溢出了, 所以用long
        long next = prefix + 1;//下一个前缀
        int count = 0;
        while (prefix <= n) {
            count += Math.min(n + 1, next) - prefix;//下一前缀减去当前前缀
            // 如果说刚刚prefix是1，next是2，那么现在分别变成10和20
            // 1为前缀的子节点增加10个，十叉树增加一层, 变成了两层

            // 如果说现在prefix是10，next是20，那么现在分别变成100和200，
            // 1为前缀的子节点增加100个，十叉树又增加了一层，变成了三层
            prefix *= 10;
            next *= 10; //往下层走
        }
        return count;
    }


}
