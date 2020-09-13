/**
 * Copyright (C), 2018-2020
 * FileName: 打劫1
 * Author:   xjl
 * Date:     2020/9/8 15:58
 * Description:
 */
package 动态规划问题集合;

import java.util.Arrays;

public class 打劫1 {
    public static int rob(int[] nums) {
        return rob(nums, 0);
    }

    /**
     * 考虑的是的nums[index…… nums.size（）]这个范围的所有的房子
     *
     * @param nums
     * @param index
     * @return
     */
    public static int rob(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }
        //开始抢劫这个房子以后的所有房子
        int res = 0;
        for (int i = index; i < nums.length; i++) {
            res = Math.max(res, nums[i] + rob(nums, index + 2));
        }
        return res;
    }

    /**
     * 采用的是记忆化搜索的方法来实现
     *
     * @param nums
     * @param index
     * @return
     */
    static int[] memo;

    public static int rob1(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return rob3(nums, 0);
    }

    public static int rob3(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }
        //判断时候有值 如果有值就不需要计算了  如果是没有就需要的是的计算
        if (memo[index] != -1) {
            return memo[index];
        }
        //开始抢劫这个房子以后的所有房子
        int res = 0;
        for (int i = index; i < nums.length; i++) {
            res = Math.max(res, nums[i] + rob3(nums, i + 2));
        }
        //每一次将这个保留这个转态
        memo[index] = res;
        return res;
    }

    /**
     * 动态规划的想法
     *
     * @param nums
     * @return
     */
    public static int rob2(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        //基础的问题 最后的一个房子是偷他。
        memo[n - 1] = nums[n - 1];
        //表示考虑抢劫 nums[i…… n-1]所能获得最大收益
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                memo[i] = Math.max(memo[i], nums[j] + (j + 2 < n ? memo[j + 2] : 0));
            }
        }
        return memo[0];
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
}
