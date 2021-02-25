/**
 * Copyright (C), 2018-2020
 * FileName: removeDuplicates80
 * Author:   xjl
 * Date:     2020/6/26 22:34
 * Description:  删除排序数组中的重复项 II
 */
package leetcode练习题;

public class removeDuplicates80 {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                if (count < 2) {
                    count += 1;
                }
                if (count == 2) {
                    count = 1;
                }
            }
        }
        return 0;
    }
}
