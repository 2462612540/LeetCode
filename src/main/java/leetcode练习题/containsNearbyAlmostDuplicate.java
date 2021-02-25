/**
 * Copyright (C), 2018-2020
 * FileName: containsNearbyAlmostDuplicate
 * Author:   xjl
 * Date:     2020/3/3 14:42
 * Description: 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。
 */
package leetcode练习题;

public class containsNearbyAlmostDuplicate {
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((Math.abs((double) (nums[j] - nums[i])) <= t) && (j-i)<=k) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums={2147483647,-2147483647};
        int k=1;
        int t=2147483647;
        System.out.println(containsNearbyAlmostDuplicate(nums,k,t));
    }
}
