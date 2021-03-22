package 牛客网名企面试笔试问题2021;

import org.junit.Test;
import 牛客网练习题.Solution;

/**
 * @Classname 最长回文子串
 * @Description TODO
 * @Date 2021/3/22 14:54
 * @Created by xjl
 */
public class 最长连续回文子串 {
    /**
     * @description TODO  采用的是的中心扩展方法
     * @param: s
     * @date: 2021/3/22 15:41
     * @return: java.lang.String
     * @author: xjl
    */
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

}
