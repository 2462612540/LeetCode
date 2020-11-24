/**
 * Copyright (C), 2018-2020
 * FileName: 非递减数列665
 * Author:   xjl
 * Date:     2020/11/17 10:17
 * Description:
 */
package 数组问题;

import org.junit.Test;

/**
 * 给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 * <p>
 * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
 */
public class 非递减数列665 {
    /**
     * 遍历依次就可以实现了
     *
     * @param nums
     * @return
     */
    public boolean checkPossibility(int[] nums) {
        int len = nums.length;
        if (len <= 2) return true;
        int low = 0;
        int high = len - 1;
        while (low < high) {
            while (low < high && nums[low] <= nums[low + 1]) low++;
            while (low < high && nums[high] >= nums[high - 1]) high--;
            return high - low <= 1 && (low == 0 || high == len - 1 || nums[high + 1] >= nums[high - 1] || nums[low + 1] >= nums[low - 1]);
        }
        return false;
    }

    @Test
    public void test() {
        boolean b = checkPossibility(new int[]{4, 2, 3});
        System.out.println(b);
    }
}
