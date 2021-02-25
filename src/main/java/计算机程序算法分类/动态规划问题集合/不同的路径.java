/**
 * Copyright (C), 2018-2020
 * FileName: 不同的路径
 * Author:   xjl
 * Date:     2020/9/8 15:40
 * Description:
 */
package 计算机程序算法分类.动态规划问题集合;

public class 不同的路径 {
    /**
     * 一种的方法是：开始的把两边的开始    * 开始的从（1,1） 开始的的时候计算
     * 一种的直接从（0,0）开始的计算  然后按照这个每一行的计算
     * @param obstacleGrid
     * @return
     */
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
