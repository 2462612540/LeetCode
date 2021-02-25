/**
 * Copyright (C), 2018-2020
 * FileName: Main
 * Author:   xjl
 * Date:     2020/7/29 8:40
 * Description: 考试函数框架
 */
package 计算机程序算法分类.滑动窗口问题集合;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class 最长不连续的字串 {

    @Test
    public void test1(){
        test("The Linux kernel is an open source software project of fairly large scope.");
    }


    public void test(String s) {
        String ans = "";
        int left = 0;
        int right = 0;
        Set<Character> set = new HashSet<>();

        while (right < s.length()) {
            //没有重复的时候
            while (right < s.length() && !set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
            }
            ans = ans.length() > s.substring(left, right).length() ? ans : s.substring(left, right);
            if (right == s.length()) {
                break;
            }
            while (left < right) {
                set.remove(s.charAt(left));
                left++;
                //减到不重复的字母
                if (s.charAt(left - 1) == s.charAt(right)) {
                    break;
                }
            }
        }
        System.out.println(ans);
    }
}
