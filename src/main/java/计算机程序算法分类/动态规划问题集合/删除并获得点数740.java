package 计算机程序算法分类.动态规划问题集合;

import 牛客网练习题.Solution;

/**
 * @Classname 删除并获得点数740
 * @Description TODO  这个题目有点和打家劫舍的题目是类似的。但是的有一点不同
 * @Date 2021/5/5 15:06
 * @Created by xjl
 */
public class 删除并获得点数740 {

    public int deleteAndEarn(int[] nums) {
        int maxVal = 0;
        for (int val : nums) {
            maxVal = Math.max(maxVal, val);
        }
        int[] sum = new int[maxVal + 1];
        for (int val : nums) {
            sum[val] += val;
        }
        return rob(sum);
    }

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }
        return dp[nums.length - 1];
    }
}
