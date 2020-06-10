/**
 * Copyright (C), 2018-2020
 * FileName: cuttingRope14_1
 * Author:   xjl
 * Date:     2020/6/9 20:36
 * Description: 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 */
package NewLeetcode;

import org.junit.Test;

public class cuttingRope14_1 {
    /**
     * 剪绳子的函数
     *
     * @param n
     * @return
     */
    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int k = 1; k <= n; k++) {
            for (int i = 2; i <= k / 2; i++) {
                dp[k] = Math.max(dp[k], dp[i] * dp[k - i]);
            }
        }
        return dp[n];
    }

    public int cuttingRope1(int n) {
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

    public int cuttingRope2(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        if (n == 4) return 4;
        long res = 1;
        while (n > 4) {
            res *= 3;
            res = res % 1000000007;
            n -= 3;
        }
        return (int) (res * n % 1000000007);
    }

    @Test
    public void test() {
        int count = cuttingRope1(10);
        System.out.println(count);
    }
}
