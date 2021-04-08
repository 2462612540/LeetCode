/**
 * Copyright (C), 2018-2020
 * FileName: 名企高频面试题143.大数相乘
 * Author:   xjl
 * Date:     2020/9/5 20:19
 * Description:
 */
package 秋招笔试问题集合;

import java.util.Scanner;

public class 大数相乘 {
    public static void main(String[] args) {
        //相加
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().trim().replace("\"", "").split(",");
        String res = multiply(str[0], str[1]);
        System.out.println(res);
    }

    public static String multiply(String num1, String num2) {
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
