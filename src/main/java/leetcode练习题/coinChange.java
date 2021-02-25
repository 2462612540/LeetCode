/**
 * Copyright (C), 2018-2020
 * FileName: coinChange
 * Author:   xjl
 * Date:     2020/4/1 8:51
 * Description: 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1  来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/coin-change 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package leetcode练习题;

import org.junit.Test;

public class coinChange {
    public int coinChange(int[] coins, int amount) {
        return coinChange(0, coins, amount);
    }

    private int coinChange(int idxCoin, int[] coins, int amount) {
        if (amount == 0)
            return 0;
        if (idxCoin < coins.length && amount > 0) {
            int maxVal = amount / coins[idxCoin];
            int minCost = Integer.MAX_VALUE;
            for (int x = 0; x <= maxVal; x++) {
                if (amount >= x * coins[idxCoin]) {
                    int res = coinChange(idxCoin + 1, coins, amount - x * coins[idxCoin]);
                    if (res != -1)
                        minCost = Math.min(minCost, res + x);
                }
            }
            return (minCost == Integer.MAX_VALUE) ? -1 : minCost;
        }
        return -1;
    }

    @Test
    public void test() {
        int[] conins = {1, 2, 5};
        int amount = 11;
        coinChange(conins, amount);
        System.out.println(coinChange(conins, amount));
    }
}
