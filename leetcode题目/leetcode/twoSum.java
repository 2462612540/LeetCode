/**
 * Copyright (C), 2018-2020
 * FileName: twoSum
 * Author:   xjl
 * Date:     2020/3/5 15:18
 * Description: 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 */
package leetcode;

import java.util.*;

public class twoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]) && i != map.get(target - nums[i])) {
                return new int[]{nums[i], target - nums[i]};
            }
        }
        return null;
    }

    public static int[] twoSum2(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            if (nums[l] + nums[r] == target) return new int[]{nums[l], nums[r]};
            if (nums[l] + nums[r] > target) {
                r--;
            } else {
                l++;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums={2,7,11,15};
        int target=9;
        twoSum2(nums,9);
    }
}
