/**
 * Copyright (C), 2018-2020
 * FileName: maxProfit63
 * Author:   xjl
 * Date:     2020/6/2 14:01
 * Description: 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 */
package NewLeetcode;

        import org.junit.Test;

public class maxProfit63 {
    public int maxProfit(int[] prices) {
        if (prices .length==0) return 0;
        int max = 0;
        int min = prices[0];
        for (int i = 0; i < prices.length; i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return max;
    }

    @Test
    public void test() {
        int[] array = {7, 1, 5, 3, 6, 4};
        int count = maxProfit(array);
        System.out.println(count);

    }
}
