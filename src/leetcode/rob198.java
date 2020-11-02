/**
 * Copyright (C), 2018-2020
 * FileName: rob198
 * Author:   xjl
 * Date:     2020/7/7 9:19
 * Description: 198. 打家劫舍
 */
package leetcode;

import org.junit.Test;

public class rob198 {

    public int subRob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int frist = 0;
        int second = 0;
        int maxMoney = 0;
        for (int index = 0; index < nums.length; index++) {
            maxMoney = Math.max(nums[index] + frist, second);
            frist = second;
            second = maxMoney;
        }
        return maxMoney;
    }

    public int rob(int[] nums) {
        //输入数据的校验
        if (nums.length < 1) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        //
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        int max = Math.max(dp[0], dp[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = maxVal(dp, i - 1) + nums[i];
            max = max < dp[i] ? dp[i] : max;
        }
        return max;
    }

    private int maxVal(int[] dp, int i) {
        int max = -1;
        for (int j = 0; j < i; j++) {
            max = max < dp[j] ? dp[j] : max;
        }
        return max;
    }

    @Test
    public void test(){
        int[] array={1,2,3,1};
        int i = subRob(array);
        System.out.println(i);
    }

}
