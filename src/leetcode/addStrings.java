/**
 * Copyright (C), 2018-2020
 * FileName: addStrings
 * Author:   xjl
 * Date:     2020/3/15 11:42
 * Description: 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 */
package leetcode;

import org.junit.Test;

public class addStrings {
    public String addStrings(String num1, String num2) {
        String result = "";
        int curr = 0;
        int n1 = num1.length() - 1;
        int n2 = num2.length() - 1;
        int x = 0, y = 0;
        while (n1 >= 0 || n2 >= 0) {
            if (n1 < 0) {
                x = 0;
            } else {
                x = num1.charAt(n1) - '0';
            }
            if (n2 < 0) {
                y = 0;
            } else {
                y = num2.charAt(n2) - '0';
            }
            result += String.valueOf((x + y + curr) % 10);
            curr = (x + y + curr) / 10;
            n1--;
            n2--;
        }
        return new StringBuffer(result).reverse().toString();
    }

    @Test
    public void test() {
        String n1 = "1934";
        String n2 = "25701";
        System.out.println(addStrings(n1, n2));
    }
}
