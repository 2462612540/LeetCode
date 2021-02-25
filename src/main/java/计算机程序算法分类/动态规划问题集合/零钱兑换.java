/**
 * Copyright (C), 2018-2020
 * FileName: 零钱兑换
 * Author:   xjl
 * Date:     2020/10/9 20:28
 * Description:
 */
package 计算机程序算法分类.动态规划问题集合;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

public class 零钱兑换 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int amount = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int res = coinChange(arr, amount);
        System.out.println(res);
    }

    @Test
    public void test() {
        int[] conis = {1, 2, 5};
        int amount = 11;
        int ans = coinChange(conis, amount);
        System.out.println(ans);
    }

    public static int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
