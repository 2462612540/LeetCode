package 牛客网名企面试笔试问题2021;

/**
 * @Classname 背包问题01
 * @Description TODO
 * @Date 2021/2/27 10:45
 * @Created by xjl
 */
public class 背包问题01 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 计算01背包问题的结果
     *
     * @param V  int整型 背包的体积
     * @param n  int整型 物品的个数
     * @param vw int整型二维数组 第一维度为n,第二维度为2的二维数组,vw[i][0],vw[i][1]分别描述i+1个物品的vi,wi
     * @return int整型
     */
    public int knapsack(int V, int n, int[][] vw) {
        // write code here
        if (vw == null || vw.length == 0 || vw[0].length == 0) {
            return 0;
        }
        int[][] dp = new int[n + 1][V + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= V; j++) {
                //表示的不装下这样的一个物体
                if (vw[i - 1][0] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    //表示的是的装下当前的物体  dp[i - 1][j - vw[i - 1][0]]表示的是当前的一个的价值
                    dp[i][j] = Math.max(dp[i - 1][j], vw[i - 1][1] + dp[i - 1][j - vw[i - 1][0]]);
                }
            }
        }
        return dp[n][V];
    }
}
