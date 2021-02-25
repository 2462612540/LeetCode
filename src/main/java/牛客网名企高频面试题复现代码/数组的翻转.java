package 牛客网名企高频面试题复现代码;

import org.junit.Test;

/**
 * @Classname 数组的翻转
 * @Description TODO
 * @Date 2020/12/9 18:54
 * @Created by xjl
 */
public class 数组的翻转 {

    public int[] roate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
        return nums;
    }

    /**
     * @description TODO 翻转数组
     * @param: nums
     * @date: 2020/12/9 18:55
     * @return: void
     * @author: xjl
     */
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

    @Test
    public void test() {
        int[] roate = roate(new int[]{1, 2, 3, 4, 5, 6}, 2);
        for (int i : roate) {
            System.out.print(i + " ");
        }
    }

}
