/**
 * Copyright (C), 2018-2020
 * FileName: maxProfit714
 * Author:   xjl
 * Date:     2020/6/30 10:53
 * Description: 714. 买卖股票的最佳时机含手续费
 */
package leetcode练习题;

public class maxProfit714 {
    public int maxProfit(int[] prices, int fee) {
        int cash = 0;
        int hold = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, cash - prices[i]);
        }
        return cash;
    }
}
