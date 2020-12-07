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
     * 若至多改变一个元素能将原数组调整有序，当只有一处失序存在时必定有high = low + 1,当数组完全符合非递减时high = low,因此high-low<=1是命题的必要条件。
     * 另一方面如图所示，当失序的时候有两种调整方案：
     * 1.改变位置low,使得nums[low-1]≤nums[low]≤nums[low+1];
     * 2.改变位置high,使得nums[high-1]≤nums[high]≤nums[high+1];
     * 采用方案1前提条件为nums[low+1]>=nums[low-1],采用方案2前提条件为nums[high+1]>=nums[high-1]。
     * 再考虑两种端点情况，即在最开始和最结尾失序，low=0或者high=len-1时，一定可以调整。最终代码如下：
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
