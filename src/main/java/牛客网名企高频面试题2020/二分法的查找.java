package 牛客网名企高频面试题2020;

import org.junit.Test;

/**
 * @Classname 二分法的查找
 * @Description TODO
 * @Date 2020/12/10 16:00
 * @Created by xjl
 */
public class 二分法的查找 {
    /**
     * @description TODO 二分查找的元素返回的是位置的值
     * @param: nums
     * @date: 2020/12/10 16:01
     * @return: int
     * @author: xjl
     */
    public int bin(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (target == nums[mid]) {
                return mid + 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    @Test
    public void test() {
        int index = bin(new int[]{1, 2, 3, 4, 5, 6, 7}, 7);
        System.out.println(index);
    }
}
