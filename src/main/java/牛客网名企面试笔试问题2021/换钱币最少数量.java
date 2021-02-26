package 牛客网名企面试笔试问题2021;

import java.util.Arrays;

/**
 * @Classname 换钱币最少数量
 * @Description TODO
 * @Date 2021/2/26 12:55
 * @Created by xjl
 */
public class 换钱币最少数量 {
    /**
     * @description TODO 给定数组arr，arr中所有的值都为正整数且不重复。每个值代表一种面值的货币，每种面值的货币可以使用任意张，再给定一个aim，代表要找的钱数，求组成aim的最少货币数。
     * @param: arr
     * @param: aim
     * @date: 2021/2/26 12:56
     * @return: int
     * @author: xjl
     * <p>
     * 嘉定的给定的钱币为i 那么他的换币方案是的有两个方案组成： i 表示的是的钱  ——————1是没有办法兑换货币 dp[i]=dp[i] 2 可是换 dp[i]=dp[i-arr[i]]+1
     */
    public int minMoney(int[] arr, int aim) {
        int len = arr.length;
        int[] dp = new int[aim + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;
        //遍历的是全部的钱
        for (int i = 1; i <= aim; ++i) {
            //遍历原始的铅笔的数字
            for (int j = 0; j < len; ++j) {
                int coin = arr[j];
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                }
            }
        }
        return dp[aim] == Integer.MAX_VALUE - 1 ? -1 : dp[aim];
    }

    public int minMoney2(int[] arr, int aim) {
        int len = arr.length;
        int[] dp = new int[aim + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        //表示的可以换的钱的张数量
        dp[0] = 0;
        //遍历的是全部的钱可能出现的钱
        for (int i = 1; i <= aim; ++i) {
            //遍历原始的钱币的数字
            for (int j = 0; j < len; ++j) {
                //表示的可以兑换
                if (arr[j] <= i) {
                    dp[i] = Math.min(dp[i - arr[j]] + 1, dp[i]);
                }
            }
        }
        //返回最后一个的数值的解的情况
        return dp[aim] == Integer.MAX_VALUE - 1 ? -1 : dp[aim];
    }
}
