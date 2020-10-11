/**
 * Copyright (C), 2018-2020
 * FileName: 最长公共字串
 * Author:   xjl
 * Date:     2020/10/9 21:05
 * Description:
 */
package 牛客面试必会100题;

public class 最长公共字串 {

    /**
     * longest common substring
     *
     * @param str1 string字符串 the string
     * @param str2 string字符串 the string
     * @return string字符串
     */
    public String LCS(String str1, String str2) {
        if (str1 == null || str2 == null || str1.equals("") || str2.equals("")) {
            return "-1";
        }
        int indexMax = 0;
        int maxLen = 0;
        int m = str1.length();
        int n = str2.length();

        //dp[i][j]代表 str1[0~i-1]和str2[0~j-1] 的最长公共子串的长度
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                }//else 是str1[i]!=str2[j]的情况,这种情况下dp[i][j]=0,由于初始化已经将其设置为0,所以这里不再写。
                //处理完dp[i][j]之后,查看一下是否需要记录下来
                if (maxLen < dp[i][j]) {
                    maxLen = dp[i][j]; //记录下最长公共子串的长度
                    indexMax = i; //记录下出现“最长公共子串”时的末尾字符的位置
                }
            }
        }
        if (maxLen == 0) {
            return "-1";
        }
        //字符串截取的长度有(end-start+1) = maxLen, 那么start = indexMax +1-maxLen
        // maxLen即为所截取的字符串的长度。
        return str1.substring(indexMax - maxLen + 1, indexMax + 1);
    }
}
