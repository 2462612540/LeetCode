/**
 * Copyright (C), 2018-2020
 * FileName: searchRange
 * Author:   xjl
 * Date:     2020/3/27 20:56
 * Description: 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 */
package leetcode练习题;

import org.junit.Test;

public class searchRange {
    public int[] searchRange(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        int start = 0, end = 0;
        while (i <= j) {
            if (nums[i] != target) {
                i++;
            } else {
                start = 1;
            }
            if (nums[j] != target) {
                j--;
            } else {
                end = 1;
            }
            if (start == 1 && end == 1) {
                return new int[]{i, j};
            }
        }
        return new int[]{-1, -1};
    }

    @Test
    public void test() {
        int[] number = {5, 7, 7, 8, 5, 7, 9, 5, 6, 7, 7, 10};
        int target = 8;
        for (int val : searchRange(number, target)) {
            System.out.println(val);
        }

    }
}
