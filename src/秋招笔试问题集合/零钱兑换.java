/**
 * Copyright (C), 2018-2020
 * FileName: Main
 * Author:   xjl
 * Date:     2020/7/29 8:40
 * Description: 考试函数框架
 */
package 秋招笔试问题集合;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class 零钱兑换 {
    static class ListNode {
        Character val;
        ListNode next;

        public ListNode(Character val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 5, 11, 12};
        int[] res = test12(array);
        for (int i : res) {
            System.out.println(i);
        }
    }

    private static int[] test12(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int j = 0; j < nums.length; j++) {
            boolean flag = true;
            for (int i = 2; i <= nums[j] / 2; i++) {
                if (nums[j] % i == 0)
                    flag = false;
            }
            if (flag == true) {
                list.add(nums[j]);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static int coinChange(int[] cars, int num) {
        int max = num + 1;
        int[] dp = new int[num + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= num; i++) {
            for (int j = 0; j < cars.length; j++) {
                if (cars[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - cars[j]] + 1);
                }
            }
        }
        return dp[num] > num ? -1 : dp[num];
    }

    @Test
    public void test() {
        int[] conis = {1, 2, 5};
        int amount = 11;
        int ans = coinChange(conis, amount);
        System.out.println(ans);
    }


}
