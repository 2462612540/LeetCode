/**
 * Copyright (C), 2018-2020
 * FileName: longestPalindrome
 * Author:   xjl
 * Date:     2020/3/29 15:23
 * Description: 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。  在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 */
package Leetcode_simple_difficulty;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class longestPalindrome {
    public int longestPalindrome(String s) {
        int length = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                //如果是包含的话
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }
        for (Character c : map.keySet()) {
            length += map.get(c) / 2;
        }
        if (2 * length + 1 > s.length()) {
            return length * 2;
        }
        return 2 * length + 1;
    }

    @Test
    public void test() {
        String s = "abccccddffAccbbdddd";
        System.out.println(longestPalindrome(s));

    }
}
