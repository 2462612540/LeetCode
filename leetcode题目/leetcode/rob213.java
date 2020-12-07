/**
 * Copyright (C), 2018-2020
 * FileName: rob213
 * Author:   xjl
 * Date:     2020/7/7 9:39
 * Description: 213. 打家劫舍 II
 */
package leetcode;

import org.junit.Test;

public class rob213 {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //判断一个特殊的情况
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(subRob(nums, 0, nums.length - 1), subRob(nums, 1, nums.length));
    }

    public int subRob(int[] nums, int start, int end) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int frist = 0;
        int second = 0;
        int maxMoney = 0;
        for (int index = start; index < end; index++) {
            maxMoney = Math.max(nums[index] + frist, second);
            frist = second;
            second = maxMoney;
        }
        return maxMoney;
    }

    @Test
    public void test(){
        int[] array={1,2,3,1};
        int rob = rob(array);
        System.out.println(rob);
    }
}
