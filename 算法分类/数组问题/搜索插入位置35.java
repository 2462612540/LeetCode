/**
 * Copyright (C), 2018-2020
 * FileName: 搜索插入位置35
 * Author:   xjl
 * Date:     2020/11/2 16:34
 * Description:
 */
package 数组问题;

import org.junit.Test;

import java.util.Arrays;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 */
public class 搜索插入位置35 {
    /**
     * @param nums   也就是的二分查找的算法的实现  系统函数的作用就是
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int index = Arrays.binarySearch(nums, target);
        if (index >= 0) {
            return index;
        } else {
            return -1 * index - 1;
        }
    }

    public int searchInsert1(int[] nums, int target) {
        //最好的都是需要去检查一下是否为空
        if (nums.length == 0) {
            return 0;
        }
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            //这个是相当于的 int  mid=low+(high-low)/2;
            int mid = (low + high) >>> 1;
            if (nums[mid] < target)
                low = mid + 1;
            else if (nums[mid] > target)
                high = mid - 1;
            else
                return mid; // key found
        }
        //表示是当不存在的时候可能就需要的是的选择左边的下标
        return -(low + 1);
    }

    @Test
    public void test() {
        int i = searchInsert(new int[]{1}, 1);
        System.out.println(i);
    }

}
