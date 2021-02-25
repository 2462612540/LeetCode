/**
 * Copyright (C), 2018-2020
 * FileName: lengthOfLongestSubstring
 * Author:   xjl
 * Date:     2020/3/15 12:44
 * Description: 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
package leetcode练习题;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class lengthOfLongestSubstring {
    /**
     * 最长大字串
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int start = 0;
        int end = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
                res = set.size();
            } else {
                res = res > set.size() ? res : set.size();
                set.clear();
                i = i - set.size() + 1;
            }
        }
        return res;
    }

    public int lengthOfLongestSubstring2(String s) {
        if (notrepeat(s)) {
            return s.length();
        } else {
            int max = 0;
            for (int i = 0; i < s.length(); i++) {
                for (int j = i; j < s.length(); j++) {
                    if (notrepeat(s.substring(i, j+1)) && max < s.substring(i, j+1).length()) {
                        max = s.substring(i, j+1).length();
                    }
                }
            }
            return max;
        }
    }

    //检查子串中是否有重复的元素 如果有重复的元素表示不行。
    public Boolean notrepeat(String s) {
        Set set = new HashSet();
        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
            } else {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        int res = lengthOfLongestSubstring2(" ");
        System.out.println(res);
    }


}
