/**
 * Copyright (C), 2018-2020
 * FileName: 删除数组重复元素26
 * Author:   xjl
 * Date:     2020/11/2 16:33
 * Description:
 */
package 计算机程序算法分类.数组问题;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 给定一个排序数组，你需要在原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * <p>
 * 如果是的才使用额外的空间的话 也是的采用的hashmap来实现的记录好个数
 */
public class 删除数组重复元素26 {
    /**
     * 这个是使用了的额外的空间实现的 set
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set.size();
    }

    /**
     * 不使用的其他的数据结构
     *
     * @param nums
     * @return
     */
    public int removeDuplicates2(int[] nums) {
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }

    @Test
    public void test1() {
        int i = removeDuplicates2(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
        System.out.println(i);
    }

    /**
     * 实现的返回数组具体的元素
     *
     * @param nums
     * @return
     */
    public int[] removeDuplicates1(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int[] result = new int[set.size()];
        int index = 0;
        for (int num : set) {
            result[index++] = num;
        }
        return result;
    }

    /**
     * 不使用其他的数据的内存的数据的
     *
     * @param nums
     * @return
     */
    public int[] removeDuplicates3(int[] nums) {
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[index++] = nums[i];
            }
        }
        return Arrays.copyOf(nums, 5);
    }
}
