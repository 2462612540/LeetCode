/**
 * Copyright (C), 2018-2020
 * FileName: maxSlidingWindow
 * Author:   xjl
 * Date:     2020/3/5 16:38
 * Description: 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 */
package work_tips;

import java.util.Arrays;

public class maxSlidingWindow {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return null;
        }
        int cout = 0;
        int[] n2 = new int[nums.length - k + 1];
        int[] n1 = new int[k];//用来存放滑动的窗口
        for (int i = 0; i < nums.length - k + 1; i++) {
            for (int j = 0; j < k; j++) {
                n1[j] = nums[i + j];
            }
            Arrays.sort(n1);
            n2[cout++] = n1[k - 1];
        }
        return n2;
    }

    public static void main(String[] args) {
        int[] numbers = {};
        int k = 0;
        int[] res = maxSlidingWindow(numbers, k);
        for (int va : res) {
            System.out.println(va);
        }
    }
}
