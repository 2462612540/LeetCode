/**
 * Copyright (C), 2018-2020
 * FileName: reverseWords
 * Author:   xjl
 * Date:     2020/3/4 12:40
 * Description: 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序
 */
package Leetcode_simple_difficulty;

public class reverseWords {
    public static String reverseWords(String s) {
        String res = "";
        //先将数组花开
        String[] S = s.split(" ");
        for (int i = 0; i < S.length; i++) {
            char[] ch = S[i].toCharArray();
            for (int j = 0; j < ch.length / 2; j++) {
                char temp;
                temp = ch[j];
                ch[j] = ch[ch.length - j - 1];
                ch[ch.length - j - 1] = temp;
            }
            if (i + 1 == S.length) {
                res += String.valueOf(ch);
            } else {
                res += String.valueOf(ch) + " ";
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(reverseWords(s));

    }
}
