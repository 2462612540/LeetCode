/**
 * Copyright (C), 2018-2020
 * FileName: cuttingRope
 * Author:   xjl
 * Date:     2020/4/5 11:11
 * Description: 剪绳子
 */
package Leetcode_Medium_difficulty;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class cuttingRope {
    public int cuttingRope(int n) {
        if (n <= 3) return n - 1;
        int a = n / 3;
        int b = n % 3;
        if (b == 0) return (int) Math.pow(3, a);
        if (b == 1) return (int) Math.pow(3, a - 1) * 4;
        return (int) Math.pow(3, a) * 2;
    }

    public int cuttingRope2(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        int[] f = new int[n + 1];
        f[1] = 1;
        f[2] = 2;
        f[3] = 3;
        int MAX = 0;
        for (int i = 4; i <= n; i++) {
            int max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int item = f[j] * f[i - j];
                if (item > max) {
                    max = item;
                }
                f[i] = max;
            }
        }
        MAX = f[n];
        return MAX;
    }

    public int cuttingRope3(int n) {
        Map map=new HashMap();
        map.keySet();
        if (n < 2) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(Math.max(j * dp[i - j], j * (i - j)), dp[i]);
            }
        }
        return dp[n];
    }

    @Test
    public void test() {
        System.out.println(cuttingRope3(10));
    }

}
