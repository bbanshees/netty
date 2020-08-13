package com.algorithm.leetcode;

/**
 * @description: 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * <p>
 * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 * <p>
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * <p>
 * 示例 1:
 * s = "abc", t = "ahbgdc"
 * <p>
 * 返回 true.
 * <p>
 * 示例 2:
 * s = "axc", t = "ahbgdc"
 * <p>
 * 返回 false.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/is-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: Spike
 * @date: 2020-07-15 15:07
 **/

public class IsSubString {
    public static void main(String[] args) {
        IsSubString isSubString = new IsSubString();
        isSubString.isSubsequence("[>][<>]]");

    }


    public void isSubsequence(String t) {
        char[] cht = t.toCharArray();
        int index = 0;
        int flag = 0;
        int ptmp = 0;
        int rtmp = 0;
        for (char c2 : cht) {
            if ('[' == c2) {
                flag++;
                ptmp++;
            }
//            if ('>' == c2 || '}' == c2 && flag > 0) {
//                flag--;
//                ptmp--;
//            }

            if (']' == c2 && flag > 0) {
                flag--;
                rtmp++;
            }

        }

        index += Math.max(0, Math.min(ptmp, rtmp));

        flag = 0;
        ptmp = 0;
        rtmp = 0;
        for (char c2 : cht) {
            if ('<' == c2) {
                flag++;
                ptmp++;

            }
//            if (']' == c2 || '}' == c2 && flag > 0) {
//                flag--;
//                ptmp--;
//            }
            if ('>' == c2 && flag > 0) {
                flag--;
                rtmp++;
            }
        }
        index += Math.max(0, Math.min(ptmp, rtmp));
        flag = 0;
        ptmp = 0;
        rtmp = 0;
        for (char c2 : cht) {
            if ('{' == c2) {
                flag++;
                ptmp++;

            }
//            if (']' == c2 || '>' == c2 && flag > 0) {
//                flag--;
//                ptmp--;
//            }
            if ('}' == c2 && flag > 0) {
                flag--;
                rtmp++;
            }
        }
        index += Math.max(0, Math.min(ptmp, rtmp));


        System.out.println(index);

    }

    public boolean isSubsequenceMultipleS(String s, String t) {
        // 预处理
        t = " " + t; // 开头加一个空字符作为匹配入口
        int n = t.length();
        int[][] dp = new int[n][26]; // 记录每个位置的下一个ch的位置
        for (char ch = 0; ch < 26; ch++) {
            int p = -1;
            for (int i = n - 1; i >= 0; i--) { // 从后往前记录dp
                dp[i][ch] = p;
                if (t.charAt(i) == ch + 'a') p = i;
            }
        }
        // 匹配
        int i = 0;
        for (char ch : s.toCharArray()) { // 跳跃遍历
            i = dp[i][ch - 'a'];
            if (i == -1) return false;
        }
        return true;
    }

}
