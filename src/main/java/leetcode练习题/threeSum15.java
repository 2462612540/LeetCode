/**
 * Copyright (C), 2018-2020
 * FileName: threeSum15
 * Author:   xjl
 * Date:     2020/6/12 9:39
 * Description: 三个数的和
 */
package leetcode练习题;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSum15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        int len = nums.length;
        if (nums == null || len < 3) return result;
        // 排序
        Arrays.sort(nums);
        //遍历第一个数据
        for (int i = 0; i < len; i++) {
            // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if (nums[i] > 0) break;
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            //制定两个指针
            int L = i + 1;
            int R = len - 1;
            //如果是左边的指针小于就表示可以进行
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    //添加进入list中
                    result.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    // 左边去重
                    while (L < R && nums[L] == nums[L + 1]) L++;
                    // 右边去重
                    while (L < R && nums[R] == nums[R - 1]) R--;
                    L++;
                    R--;
                } else if (sum < 0) L++;
                else if (sum > 0) R--;
            }
        }
        return result;
    }

    @Test
    public void test() {

        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(nums);

    }
}
