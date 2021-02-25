/**
 * Copyright (C), 2018-2020
 * FileName: 背包问题01问题
 * Author:   xjl
 * Date:     2020/9/13 14:28
 * Description:
 */
package 计算机程序算法分类.动态规划问题集合;

public class 背包问题多重背包 {



    public static int completePack3(int V, int N, int[] weight, int[] value) {
        //动态规划
        int[] dp = new int[V + 1];
        for (int i = 1; i < N + 1; i++) {
            //顺序实现
            for (int j = weight[i - 1]; j < V + 1; j++) {
                dp[j] = Math.max(dp[j - weight[i - 1]] + value[i - 1], dp[j]);
            }
        }
        return dp[V];
    }



}
