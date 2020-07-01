/**
 * Copyright (C), 2018-2020
 * FileName: maxProfit63
 * Author:   xjl
 * Date:     2020/6/30 10:29
 * Description: 剑指 Offer 63. 股票的最大利润
 */
package Array;

public class maxProfit63 {

    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int max = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return max;
    }

    public int maxProfit2(int[] prices) {
        if (prices.length == 0) return 0;

        int max = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            max = Math.max(prices[i] - min, max);
        }
        return max;
    }

}
