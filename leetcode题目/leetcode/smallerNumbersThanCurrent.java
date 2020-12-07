/**
 * Copyright (C), 2018-2020
 * FileName: smallerNumbersThanCurrent
 * Author:   xjl
 * Date:     2020/3/5 9:10
 * Description: 给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目
 */
package leetcode;

public class smallerNumbersThanCurrent {
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] n = new int[nums.length];
        int cout = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    cout++;
                    n[i] = cout;
                }
            }
            cout = 0;
        }
        return n;
    }

    public static void main(String[] args) {
        int[] nums = {8,1,2,2,3};
        int[] res = smallerNumbersThanCurrent(nums);
        for (int key : res) {
            System.out.println(key);
        }
    }
}
