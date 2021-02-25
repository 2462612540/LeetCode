package 牛客网名企高频面试题143; /**
 * Copyright (C), 2018-2020
 * FileName: 名企高频面试题143.连续的子数组的最大和
 * Author:   xjl
 * Date:     2020/9/29 21:33
 * Description:
 */

import org.junit.Test;

public class 连续的子数组的最大和 {

    public int FindGreatestSumOfSubArray(int[] array) {
        int res = array[0];
        int[] dp = new int[array.length];
        dp[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            if (dp[i-1] >= 0) {
                dp[i] = dp[i - 1] + array[i];
            } else {
                dp[i] = array[i];
            }
            if (dp[i]>res){
                res=dp[i];
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[] array = {-2,-8,-1,-5,-9};
        int res = FindGreatestSumOfSubArray(array);
        System.out.println(res);
    }
}
