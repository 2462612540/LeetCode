/**
 * Copyright (C), 2018-2020
 * FileName: find132pattern132
 * Author:   xjl
 * Date:     2020/6/12 10:11
 * Description: 给定一个整数序列：a1, a2, ..., an，一个132模式的子序列 ai, aj, ak 被定义为：当 i < j < k 时，ai < ak < aj。设计一个算法，当给定有 n 个数字的序列时，验证这个序列中是否含有132模式的子序列。
 */
package Array;

import org.junit.Test;

import java.util.Stack;

public class find132pattern132 {
    /**
     * 使用的是单调栈的方法来解决凸起问题
     *
     * @param nums
     * @return
     */
    public boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int three = Integer.MIN_VALUE;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < three) {
                return true;
            }
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                three = stack.peek();
                stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }

    @Test
    public void test() {
        int[] nums = {2, 4, 3, 1};
        boolean pattern = find132pattern(nums);
        System.out.println(pattern);

    }
}
