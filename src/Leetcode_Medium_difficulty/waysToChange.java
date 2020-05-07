/**
 * Copyright (C), 2018-2020
 * FileName: waysToChange
 * Author:   xjl
 * Date:     2020/4/23 9:32
 * Description: 面试题 08.11. 硬币
 */
package Leetcode_Medium_difficulty;

import org.junit.Test;

public class waysToChange {
    public int waysToChange(int n) {
        int mod = 1000000007;
        int[] type = {1, 5, 10, 25};
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 0; i < type.length; i++) {
            for (int j = type[i]; j <= n; j++) {
                dp[j] = dp[j] + dp[j - type[i]];
                System.out.println("**********"+dp[j]);
                if (dp[j] >= mod) {
                    dp[j] = dp[j] % mod;
                }
            }
        }
        for (int i=0;i<dp.length;i++){
            System.out.println(dp[i]);
        }
        return dp[n];
    }

    @Test
    public void test() {
        //waysToChange(10);
        System.out.println(waysToChange(10));
    }
}
