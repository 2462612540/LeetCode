package 牛客网名企高频面试题2020; /**
 * Copyright (C), 2018-2020
 * FileName: 数组的最大和
 * Author:   xjl
 * Date:     2020/9/24 9:18
 * Description:
 */

import org.junit.Test;

public class 连续数组的最大和 {
    /**
     * 利用的是子数组的问题
     *
     * @param arr
     * @return
     */
    public int maxsumofSubarray(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        int max = arr[0];
        for (int i = 1; i < dp.length; i++) {
            if (dp[i - 1] < 0) {
                dp[i] = arr[i];
            } else {
                dp[i] = arr[i] + dp[i - 1];
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    @Test
    public void test() {
        int[] arr = {1, -2, 3, 5, -2, 6, -1};
        int res = maxsumofSubarray(arr);
        System.out.println(res);
    }
}
