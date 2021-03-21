package 牛客网名企高频面试题2020;

import org.junit.Test;

/**
 * @Classname 最大的正方形
 * @Description TODO
 * @Date 2020/12/13 21:08
 * @Created by xjl
 */
public class 最大的正方形 {
    public int solve(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0] - '0';
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i] - '0';
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    //表示的边长的位置
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
                    //表示的是位置的表示的长度
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1]) + 1;
                    //最大位置的长度
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }

    @Test
    public void test() {
        solve(new char[][]{{1, 0, 1, 0, 0}, {1, 0, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 0, 0, 1, 0}});
    }
}
