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
public class letterCombinations {
    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    List<String> output = new ArrayList<String>();

    public void backtrack(String combination, String next_digits) {
        if (next_digits.length() == 0) {
            output.add(combination);
        } else {
            String digit = next_digits.substring(0, 1);
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = phone.get(digit).substring(i, i + 1);
                backtrack(combination + letter, next_digits.substring(1));
            }
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0)
            backtrack("", digits);
        return output;
    }

    @Test
    public void test() {
        System.out.println(letterCombinations("23"));

    }
}
