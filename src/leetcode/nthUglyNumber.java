/**
 * Copyright (C), 2018-2020
 * FileName: nthUglyNumber
 * Author:   xjl
 * Date:     2020/4/3 12:28
 * Description: 丑数
 */
package leetcode;

import org.junit.Test;

public class nthUglyNumber {

    public int nthUglyNumber(int n) {
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if (dp[i] == n2) a++;
            if (dp[i] == n3) b++;
            if (dp[i] == n5) c++;
        }
        return dp[n - 1];
    }

    @Test
    public void test() {
        nthUglyNumber(10);
    }
}
