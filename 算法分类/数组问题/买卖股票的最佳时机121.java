/**
 * Copyright (C), 2018-2020
 * FileName: 买卖股票的最佳时机121
 * Author:   xjl
 * Date:     2020/11/2 16:36
 * Description:
 */
package 数组问题;

public class 买卖股票的最佳时机121 {

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
}
