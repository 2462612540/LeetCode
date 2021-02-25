/**
 * Copyright (C), 2018-2020
 * FileName: maxProfit121
 * Author:   xjl
 * Date:     2020/6/30 10:21
 * Description: 121. 买卖股票的最佳时机
 */
package leetcode练习题;

import org.junit.Test;

public class maxProfit121 {

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
    public void test() {
        int[] array = {7, 1, 5, 3, 6, 4};
        int i = maxProfit(array);
        System.out.println(i);
    }

}
