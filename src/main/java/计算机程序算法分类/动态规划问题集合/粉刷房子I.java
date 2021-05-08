package 计算机程序算法分类.动态规划问题集合;

/**
 * @Classname 粉刷房子
 * @Description TODO
 * @Date 2021/5/8 9:59
 * @Created by xjl
 */
public class 粉刷房子I {

    private int[][] memo;

    public int minCost(int[][] costs) {
        int n = costs.length;
        if (n == 0) {
            return 0;
        }
        //标记的有多少种的颜色
        int colors = costs[0].length;
        memo = new int[n][3];

        return Math.min(Math.min(
                dp(costs, costs.length - 1, 0),
                dp(costs, costs.length - 1, 1)),
                dp(costs, costs.length - 1, 2));
    }

    /**
     * @description TODO 计算是的在制定的层拿到的最小的花费
     * @param: costs
     * @param: level
     * @param: color
     * @date: 2021/5/8 10:23
     * @return: int
     * @author: xjl
     */
    private int dp(int[][] costs, int level, int color) {
        //递归的出口
        if (level < 0) {
            return 0;
        }
        if (memo[level][color] != 0) {
            return memo[level][color];
        }
        memo[level][color] = costs[level][color] + Math.min(dp(costs, level - 1, (color + 1) % 3), dp(costs, level - 1, (color + 2) % 3));
        level--;
        return memo[level + 1][color];
    }
}
