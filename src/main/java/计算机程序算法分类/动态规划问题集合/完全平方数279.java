/**
 * Copyright (C), 2018-2020
 * FileName: 完全平方数279
 * Author:   xjl
 * Date:     2020/9/8 10:50
 * Description: 完全平方数
 */
package 计算机程序算法分类.动态规划问题集合;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 完全平方数279 {
    /**
     * 动态转移方程为：dp[i] = MIN(dp[i], dp[i - j * j] + 1)，i表示当前数字，j*j表示平方数
     *
     * @param n
     * @return
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; i + j * j <= n; j++) {
                if (dp[i] + 1 < dp[i + j * j]) {
                    dp[i + j * j] = dp[i] + 1;
                }
            }
        }
        return dp[n];
    }

    public int numSquares1(int n) {
        int[] dp = new int[n + 1]; // 默认初始化值都为0
        for (int i = 1; i <= n; i++) {
            dp[i] = i; // 最坏的情况就是每次+1 就是采用的是的全部是1的这样的方式
            for (int j = 1; i - j * j >= 0; j++) {
                //每次去看这个j表示的是的平方数 一定是小于这i的
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1); // 动态转移方程
            }
        }
        return dp[n];
    }

    @Test
    public void test() {
        int i = numSquares1(5);
        System.out.println(i);
    }

    public int numSquares3(int n) {
        ArrayList<Integer> square_nums = new ArrayList<Integer>();
        for (int i = 1; i * i <= n; ++i) {
            square_nums.add(i * i);
        }
        Set<Integer> queue = new HashSet<Integer>();
        queue.add(n);
        int level = 0;
        while (queue.size() > 0) {
            level += 1;
            Set<Integer> next_queue = new HashSet<Integer>();

            for (Integer remainder : queue) {
                for (Integer square : square_nums) {
                    if (remainder.equals(square)) {
                        return level;
                    } else if (remainder < square) {
                        break;
                    } else {
                        next_queue.add(remainder - square);
                    }
                }
            }
            queue = next_queue;
        }
        return level;
    }
}
