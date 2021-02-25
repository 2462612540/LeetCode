/**
 * Copyright (C), 2018-2020
 * FileName: longestPalindrome
 * Author:   xjl
 * Date:     2020/3/19 16:48
 * Description: 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 */
package leetcode练习题;

import org.junit.Test;

public class longestPalindrome {
    public String longestPalindrome(String s) {
        if(s==null||s.length()==0){return null;}
        int n=s.length();
        String max="";
        for (int i=0;i<n;i++){
            for (int j=i;j<n;j++){
                if(ispalindrome(s.substring(i,j+1))&&j-i+1>max.length()){
                    max=s.substring(i,j+1);
                }
            }
        }
        return max;
    }
    /**
     * 验证字符是否为回文的记录
     *
     * @param s
     * @return
     */
    public Boolean ispalindrome(String s) {
        String d = new StringBuilder(s).reverse().toString();
        return s.equals(d);
    }

    @Test
    public void test() {
        String s = "abbc";
        String res = longestPalindrome(s);
        System.out.println(res);
    }
}
