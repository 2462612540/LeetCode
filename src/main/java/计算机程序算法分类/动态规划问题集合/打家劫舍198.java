package 计算机程序算法分类.动态规划问题集合;

import org.junit.Test;

/**
 * @Classname 打家劫舍198
 * @Description TODO
 * @Date 2021/5/5 21:19
 * @Created by xjl
 */
public class 打家劫舍198 {

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

    @Test
    public void test() {
        int[] arr = new int[]{2};
        int rob = rob(arr);
        System.out.println(rob);
    }
}
