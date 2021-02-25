/**
 * Copyright (C), 2018-2020
 * FileName: 三个数的最大乘积628
 * Author:   xjl
 * Date:     2020/11/16 21:18
 * Description:
 */
package 计算机程序算法分类.数组问题;

import org.junit.Test;

import java.util.Arrays;

public class 三个数的最大乘积628 {
    /**
     * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
     * <p>
     * 给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。
     * 输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。
     * 直接是利用的利用的有序的数组问题
     *
     * @param nums
     * @return
     */
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return nums[0] * nums[1] * nums[nums.length - 1] > nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3] ? nums[0] * nums[1] * nums[nums.length - 1] : nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
    }

    @Test
    public void test() {
        int res = maximumProduct(new int[]{-100, -98, -1, 2, 3, 4});
        System.out.println(res);
    }
}
