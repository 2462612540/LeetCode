/**
 * Copyright (C), 2018-2020
 * FileName: canPermutePalindrome
 * Author:   xjl
 * Date:     2020/3/4 9:38
 * Description: 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
 */
package leetcode练习题;

import java.util.HashMap;
import java.util.Map;

/**
 * 条件就是字母的个数为偶数个或者是奇数只有一个
 */
public class canPermutePalindrome {
    public static boolean canPermutePalindrome(String s) {
        int count = 1;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), count);
            } else {
                int n=map.get(s.charAt(i))+1;
                map.put(s.charAt(i),n);
            }
        }
        int n = 0;
        //判断map中的奇数的个数大于1的话则不是
        for (Character key : map.keySet()) {
            if(map.get(key)%2!=0){
                n++;
            }
        }
        if (n > 1) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        String s = "ccbbbss";
        System.out.println(canPermutePalindrome(s));
    }
}
