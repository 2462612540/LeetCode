/**
 * Copyright (C), 2018-2020
 * FileName: maxSubArray2
 * Author:   xjl
 * Date:     2020/4/2 13:22
 * Description: 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。  要求时间复杂度为O(n)。
 */
package leetcode练习题;

import org.junit.Test;

public class maxSubArray2 {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for(int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);
            continue;
        }

        return res;
    }

    @Test
    public void test() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        maxSubArray(nums);
    }
}
