/**
 * Copyright (C), 2018-2020
 * FileName: reverseWords
 * Author:   xjl
 * Date:     2020/4/10 13:59
 * Description: 给定一个字符串，逐个翻转字符串中的每个单词。
 */
package leetcode;

import org.junit.Test;

public class reverseWords {
    public String reverseWords(String s) {
        s.trim();
        String result = "";
        String[] nums = s.split(" ");
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i].equals("")) {
                continue;
            } else {
                result += nums[i] + " ";
            }
        }
        return result.trim();
    }

    @Test
    public void test() {
        String s = "a good   example";
        System.out.println(reverseWords(s));
    }
}
