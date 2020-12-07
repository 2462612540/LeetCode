/**
 * Copyright (C), 2018-2020
 * FileName: productExceptSelf238
 * Author:   xjl
 * Date:     2020/6/4 8:23
 * Description: 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 */
package leetcode;

import org.junit.Test;

public class productExceptSelf238 {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int sum = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    sum *= nums[j];
                }
            }
            result[i] = sum;
            sum = 1;
        }
        return result;
    }

    //改进版本的时间为哦o(n)的结果
    public int[] productExceptSelf1(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = 1;
        }
        int pre = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = result[i] * pre;
            pre = pre * nums[i];
        }
        pre = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] = result[i] * pre;
            pre = pre * nums[i];
        }
        return result;
    }

    @Test
    public void test() {
        int[] array = {1, 2, 3, 4};
        int[] ints = productExceptSelf1(array);
        for (int v : ints) {
            System.out.println(v);
        }
    }
}
