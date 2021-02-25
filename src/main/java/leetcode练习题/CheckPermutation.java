/**
 * Copyright (C), 2018-2020
 * FileName: CheckPermutation
 * Author:   xjl
 * Date:     2020/3/4 8:28
 * Description: 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 */
package leetcode练习题;

import java.util.HashMap;
import java.util.Map;

/**
 * 就是为了找到是否有一样的字母
 */
public class CheckPermutation {
    public static boolean CheckPermutation(String s1, String s2) {
        if (s1.length() == s2.length()) {
            int count = 1;
            Map<Character, Integer> map1 = new HashMap<>();
            Map<Character, Integer> map2 = new HashMap<>();
            //存储s1
            for (int i = 0; i < s1.length(); i++) {
                if (!map1.containsKey(s1.charAt(i))) {
                    map1.put(s1.charAt(i), count);
                } else {
                    map1.put(s1.charAt(i), count + 1);
                }
                if (!map2.containsKey(s2.charAt(i))) {
                    map2.put(s2.charAt(i), count);
                } else {
                    map2.put(s2.charAt(i), count + 1);
                }
            }
            if (map1.equals(map2)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String s1 = "abc", s2 = "bac";
        System.out.println(CheckPermutation(s1, s2));
    }
}
