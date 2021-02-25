/**
 * Copyright (C), 2018-2020
 * FileName: 最大子序列和53
 * Author:   xjl
 * Date:     2020/11/2 16:34
 * Description:
 */
package 计算机程序算法分类.数组问题;

import org.junit.Test;

public class 最大子序列和53 {
    /**
     * 采用的是一种的简单的动态规划的思想来实现的数组的保存的最大的和
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int[] array = new int[nums.length];
        array[0] = nums[0];
        int result = array[0];
        for (int i = 1; i < nums.length; i++) {
            if (array[i - 1] >= 0) {
                array[i] = array[i - 1] + nums[i];
            } else {
                array[i] = nums[i];
            }
            result = result > array[i] ? result : array[i];
        }
        return result;
    }

    @Test
    public void test(){
        int i = maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println(i);
    }
}
