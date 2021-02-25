/**
 * Copyright (C), 2018-2020
 * FileName: uniquePaths62
 * Author:   xjl
 * Date:     2020/7/7 8:34
 * Description: 62. 不同路径
 */
package leetcode练习题;

import org.junit.Test;

public class uniquePaths62 {

    public int uniquePaths(int m, int n) {
        //d[i][j]: start->(i,j) 一共有多少个uniqueunique paths
        //d[i][j]=dp[i-1][j]+d[i][j-1]
        //d[0][0]=1

        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0) {
                    dp[i][j] += dp[i - 1][j];
                }
                if (j > 0) {
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    @Test
    public void test() {
        int i = uniquePaths(3, 4);
        System.out.println(i);
    }

}
