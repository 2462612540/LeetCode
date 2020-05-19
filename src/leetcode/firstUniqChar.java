/**
 * Copyright (C), 2018-2020
 * FileName: firstUniqChar
 * Author:   xjl
 * Date:     2020/4/1 11:59
 * Description: 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。
 */
package leetcode;

import org.junit.Test;

public class firstUniqChar {
    public char firstUniqChar(String s) {
        //如果是为0则表示为空
        if (s.length() == 0) {
            return ' ';
        }
        //如果是的长度为1 也是返回这个就可以
        if (s.length() == 1) {
            return s.charAt(0);
        }
        for (int i = 0; i < s.length(); i++) {
            int count = 1;
            for (int j =i+1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    count++;
                }
            }
            if (count == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }

    @Test
    public void test() {
        System.out.println(firstUniqChar("aadadaad"));
    }
}
