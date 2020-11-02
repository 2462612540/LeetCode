/**
 * Copyright (C), 2018-2020
 * FileName: 移除元素27
 * Author:   xjl
 * Date:     2020/11/2 16:34
 * Description:
 */
package 数组问题;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class 移除元素27 {
    /**
     * 统计好了这个空间
     *
     * @param nums
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                count++;
            }
        }
        return count;
    }

    /**
     * 使用了额外的内存空间
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement2(int[] nums, int val) {
        ArrayList<Integer> list = new ArrayList<>();
        //或者采用的Arraylist
        for (int num : nums) {
            if (num != val) {
                list.add(num);
            }
        }
        return list.size();
    }

    /**
     * 采用的不使用其他的空间的方法
     *
     * @param nums
     * @param val
     * @return
     */
    public int[] removeElement3(int[] nums, int val) {
        if (nums.length == 0) {
            return null;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                //找到这个后面的第一个不是val的值并进行交换
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != val) {
                        int tmp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = tmp;
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                return Arrays.copyOf(nums, i);
            }
        }
        return nums;
    }

    /**
     * 使用的是的双指针的方法
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement4(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                //找到这个后面的第一个不是val的值并进行交换
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != val) {
                        int tmp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = tmp;
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                return Arrays.copyOf(nums, i).length;
            }
        }
        return nums.length;
    }

    /**
     * 这个也是采用的是双指针的方法来实现移动元素的
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement5(int[] nums, int val) {
        int index = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[index++] = nums[j];
            }
        }
        return index;
    }

    @Test
    public void test() {
        int res = removeElement5(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2);
        System.out.println(res);
    }
}
