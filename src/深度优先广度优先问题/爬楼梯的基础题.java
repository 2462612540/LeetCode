/**
 * Copyright (C), 2018-2020
 * FileName: 爬楼梯的基础题
 * Author:   xjl
 * Date:     2020/9/7 9:39
 * Description:
 */
package 深度优先广度优先问题;

public class 爬楼梯的基础题 {
    /**
     * 使用的递归的方法 使用的是暴力的求解
     *
     * @param n
     * @return
     */
    public int climbstairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        return climbstairs(n - 1) + climbstairs(n - 2);
    }

    /**
     * 记忆化递归的思想
     *
     * @param n
     * @return
     */
    public int solution(int n) {
        //这个是记忆的数组 记录是的每一个台阶的方法
        int[] memeo = new int[n + 1];
        return climbstairs1(n, memeo);
    }

    private int climbstairs1(int n, int[] memeo) {
        if (memeo[n] > 0) {
            return memeo[n];
        }
        if (n == 1 || n == 2) {
            memeo[n] = n;
        } else {
            memeo[n] = climbstairs1(n - 1, memeo) + climbstairs1(n - 2, memeo);
        }
        return memeo[n];
    }

    /**
     * 使用动态规划的思想
     *
     * @param n
     * @return
     */
    public int solution1(int n) {
        if (n == 1) {
            return 1;
        }
        //表示的是的dp[]的转态 表示的有多少种方法
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            //使用的是的dp[i]=dp[i-1]+dp[i-2];
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 递归函数
     *
     * @param n
     * @return
     */
    public int test(int n) {
        return calway(n);
    }

    private int calway(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        return calway(n - 1) + calway(n - 2);
    }
}
