/**
 * Copyright (C), 2018-2020
 * FileName: convertToTitle
 * Author:   xjl
 * Date:     2020/3/2 13:31
 * Description: 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 */
package Leetcode_simple_difficulty;

//其实就是一个除法的问题
public class convertToTitle {
    public static String convertToTitle(int n) {
        if (n <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            sb.append((char) (n % 26 + 'A'));
            n =n / 26;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(52));
    }
}
