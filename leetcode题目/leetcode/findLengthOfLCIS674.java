/**
 * Copyright (C), 2018-2020
 * FileName: findLengthOfLCIS674
 * Author:   xjl
 * Date:     2020/6/23 14:07
 * Description: 674. 最长连续递增序列
 */
package leetcode;

import org.junit.Test;

import java.util.Stack;

public class findLengthOfLCIS674 {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int result = 1;
        int length = 1;
        //遍历 一次比较大小
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                length++;
            } else {
                length = 1;
            }
            result = result >= length ? result : length;
        }
        return result;
    }

    public int findLengthOfLCIS2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        stack.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            if (stack.peek() < nums[i]) {
                //入栈
                stack.add(nums[i]);
            } else {
                //清空栈
                stack.clear();
                //添加新的元素
                stack.add(nums[i]);
            }
            //比较大小值
            result = result > stack.size() ? result : stack.size();
        }

        return result;
    }

    public int findLengthOfLCIS3(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = 1;
        int length = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                ++length;
            } else {
                length = 1;
            }
            max = length > max ? length : max;
        }
        return max;
    }

    @Test
    public void test() {
        int[] array = {2, 2, 2, 2, 2, 2, 2, 2, 2};
        int lengthOfLCIS = findLengthOfLCIS(array);
        System.out.println(lengthOfLCIS);
    }
}