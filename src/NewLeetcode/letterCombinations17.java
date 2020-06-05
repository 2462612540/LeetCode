/**
 * Copyright (C), 2018-2020
 * FileName: letterCombinations17
 * Author:   xjl
 * Date:     2020/6/5 14:07
 * Description: 电话号码的组合
 */
package NewLeetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class letterCombinations17 {
    String[] leeterMap = {"", " ", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> list = new ArrayList<>();

    /**
     * @param digits 需要的选择的字符串
     * @param index  开始的位置
     * @param s      保留的是0-index-1的一个字母字符串
     */
    private void findCombination(String digits, int index, String s) {
        if (index == digits.length()) {
            list.add(s);
            return;
        }
        char c = digits.charAt(index);
        if (c >= '0' && c <= '9' && c != '1') {
            String letters = leeterMap[c - '0'];
            for (int i = 0; i < letters.length(); i++) {
                findCombination(digits, index + 1, s + letters.charAt(i));
            }
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return list;
        }
        findCombination(digits, 0, "");
        return list;
    }

    @Test
    public void test() {
        List<String> list = letterCombinations("234");
        for (String s : list) {
            System.out.println(s);
        }
    }
}
