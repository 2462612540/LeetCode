/**
 * Copyright (C), 2018-2020
 * FileName: 打劫2
 * Author:   xjl
 * Date:     2020/9/11 10:11
 * Description:
 */
package 计算机程序算法分类.动态规划问题集合;

import org.junit.Test;

import java.util.Arrays;

public class 打劫2 {
    /**
     * @description TODO 这里是围城一个圈来实现的偷东西
     * @param: nums
     * @date: 2021/4/16 9:00
     * @return: int
     * @author: xjl
     */
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        //因此要返回的是的第0个偷东西还是第1个开始偷东西的时候最大
        return Math.max(robnew(Arrays.copyOfRange(nums, 0, nums.length - 1)), robnew(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    public int robnew(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int[] dp = new int[length];
        dp[0] = nums[0];//只有一个时候只有偷才是最大的
        dp[1] = Math.max(nums[0], nums[1]);//两个的时候是需要比较是第一个还是第二才去偷
        for (int i = 2; i < length; i++) {
            //比较如果当前偷num[i]+空了前一个dp[i-2] 或者是不偷 那就是前一个dp[i-1]
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[length - 1];
    }



    @Test
    public void test() {
        int[] array = {0, 1, 2, 3, 4, 5, 6};
        int[] array2 = Arrays.copyOfRange(array, 0, array.length - 1);
        int[] array3 = Arrays.copyOfRange(array, 1, array.length);
        System.out.println(Arrays.toString(array2));
        System.out.println(Arrays.toString(array3));
    }
    // 子问题：
    // f(k) = 偷 [0..k) 房间中的最大金额
    // f(0) = 0
    // f(1) = nums[0]
    // f(k) = max{ rob(k-1), nums[k-1] + rob(k-2) }
    public int rob4(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int N = nums.length;
        //表示的是的最大的数字
        int[] dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int k = 2; k <= N; k++) {
            dp[k] = Math.max(dp[k - 1], nums[k - 1] + dp[k - 2]);
        }
        return dp[N];
    }

    int rob1(int[] nums) {
        int n = nums.length;
        // dp[i] = x 表示：
        // 从第 i 间房子开始抢劫，最多能抢到的钱为 x
        // base case: dp[n] = 0
        int[] dp = new int[n + 2];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], nums[i] + dp[i + 2]);
        }
        return dp[0];
    }

    int rob2(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[n];
    }
}
