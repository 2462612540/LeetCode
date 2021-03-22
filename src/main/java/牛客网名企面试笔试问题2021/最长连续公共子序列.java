package 牛客网名企面试笔试问题2021;

/**
 * @Classname 最长公共子序列
 * @Description TODO
 * @Date 2021/3/22 15:26
 * @Created by xjl
 */
public class 最长连续公共子序列 {
    /**
     * @description TODO 最长的公共子序列
     * @param: s
     * @date: 2021/3/22 15:26
     * @return: int
     * @author: xjl
     */
    public int longestPalindromeSubSeq(String s) {
        int length = s.length();
        int[][] dp = new int[length][length];
        char[] chars = s.toCharArray();
        for (int i = 0; i < length; i++) {
            dp[i][i] = 1;
        }
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                if (chars[i] == chars[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }
        return dp[0][length - 1];
    }


    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 获取两个串字符
                char c1 = text1.charAt(i), c2 = text2.charAt(j);
                if (c1 == c2) {
                    // 去找它们前面各退一格的值加1即可
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    //要么是text1往前退一格，要么是text2往前退一格，两个的最大值
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[m][n];
    }

}
