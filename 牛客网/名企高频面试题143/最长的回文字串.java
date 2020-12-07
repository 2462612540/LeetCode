package 名企高频面试题143; /**
 * Copyright (C), 2018-2020
 * FileName: 名企高频面试题143.最长的回文字串
 * Author:   xjl
 * Date:     2020/10/12 9:52
 * Description:
 */

import org.junit.Test;

public class 最长的回文字串 {

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }

    @Test
    public void test() {
        String s = "ab12344321abc";
        int n = s.length();
        int res = longestPalindrome2(s);
        System.out.println(res);
    }

    /**
     * 暴力的解法：分别为求解的的是每一个字串 然后在判断是否为回文串
     *
     * @param s
     * @param n
     * @return
     */
    private int longestPalindrome1(String s, int n) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                String res = s.substring(i, j);
                if (test01(res)) {
                    max = max > res.length() ? max : res.length();
                }
            }
        }
        return max;
    }

    /**
     * 判断字符串是否为的回文串
     *
     * @param res
     * @return
     */
    private boolean test01(String res) {
        for (int i = 0; i < res.length() / 2; i++) {
            if (res.charAt(i) != res.charAt(res.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 使用的是的中心的扩散的算法
     *
     * @param s
     * @return
     */
    public int longestPalindrome2(String s) {
        String res = "";
        if (s.length() == 0) return 0;
        int max = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int odd = test02(s, i, i);
            int even = test02(s, i, i + 1);
            max = max > Math.max(odd, even) ? max : Math.max(odd, even);
        }
        return max;
    }

    private int test02(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }

    /**
     * 使用的是的动态的规划的
     *
     * @param s
     * @return
     */
    public String longestPalindrome3(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxlen = 1;
        int begin = 0;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        char[] charArray = s.toCharArray();
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = true;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }

                    //只要dp[i][j]=true成立的时候 就是表示的字串s[i……j]是回文
                    if (dp[i][j] && j - i + 1 > maxlen) {
                        maxlen = j - i + 1;
                        begin = i;
                    }
                }
            }
        }
        return s.substring(begin, begin + maxlen);
    }
}
