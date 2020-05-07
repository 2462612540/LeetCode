/**
 * Copyright (C), 2018-2020
 * FileName: letterCombinations
 * Author:   xjl
 * Date:     2020/3/20 15:30
 * Description: 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。  给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
package Leetcode_Medium_difficulty;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 这里是一个递归问题的概念
 */
public class letterCombinations2 {
    Map<Character, String> map = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};
    //用于存储结构的list
    List<String> output = new ArrayList<String>();

    public void findCombination(String str, int index, String s) {
        //递归终止的条件
        if (index == str.length()) {
            output.add(s);
            return;
        }
        //递归
        char c = str.charAt(index);
        if (c >= '0' && c <= '9') {
            String letter = map.get(c);
            for (int i = 0; i < letter.length(); i++) {
                findCombination(str, index + 1, s + letter.charAt(i));
            }
        }
        return;
    }

    public List<String> letterCombinations(String digits) {
        if (digits .equals("")) {
            return output;
        }
        findCombination(digits, 0, "");
        return output;
    }

    @Test
    public void test() {
        System.out.println(letterCombinations("9").toString());
    }

}
