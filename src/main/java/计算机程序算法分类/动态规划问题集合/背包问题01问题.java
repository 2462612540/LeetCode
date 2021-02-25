/**
 * Copyright (C), 2018-2020
 * FileName: 背包问题01问题
 * Author:   xjl
 * Date:     2020/9/13 14:28
 * Description:
 */
package 计算机程序算法分类.动态规划问题集合;

import java.util.Arrays;

public class 背包问题01问题 {

    int[][] memo;

    /**
     * 01背包问题
     *
     * @param W
     * @param V
     * @param C
     * @return
     */
    public int Kapsack01(int[] W, int[] V, int C) {
        int n = W.length - 1;
        return bestValue(W, V, n, C);
    }

    /**
     * 表示的是的【0 ……index】的物品的填充的容积为C的背包的最大的价值
     *
     * @param w
     * @param v
     * @param index
     * @param c
     * @return
     */
    private int bestValue(int[] w, int[] v, int index, int c) {
        if (index < 0 || c <= 0) {
            return 0;
        }
        int res = bestValue(w, v, index - 1, c);
        if (c >= w[index]) {
            res = Math.max(res, v[index] + bestValue(w, v, index - 1, c - w[index]));
        }
        return res;
    }

    /**
     * 采用的是记忆化搜索的形式来实现
     *
     * @param W
     * @param V
     * @param C
     * @return
     */
    public int Kapsack02(int[] W, int[] V, int C) {
        int n = W.length - 1;
        memo = new int[n + 1][C + 1];
        Arrays.fill(memo, -1);
        return bestValue1(W, V, n, C);
    }

    /**
     * 表示的是的【0 ……index】的物品的填充的容积为C的背包的最大的价值
     * 采用个的是记忆化搜索的来实现的这样的一个效果
     *
     * @param w
     * @param v
     * @param index
     * @param c
     * @return
     */
    private int bestValue1(int[] w, int[] v, int index, int c) {
        if (index < 0 || c <= 0) {
            return 0;
        }
        if (memo[index][c] != -1) {
            return memo[index][c];
        }
        int res = bestValue1(w, v, index - 1, c);
        if (c >= w[index]) {
            Math.max(res, v[index] + bestValue1(w, v, index - 1, c - w[index]));
        }
        memo[index][c] = res;
        return res;
    }

    /**
     * @param W 表示的是物品的重量
     * @param V 价值
     * @param C 容量
     * @return
     */
    public int Kapsack03(int[] W, int[] V, int C) {
        int n = W.length - 1;
        if (n == 0 || C == 0) {
            return 0;
        }
        int[][] memo1 = new int[n + 1][C + 1];
        memo1[0][0] = 0;
        //看第0个元素的时候
        for (int i = 0; i <= C; i++) {
            memo1[0][i] = (i >= W[0] ? V[0] : 0);
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= C; j++) {
                memo1[i][j] = memo1[i - 1][j];
                if (j >= W[i]) {
                    memo1[i][j] = Math.max(memo1[i][j], V[i] + memo1[i - 1][j - W[i]]);
                }
            }
        }
        return memo1[n][C];
    }

    public int Kapsack04(int[] W, int[] V, int C) {
        int n = W.length - 1;
        if (n == 0 || C == 0) {
            return 0;
        }
        int[][] memo1 = new int[2][C + 1];
        memo1[0][0] = 0;
        //看第0个元素的时候
        for (int i = 0; i <= C; i++) {
            memo1[0][i] = (i >= W[0] ? V[0] : 0);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= C; j++) {
                memo1[i % 2][j] = memo1[(i - 1) % 2][j];
                if (j >= W[i]) {
                    memo1[i % 2][j] = Math.max(memo1[i % 2][j], V[i] + memo1[(i - 1) % 2][j - W[i]]);
                }
            }
        }
        return memo1[n % 2][C];
    }

    public int Kapsack05(int[] W, int[] V, int C) {
        int n = W.length - 1;
        if (n == 0 || C == 0) {
            return 0;
        }
        int[] memo1 = new int[C + 1];
        memo1[0] = 0;
        //看第0个元素的时候
        for (int i = 0; i <= C; i++) {
            memo1[i] = (i >= W[0] ? V[0] : 0);
        }
        for (int i = 1; i < n; i++) {
            for (int j = C; j >= W[i]; j--) {
                memo1[j] = Math.max(memo1[j], V[i] + memo1[j - W[i]]);
            }
        }
        return memo1[C];
    }
}
