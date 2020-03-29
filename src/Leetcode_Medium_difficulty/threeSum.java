/**
 * Copyright (C), 2018-2020
 * FileName: threeSum
 * Author:   xjl
 * Date:     2020/3/5 10:21
 * Description: 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组  来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/3sum 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package Leetcode_Medium_difficulty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1 排序
 * 2 判断最小的值是不是等于0
 * 3 左右去重
 * 4 左右加入数组中
 */
public class threeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
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

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        for (List<Integer> list : threeSum(nums)) {
            for (Integer i : list) {
                System.out.println(i);
            }
        }
        threeSum(nums);
    }
}
