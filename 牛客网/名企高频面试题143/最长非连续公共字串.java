package 名企高频面试题143;

/**
 * Copyright (C), 2018-2020
 * FileName: 两个字符串最长公共子序列
 * Author:   xjl
 * Date:     2020/10/9 12:23
 * Description:
 */

public class 最长非连续公共字串 {

    public static void main(String[] args) {
        System.out.println(getLongestCommonSequence("1AB2345CD", "12345EF"));
    }

    public static String getLongestCommonSequence(String s1, String s2) {
        int a_len = s1.length();
        int b_len = s2.length();
        int[][] dp = new int[a_len + 1][b_len + 1];
        int[][] pre = new int[a_len + 1][b_len + 1];

        int size = 0;
        StringBuilder sb = new StringBuilder();
        /**
         * dp[i][j] = dp[i-1][j-1]+1 ,A[i]=A[j]
         * dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]) A[i]!=A[j];
         * 边界考虑i,j下标从1开始。
         */
        for (int i = 1; i <= a_len; i++) {
            char a = s1.charAt(i - 1);
            for (int j = 1; j <= b_len; j++) {
                char b = s2.charAt(j - 1);
                if (a == b) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    pre[i][j] = 0;
                    if (dp[i][j] > size) {
                        size = dp[i][j];
                    }
                } else if (dp[i][j - 1] >= dp[i - 1][j]) {
                    dp[i][j] = dp[i][j - 1];
                    pre[i][j] = 2;
                } else {
                    dp[i][j] = dp[i - 1][j];
                    pre[i][j] = 1;
                }
            }
        }
        int i = a_len;
        int j = b_len;
        /**
         * 输出子序列
         */
        while (i > 0 && j > 0) {
            if (pre[i][j] == 0) {
                sb.append(s1.charAt(i - 1));
                i--;
                j--;
            } else if (pre[i][j] == 1) {
                i--;
            } else {
                j--;
            }
        }
        return sb.reverse().toString();
    }
}
