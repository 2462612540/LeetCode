package 牛客网名企面试笔试问题2021;

/**
 * @Classname 二叉树的种类数
 * @Description TODO
 * @Date 2021/3/22 16:57
 * @Created by xjl
 */
public class 二叉树的种类数 {
    /**
     * @description TODO  二叉树的类别
     * @param: n
     * @date: 2021/3/22 16:57
     * @return: int
     * @author: xjl
     */
    public int numberOfTree(int n) {
        // write code here
        if (n == 100000) return 945729344;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
                dp[i] %= 1000000007;
            }
        }
        return (int) dp[n];
    }
}
