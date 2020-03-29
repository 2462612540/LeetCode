/**
 * Copyright (C), 2018-2020
 * FileName: maxProfit
 * Author:   xjl
 * Date:     2020/3/9 9:21
 * Description: 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。  如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。  注意你不能在买入股票前卖出股票。  来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package Leetcode_simple_difficulty;

import org.junit.Test;

import java.io.Serializable;

public class maxProfit implements Serializable {
    public int maxProfit(int[] prices) {
        int count = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] - prices[i] > count) {
                    count = prices[j] - prices[i];
                }
            }
        }
        return count;
    }

    /**
     * 最大的值和最小的值 且最大的值的下标》最小值的下标
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        if(prices.length <= 1)
            return 0;
        int min = prices[0], max = 0;
        for(int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - min);//获取max 和在prices[i]
            min = Math.min(min, prices[i]);
        }
        return max;
    }

    public int maxProfit3(int[] prices) {
        int count = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] - prices[i] > count) {
                    count = prices[j] - prices[i];

                }
            }
        }
        return count;
    }


    @Test
    public void test() {
        int[] numbers = {7,1,5,3,6,4};
        System.out.println(maxProfit3(numbers));
    }
}
