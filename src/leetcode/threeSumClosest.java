/**
 * Copyright (C), 2018-2020
 * FileName: threeSumClosest
 * Author:   xjl
 * Date:     2020/3/20 11:02
 * Description: 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 */
package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class threeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        //利用map进行存储距离和总和的值
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                for (int k = j; k < nums.length; k++) {
                    if (i != j && j != k && i != k) {
                        map.put(Math.abs(nums[i] + nums[j] + nums[k] - target), nums[i] + nums[j] + nums[k]);
                    }
                }
            }
        }
        Set<Integer> set = map.keySet();
        Object[] obj = set.toArray();
        Arrays.sort(obj);
        return map.get(obj[0]);
    }

    public static int threeSumClosest2(int[] nums, int target) {
        //排序
        Arrays.sort(nums);
        //顶一个初始的值
        int ans = nums[0] + nums[1] + nums[2];
        // 指针遍历
        for (int i = 0; i < nums.length; i++) {
            //定义好两个指针
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int sum = nums[start] + nums[end] + nums[i];
                if (Math.abs(target - sum) < Math.abs(target - ans))
                    ans = sum;
                //指针开始回退
                if (sum > target)
                    end--;
                else if (sum < target)
                    start++;
                else
                    return ans;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 0};
        int target = 1;
        System.out.println(threeSumClosest(nums, target));
    }
}
