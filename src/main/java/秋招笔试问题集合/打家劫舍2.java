/**
 * Copyright (C), 2018-2020
 * FileName: Main
 * Author:   xjl
 * Date:     2020/7/29 8:40
 * Description: 考试函数框架
 */
package 秋招笔试问题集合;

import java.util.Scanner;

public class 打家劫舍2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().trim().split(",");
        int[] array = new int[split.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.valueOf(split[i]);
        }
        int result = rob(array);
        System.out.println(result);
    }

    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //判断一个特殊的情况
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(subRob(nums, 0, nums.length - 1), subRob(nums, 1, nums.length));
    }

    public static int subRob(int[] nums, int start, int end) {
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
}
