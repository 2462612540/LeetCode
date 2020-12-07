/**
 * Copyright (C), 2018-2020
 * FileName: lengthOfLongestSubstring48
 * Author:   xjl
 * Date:     2020/6/3 11:13
 * Description: 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 */
package leetcode;

import org.junit.Test;

import java.util.*;

public class lengthOfLongestSubstring48 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            //如果没有的话就将加入进来
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                //保证删除了到这个元素出现的的元素为止
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    //时间的限制到了 要做的是不能获取全部的字串
    public int lengthOfLongestSubstring2(String s) {
        int max = 0;
        //获取所有的字串
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String newstr = s.substring(i, j + 1);
                //如果有重复的字母 //在判断字串中是否有相同的
                if (test(newstr)) {
                    max = max > newstr.length() ? max : newstr.length();
                }
            }
        }
        return max;
    }

    private boolean test(String newstr) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < newstr.length(); i++) {
            set.add(newstr.charAt(i));
        }
        if (set.size() == newstr.length()) {
            return true;
        } else {
            return false;
        }
    }

    public int lengthOfLongestSubstring3(String s) {
        int max = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0, j = 0; j < s.length(); ) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                max = max > set.size() ? max : set.size();
            } else {
                set.clear();
                i++;
                j = i;
            }
        }
        return max;
    }

    public int lengthOfLongestSubstring4(String s) {
        int max = 0;
        Set<Character> set = new HashSet<>();
        int i = 0, j = 0;
        for (; j < s.length(); j++) {

        }
        return max;
    }

    @Test
    public void test() {
        int count = lengthOfLongestSubstring("pwwkew");
        System.out.println(count);
    }
}
