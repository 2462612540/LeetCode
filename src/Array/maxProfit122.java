/**
 * Copyright (C), 2018-2020
 * FileName: maxProfit122
 * Author:   xjl
 * Date:     2020/6/30 10:36
 * Description: 122. 买卖股票的最佳时机 II
 */
package Array;

import org.junit.Test;

public class maxProfit122 {

    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int tmp = prices[i] - prices[i - 1];
            if (tmp > 0) {
                profit += tmp;
            }
        }
        return profit;
    }

    @Test
    public void test() {
        int[] array = {7, 6, 4, 3, 1};
        int i = maxProfit(array);
        System.out.println(i);

    }
}
