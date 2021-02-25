/**
 * Copyright (C), 2018-2020
 * FileName: uniquePathsWithObstacles63
 * Author:   xjl
 * Date:     2020/7/7 9:05
 * Description: 63. 不同路径 II
 */
package leetcode练习题;

public class uniquePathsWithObstacles63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    if (j > 0) {
                        dp[i][j] += dp[i][j - 1];
                    }
                    if (i > 0) {
                        dp[i][j] += dp[i - 1][j];
                    }
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
