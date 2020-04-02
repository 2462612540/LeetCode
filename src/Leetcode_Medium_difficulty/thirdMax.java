/**
 * Copyright (C), 2018-2020
 * FileName: thirdMax
 * Author:   xjl
 * Date:     2020/3/31 13:46
 * Description: 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
 */
package Leetcode_Medium_difficulty;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

public class thirdMax {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        Stack<Integer> stack = new Stack();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (!stack.contains(nums[i])) {
                stack.add(nums[i]);
            } else {
                continue;
            }
        }
        if (stack.size() < 3) {
            return stack.pop();
        }
        return stack.get(2);
    }

    @Test
    public void test() {
        int[] nums = {1, 1, 2, 3, 4, 4, 5, 5};
        System.out.println(thirdMax(nums));
    }
}
