package 牛客网名企高频面试题143;

/**
 * Copyright (C), 2018-2020
 * FileName: 名企高频面试题143.做好的股票时机
 * Author:   xjl
 * Date:     2020/9/29 8:30
 * Description:
 */


public class 做好的股票时机 {

    public static void main(String[] args) {
        int i = maxProfit(new int[]{7, 6, 4,3,1});
        System.out.println(i);
    }

    public static int maxProfit(int[] prices) {
        if (prices.length==0)return 0;
        int res = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > min) {
                res = Math.max(res, prices[i] - min);
            }else {
                min=prices[i];
            }
        }
        return res;
    }
}
