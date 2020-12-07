/**
 * Copyright (C), 2018-2020
 * FileName: countCharacters
 * Author:   xjl
 * Date:     2020/3/31 9:43
 * Description: 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
 * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
 * 注意：每次拼写（指拼写词汇表中的一个单词）时，chars 中的每个字母都只能用一次。
 * 返回词汇表 words 中你掌握的所有单词的 长度之和。
 */
package leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class countCharacters {
    public int countCharacters(String[] words, String chars) {
        Map<Character, Integer> map1 = new HashMap();
        Map<Character, Integer> map2 = new HashMap();
        int count = 1;
        int sum = 0;
        //chars遍历整个字符串放入一个map中
        for (int i = 0; i < chars.length(); i++) {
            if (!map1.containsKey(chars.charAt(i))) {
                map1.put(chars.charAt(i), count);
            } else {
                map1.put(chars.charAt(i), map1.get(chars.charAt(i)) + 1);
            }
        }
        //遍历好words中每一个单词
        for (String s : words) {
            for (int i = 0; i < s.length(); i++) {
                if (!map2.containsKey(s.charAt(i))) {
                    map2.put(s.charAt(i), count);
                } else {
                    map2.put(s.charAt(i), map2.get(s.charAt(i)) + 1);
                }
            }
            //遍历map2中的个数
            int count1 = 0;
            for (char c : map2.keySet()) {
                if (!(map1.containsKey(c) && map1.get(c) >= map2.get(c))) {
                    count1=0;
                    break;
                }
                count1++;
                if (count1 == map2.size()) {
                    sum += s.length();
                }
            }
            map2.clear();
        }
        return sum;
    }

    @Test
    public void test() {
        String[] words = {"hello","world", "leetcode"};
        String chars = "welldonehoneyr";
        System.out.println(countCharacters(words, chars));

    }
}

