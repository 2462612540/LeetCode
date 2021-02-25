/**
 * Copyright (C), 2018-2020
 * FileName: 最小路径和64
 * Author:   xjl
 * Date:     2020/9/7 12:27
 * Description:
 */
package 计算机程序算法分类.动态规划问题集合;

import org.junit.Test;

/**
 * 写出这个转态的转移方程式
 * dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+dp[i][j]
 */
public class 最小路径和64 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (grid == null || m == 0 || n == 0) {
            return 0;
        }
        //1 设置一个数组
        int[][] dp = new int[m][n];

        //3 确定的边界的时候
        dp[0][0] = grid[0][0];
        //当列为0的时候的边界
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        //当行为0的时候的边界
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        //2 状态转移方程
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        //结果是最后的
        return dp[m - 1][n - 1];
    }

    @Test
    public void test() {
        int[][] array = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int i = minPathSum(array);
        System.out.println(i);
    }
}
