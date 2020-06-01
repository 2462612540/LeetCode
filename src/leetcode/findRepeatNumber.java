/**
 * Copyright (C), 2018-2020
 * FileName: findRepeatNumber
 * Author:   xjl
 * Date:     2020/3/5 11:27
 * Description: 找出数组中重复的数字
 */
package leetcode;

import java.util.Arrays;

public class findRepeatNumber {
    public static int findRepeatNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return nums[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}
