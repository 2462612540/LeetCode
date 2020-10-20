/**
 * Copyright (C), 2018-2020
 * FileName: 数组的中最长的连续子序列
 * Author:   xjl
 * Date:     2020/10/14 9:24
 * Description:
 */
package 牛客面试必会100题;

import org.junit.Test;

import java.util.Arrays;

public class 数组的中最长的连续子序列 {

    @Test
    public void test() {
        int res = MLS(new int[]{100, 4, 200, 1, 3, 2});
        System.out.println(res);
    }

    public int MLS(int[] arr) {
        //重新排列数组
        Arrays.sort(arr);

        //利用动态规划的
        int[] dp = new int[arr.length];
        Arrays.fill(dp, 1);
        int max = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] == arr[j - 1] + 1) {
                    dp[i] = dp[j - 1] + 1;
                    break;
                }else {
                    break;
                }
            }
            max = max > dp[i] ? max : dp[i];
        }
        return max;
    }
}
