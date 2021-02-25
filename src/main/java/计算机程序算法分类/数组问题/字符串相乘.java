/**
 * Copyright (C), 2018-2020
 * FileName: 字符串相乘
 * Author:   xjl
 * Date:     2020/9/6 9:44
 * Description:
 */
package 计算机程序算法分类.数组问题;

import org.junit.Test;

public class 字符串相乘 {

    @Test
    public void test() {
        System.out.println(multiply("350", "2.5"));
    }

    /**
     * 两个整数的字符串相乘的函数
     *
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int n = num1.length();
        int m = num2.length();
        int[] res = new int[n + m];

        for (int i = n - 1; i >= 0; i--) {
            int a = num1.charAt(i) - '0';
            for (int j = m - 1; j >= 0; j--) {
                int b = num2.charAt(j) - '0';
                res[i + j + 1] += a * b;
                res[i + j] += res[i + j + 1] / 10;
                res[i + j + 1] %= 10;
            }
        }
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (res[i] == 0) {
            i++;
        }
        for (; i < res.length; i++) {
            result.append(res[i]);
        }
        return result.toString();
    }
}
