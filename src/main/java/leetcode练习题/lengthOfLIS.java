/**
 * Copyright (C), 2018-2020
 * FileName: lengthOfLIS
 * Author:   xjl
 * Date:     2020/3/30 8:57
 * Description: 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 */
package leetcode练习题;

import org.junit.Test;

import java.util.Arrays;

public class lengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    @Test
    public void test() {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(nums));
    }
}
