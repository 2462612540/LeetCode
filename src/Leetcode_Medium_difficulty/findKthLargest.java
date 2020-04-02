/**
 * Copyright (C), 2018-2020
 * FileName: findKthLargest
 * Author:   xjl
 * Date:     2020/3/31 13:27
 * Description: 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 */
package Leetcode_Medium_difficulty;

import org.junit.Test;

import java.util.Arrays;

public class findKthLargest {
    public int findKthLargest(int[] nums, int k) {
        if (nums.length==0){return 0;}
        Arrays.sort(nums);
        int res=0;
        for (int i = 0; i < k; i++) {
            res=nums[nums.length-i-1];
        }
        return res;
    }

    @Test
    public void test() {
        int[] numbers = {3,2,1,5,6,4};
        System.out.println(findKthLargest(numbers, 2));
    }
}
