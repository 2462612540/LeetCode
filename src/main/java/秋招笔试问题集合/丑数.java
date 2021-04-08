/**
 * Copyright (C), 2018-2020
 * FileName: 丑数
 * Author:   xjl
 * Date:     2020/9/9 21:07
 * Description:
 */
package 秋招笔试问题集合;

import java.util.Arrays;
import java.util.Scanner;

public class 丑数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().trim().split(",");
        int[] array = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            array[i] = Integer.valueOf(split[i]);
        }
        int res = rob2(array);
        System.out.println(res);
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
