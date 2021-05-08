package 计算机程序算法分类.动态规划问题集合;

import 秋招笔试问题集合.Main;

/**
 * @Classname 粉刷房子II
 * @Description TODO
 * @Date 2021/5/8 10:00
 * @Created by xjl
 */
public class 粉刷房子II {

    private int[][] memo;
    int levels, colors;

    public int minCostII(int[][] costs) {
        levels = costs.length;
        colors = levels == 0 ? 0 : costs[0].length;
        if (colors == 0) {
            return 0;
        }
        if (colors == 1) {
            return costs[0][0];
        }
        memo = new int[levels][colors];

        int res = Integer.MAX_VALUE;

        for (int i = 0; i < colors; i++) {
            res = Math.min(res, dp(costs, levels - 1, i));
        }
        return res;
    }

    //当前层的和以上的所有的花费
    private int dp(int[][] costs, int level, int color) {
        if (level < 0) {
            return 0;
        }
        if (memo[level][color] != 0) {
            return memo[level][color];
        }
        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < colors; i++) {
            if (i == color) {
                continue;
            }
            minCost = Math.min(minCost, costs[level][color] + dp(costs, level - 1, i));
        }
        memo[level][color] = minCost;
        return minCost;
    }
}
