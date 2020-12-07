/**
 * Copyright (C), 2018-2020
 * FileName: 丢失棋子问题
 * Author:   xjl
 * Date:     2020/10/5 19:58
 * Description:
 */
package 牛客面试必会100题;

import org.junit.Test;

public class 丢失棋子问题 {

    @Test
    public void test() {
        int ans = solutionOne(3, 2);
        System.out.println(ans);
    }

    /**
     * 设P(N,K)的返回值时N层楼时有K个棋子在最差的情况下仍的最少次数。
     * <p>
     * 如果N==0，棋子在第0层肯定不会碎，所以P(0, K) = 0;
     * 如果K==1，楼层有N层，只有1个棋子，故只能从第一次开始尝试，P(N,1)=N;
     * 对于N>0且K>1, 我们需考虑第1个棋子是从那层开始仍的。如果第1个棋子从第i层开始仍，那么有以下两种情况:
     * (1) 碎了。没必要尝试第i层以上的楼层了，接下来的问题就变成了剩下i-1层楼和K-1个棋子，所以总步数为 1+P(i-1, K-1);
     * (2)没碎。 那么可以知道没必要尝试第i层及其以下的楼层了，接下来的问题就变成了还剩下N-i层和K个棋子，所以总步数为 1+P(N-i, K).
     * 根据题意应该选取(1)和(2)中较差的那种情况，即 max{ P(i-1, K-1), P(N-i, K)}+1。 由于i的取值范围是 1到N, 那么步数最少的情况为， P(N, K)=min{ max{P(i-1, K-1), P(N-i, K)}(1<=i<=N) }+1。
     *
     * @param N
     * @param K
     * @return
     */
    public int solutionOne(int N, int K) {
        if (N < 1 || K < 1)
            return 0;
        return helper1(N, K);
    }

    private int helper1(int N, int K) {
        if (N == 0) return 0;
        if (K == 1) return N;

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= N; ++i) {
            min = Math.min(min, Math.max(helper1(i - 1, K - 1), helper1(N - i, K)));
        }
        return min+1;
    }

    /**
     * 通过研究以上递归函数发现， P(N, K)过程依赖于P(0...N-1, K-1) 和 P(0...N-1, K)。所以，若把所有的递归的返回值看作是一个二维数组，可以用动态规划的方法优化递归过程。从而减少计算量。
     * dp[0][K] = 0,
     * dp[N][1] = N,
     * dp[N][K] = min( max(dp[i-1][K-1], dp[N-i][K])) + 1。
     */

    public int solutionTwo(int N, int K) {
        if (N < 1 || K < 1)
            return 0;
        if (K == 1)
            return N;
        int[][] dp = new int[N + 1][K + 1];
        for (int i = 1; i < dp.length; ++i) {
            dp[i][1] = i;
        }
        for (int i = 1; i < dp.length; ++i) {
            for (int j = 2; j <= K; ++j) {
                int min = Integer.MAX_VALUE;
                for (int k = 1; k < i + 1; ++k) {
                    min = Math.min(min, Math.max(dp[k - 1][j - 1], dp[i - k][j]));
                }
                dp[i][j] = min+1 ;
            }
        }
        return dp[N][K];
    }

    public int solutionFive(int N, int K) {
        if (N < 1 || K < 1)
            return 0;
        int bsTimes = log2N(N) + 1;
        if (K >= bsTimes) {
            return bsTimes;
        }
        int[] dp = new int[K];
        int res = 0;
        while (true) {
            ++res;
            int previous = 0;
            for (int i = 0; i < dp.length; ++i) {
                int tmp = dp[i];
                dp[i] = dp[i] + previous + 1;
                previous = tmp;
                if (dp[i] >= N) {
                    return res;
                }
            }
        }
    }

    private int log2N(int N) {
        return (int) (Math.log(N) / Math.log(2));
    }
}
