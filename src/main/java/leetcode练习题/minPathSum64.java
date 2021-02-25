/**
 * Copyright (C), 2018-2020
 * FileName: minPathSum64
 * Author:   xjl
 * Date:     2020/7/23 21:14
 * Description: 64. 最小路径和
 */
package leetcode练习题;

import java.util.Scanner;

public class minPathSum64 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] result = new int[n][m];

        //数据的赋值
        for (int i = 0; i < n; i++) {
            String[] s = sc.nextLine().split(" ");
            for (int j = 0; j < m; j++) {
                result[i][j] = Integer.valueOf(s[j]);
            }
        }

        int i = minPathSum(result);
        System.out.println(i);
    }

    public static int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        dp[0][0] = grid[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + grid[i][j]);
                }
                if (j > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + grid[i][j]);
                }
            }
        }
        return dp[n - 1][m - 1];
    }

}
