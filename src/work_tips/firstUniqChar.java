/**
 * Copyright (C), 2018-2020
 * FileName: firstUniqChar
 * Author:   xjl
 * Date:     2020/3/5 14:25
 * Description: 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。
 */
package work_tips;

import java.util.HashMap;
import java.util.Map;

public class firstUniqChar {
    public static char firstUniqChar(String s) {
        char[] ch = s.toCharArray();
        Map<Integer, Character> map = new HashMap<>();
        for (int i = 0; i < ch.length; i++) {
            if (!map.containsValue(ch[i])) {
                map.put(1, ch[i]);
            } else {
                map.put(2, ch[i]);
            }
        }
        for (Integer key : map.keySet()) {
            System.out.println(map.get(key));
//            if (key == 1) {
//                return map.get(key);
//            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        String s = "leetcode";
        firstUniqChar(s);
    }
}
