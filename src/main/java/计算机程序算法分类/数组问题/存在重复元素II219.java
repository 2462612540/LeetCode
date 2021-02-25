/**
 * Copyright (C), 2018-2020
 * FileName: 存在重复元素II
 * Author:   xjl
 * Date:     2020/11/12 19:26
 * Description:
 */
package 计算机程序算法分类.数组问题;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值至多为k。
 */
public class 存在重复元素II219 {
    /**
     * 利用数组的来实现 这样的时间复杂为n^2
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length <= 0 || k <= 0) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == nums[i] && (j - i) <= k) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 采用的是的数组的遍历但是的要保证的是的下标是不能大于上面的
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        if (nums.length <= 0 || k <= 0) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            int index = 1;
            while (index <= k && (index + i) < nums.length) {
                if (nums[i] == nums[i + index++]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 用散列表来维护这个k大小的滑动窗口
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        if (nums.length <= 0 || k <= 0) {
            return false;
        }
        HashMap<Integer, Integer> res = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (res.containsKey(nums[i])) {
                // 如果包含：判断两个相同键值之间的长度 Key:nums[i] value:i
                if (i - res.get(nums[i]) <= k)
                    return true;
            }
            // 如果不包含。就存入键值对
            res.put(nums[i], i);
        }
        return false;
    }

    /**
     * 维护一个大小为k 的set的集合 保证在的set中的存在的相同的就返回true 如果大于k 删除的第一个 就是相当的那个鱼是维护一个k大小的数组
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate3(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    @Test
    public void test() {
        boolean b = containsNearbyDuplicate2(new int[]{1, 0, 1, 1}, 1);
        System.out.println(b);
    }
}
