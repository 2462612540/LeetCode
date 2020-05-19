/**
 * Copyright (C), 2018-2020
 * FileName: fourSum
 * Author:   xjl
 * Date:     2020/3/20 16:10
 * Description: 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 */
package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class fourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList();
        //第一步将数据排序
        Arrays.sort(nums);
        //遍历第一个数据
        for (int i = 0; i < nums.length-4; i++) {
            if (nums[i] > target) {
                break;
            }
            //接来进线三个数的和求解
            int retarget = target - nums[i];
            for (int j = i + 1; j < nums.length-3; j++) {
                //定义两个指针
                int start = j+1;
                int end = nums.length - 1;
                while (start < end) {
                    if (nums[j] + nums[start] + nums[end] == retarget) {
                        result.add(Arrays.asList(nums[i], nums[start], nums[end], nums[j]));
                        // 左边去重
                        while (start < end && nums[start] == nums[start + 1]) start++;
                        // 右边去重
                        while (start < end && nums[end] == nums[end - 1]) end--;
                        start++;
                        end--;
                    }
                    if (nums[j] + nums[start] + nums[end] > retarget) {
                        end--;
                    }
                    if (nums[j] + nums[start] + nums[end] < retarget) {
                        start--;
                    }
                }
            }
        }
        return result;
    }

    @Test
    public void test() {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        for (List<Integer> list :fourSum(nums, target)) {
            for (Integer i : list) {
                System.out.println(i);
            }
        }
    }
}
