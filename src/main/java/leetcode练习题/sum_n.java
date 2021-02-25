/**
 * Copyright (C), 2018-2020
 * FileName: sum_n
 * Author:   xjl
 * Date:     2020/4/4 11:09
 * Description: n个骰子的点数
 */
package leetcode练习题;

import org.junit.Test;

public class sum_n {
    public double[] twoSum(int n) {
        int[][] dp = new int[n + 1][6 * n + 1];
        double[] ans = new double[5 * n + 1];
        double all = Math.pow(6, n);
        for (int i = 1; i <= 6; i++)
            dp[1][i] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= 6 * n; j++) {
                for (int k = 1; k <= 6; k++) {
                    dp[i][j] += j >= k ? dp[i - 1][j - k] : 0;
                    if (i == n)
                        ans[j - i] = dp[i][j] / all;
                }
            }
        }
        return ans;
    }

    @Test
    public void test() {
        twoSum(2);
    }
}
