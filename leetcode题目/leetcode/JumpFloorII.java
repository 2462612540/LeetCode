/**
 * Copyright (C), 2018-2020
 * FileName: JumpFloorII
 * Author:   xjl
 * Date:     2020/4/3 8:06
 * Description: 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
package leetcode;

import org.junit.Test;

public class JumpFloorII {

    public int JumpFloorII(int target) {
        if (target == 0) {
            return 0;
        }

        int[] dp = new int[target + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= target; i++) {
            dp[i] = 0;
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j];
            }
        }

        return dp[target];
    }

    @Test
    public void test() {
        System.out.println(JumpFloorII(5));
    }

}
