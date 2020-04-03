/**
 * Copyright (C), 2018-2020
 * FileName: maxProfit
 * Author:   xjl
 * Date:     2020/4/3 11:09
 * Description: 面试题63. 股票的最大利润
 */
package Leetcode_Medium_difficulty;

import org.junit.Test;

public class maxProfit {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] <= min) {
                min = prices[i];
            }
            max = Math.max(prices[i] - min, max);
        }
        return max;
    }

    @Test
    public void tes() {
        int[] numbers = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(numbers));
    }
}
