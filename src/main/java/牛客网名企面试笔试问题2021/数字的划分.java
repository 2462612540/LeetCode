package 牛客网名企面试笔试问题2021;

import org.junit.Test;

/**
 * @Classname 数字的划分
 * @Description TODO
 * @Date 2021/3/8 10:06
 * @Created by xjl
 */
public class 数字的划分 {

    public int divideNumber(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (i >= j) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - j][j];
                }
            }
        }
        return dp[n][k];
    }

    private int ans = 0;
    /**
     * @description TODO 同时比较认同的是的采用的是的dfs的方法
     * @param: n
     * @param: k
     * @date: 2021/3/8 10:41
     * @return: int
     * @author: xjl
    */
    public int divideNumber2(int n, int k) {
        dfs(1, n, k);
        return ans;
    }

    private void dfs(int i, int n, int k) {
        if (n < i) return;
        if (k == 1) {
            System.out.println(i+" "+" "+n+" "+k);
            ans++;
            return;
        }
        while (i <= n) {
            dfs(i, n - i, k - 1);
            i++;
        }
    }


    @Test
    public void test(){
        divideNumber2(7,3);
    }
}
