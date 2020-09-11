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
        return testrob(nums, 0);
    }

    /**
     * 考虑的是的nums[index…… nums.size（）]这个范围的所有的房子
     *
     * @param nums
     * @param index
     * @return
     */
    public static int testrob(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        }
        //开始抢劫这个房子以后的所有房子
        int res = 0;
        for (int i = index; i < nums.length; i++) {
            res = Math.max(res, nums[i] + testrob(nums, index + 2));
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
        return testrob2(nums, 0);
    }

    public static int testrob2(int[] nums, int index) {
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
            res = Math.max(res, nums[i] + testrob2(nums, i + 2));
        }
        //每一次将这个保留这个转态
        memo[index] = res;
        return res;
    }

    public static int rob2(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        int[] memo = new int[n];
        Arrays.fill(memo, -1);

        memo[n - 1] = nums[n - 1];
        //表示考虑抢劫 nums[i…… n-1]所能获得最大收益
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                memo[i] = Math.max(memo[i], nums[j] + (j + 2 < n ? memo[j + 2] : 0));
            }
        }
        return memo[0];
    }
}
