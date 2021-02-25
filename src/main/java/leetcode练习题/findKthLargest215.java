/**
 * Copyright (C), 2018-2020
 * FileName: findKthLargest215
 * Author:   xjl
 * Date:     2020/6/29 8:40
 * Description: 215. 数组中的第K个最大元素
 */
package leetcode练习题;

import java.util.Arrays;

public class findKthLargest215 {
    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < k; i++) {
            res = nums[nums.length - i - 1];
        }
        return res;
    }

}

