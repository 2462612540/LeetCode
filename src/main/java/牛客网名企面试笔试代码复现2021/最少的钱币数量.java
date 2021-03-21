package 牛客网名企面试笔试代码复现2021;

import java.util.Arrays;

/**
 * @Classname 最少的钱币数量
 * @Description TODO
 * @Date 2021/2/27 10:15
 * @Created by xjl
 */
public class 最少的钱币数量 {

    public int minmoney(int[] arr, int aim) {
        if (aim == 0 || arr.length == 0 || arr == null) return 0;
        //表示的出新的钱币的数字
        int len = arr.length;
        int[] dp = new int[len + 1];
        dp[0] = 0;
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        for (int i = 1; i < aim; i++) {
            for (int j = 0; j < len; j++) {
                if (arr[j] <= i) {
                    dp[i] = Math.min(dp[i - arr[j]] + 1, dp[i]);
                }
            }
        }
        return dp[aim] == Integer.MAX_VALUE - 1 ? -1 : dp[aim];
    }
}
