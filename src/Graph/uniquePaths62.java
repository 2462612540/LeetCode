/**
 * Copyright (C), 2018-2020
 * FileName: uniquePaths62
 * Author:   xjl
 * Date:     2020/7/2 16:06
 * Description: 62. 不同路径
 */
package Graph;

public class uniquePaths62 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i + 1 < m) {
                    dp[i + 1][j] += dp[i][j];
                }
                if (j + 1 < n) {
                    dp[i][j + 1] += dp[i][j];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
