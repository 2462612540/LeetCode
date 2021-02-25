/**
 * Copyright (C), 2018-2020
 * FileName: 环形连续数组最大和
 * Author:   xjl
 * Date:     2020/10/11 13:56
 * Description:
 */
package 计算机程序算法分类.动态规划问题集合;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class 环形连续数组最大和 {

    @Test
    public void test() {
        int res = maxSubarraySumCircular(new int[]{3, -2, 4, -1});
        System.out.println(res);
    }

    public int maxSubarraySumCircular(int[] A) {
        int N = A.length;
        int[] P = new int[2 * N + 1];

        for (int i = 0; i < 2 * N; ++i)
            P[i + 1] = P[i] + A[i % N];

        int ans = A[0];
        Deque<Integer> deque = new ArrayDeque();
        deque.offer(0);
        for (int j = 1; j <= 2 * N; ++j) {
            if (deque.peekFirst() < j - N)
                deque.pollFirst();
            ans = Math.max(ans, P[j] - P[deque.peekFirst()]);
            while (!deque.isEmpty() && P[j] <= P[deque.peekLast()])
                deque.pollLast();
            deque.offerLast(j);
        }
        return ans;
    }

}
