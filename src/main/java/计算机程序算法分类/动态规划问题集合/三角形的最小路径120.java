/**
 * Copyright (C), 2018-2020
 * FileName: 三角形的最小路径
 * Author:   xjl
 * Date:     2020/9/7 13:39
 * Description:
 */
package 计算机程序算法分类.动态规划问题集合;

import java.util.List;

public class 三角形的最小路径120 {
    /**
     * dp[i][j]=Math.min(dp[i-1][j-1],dp[i-1][j])+tr[i][j]
     * dp[i][0]=dp[i-1][0]+tr[i][0]
     * dp[i][j]=dp[i-1][i-1]+tr[i][i]
     * <p>
     * 这个是一个从上往下的一个方式
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        //开辟数组
        int[][] dp = new int[len][len];
        // 边界
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < len; i++) {
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
            }
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
        }
        //三角形的最后一行的位置
        int ans = dp[len - 1][0];
        //遍历的最后一行所在的位置的进行比较 求解最小值
        for (int i = 0; i < len; i++) {
            ans = Math.min(ans, dp[len - 1][i]);
        }
        return ans;
    }

    /**
     * 实现的是从下网上走的一个方式
     * <p>
     * d[i][j]=Math.min(dp[i+][j],dp[i+][j+])+trangle[i][j]
     *
     * @param triangle
     * @return
     */

    public int minimumTotal1(List<List<Integer>> triangle) {
        int n = triangle.size();
        //开辟数组
        int[][] dp = new int[n+1][n+1];
        // 边界
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }
}
