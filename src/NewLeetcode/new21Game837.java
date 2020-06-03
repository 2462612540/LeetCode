/**
 * Copyright (C), 2018-2020
 * FileName: new21Game837
 * Author:   xjl
 * Date:     2020/6/3 8:48
 * Description: 837. 新21点
 */
package NewLeetcode;

import org.junit.Test;

/**
 * 涉及到的动态规划问题，这个题目还是不太懂
 */
public class new21Game837 {
    public double new21Game(int N, int K, int W) {
        Double[] dp = new Double[N + 1];
        double sum = 0;
        dp[0] = 1.0;
        if (K > 0) sum = 1;
        for (int i = 1; i <= N; i++) {
            dp[i] = sum / W;
            if (i < K) {
                sum += dp[i];
            }
            if (i >= W) {
                sum -= dp[i - W];
            }
        }
        double res = 0;
        for (int i = K; i <= N; i++) {
            res += dp[i];
        }
        return res;
    }

    public double new21Game2(int N, int K, int W) {

        return 0;
    }

    @Test
    public void test() {
        double v = new21Game(28, 17, 10);
        System.out.println(v);
    }
}
