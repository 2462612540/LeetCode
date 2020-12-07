/**
 * Copyright (C), 2018-2020
 * FileName: addStrings415
 * Author:   xjl
 * Date:     2020/8/3 9:30
 * Description: 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 */
package leetcode;

import java.util.Scanner;

public class addStrings415 {
    /**
     * 从前开始设置为低的计算
     *
     * @param num1
     * @param num2
     * @return
     */
    public static String addStrings(String num1, String num2) {
        //从尾部开始计算
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        //存储结果
        StringBuffer ans = new StringBuffer();
        //遍历
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        // 计算完以后的答案需要翻转过来
        ans.reverse();
        return ans.toString();
    }

    /**
     * 表示的从后面设置为低位
     * @param num1
     * @param num2
     * @return
     */
    public static String addStrings2(String num1, String num2) {
        //将翻转
        String Nnum1 = new StringBuilder(num1).reverse().toString();
        String Nuum2 = new StringBuilder(num2).reverse().toString();
        //从尾部开始计算
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        //存储结果
        StringBuffer ans = new StringBuffer();
        //遍历
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        // 计算完以后的答案需要翻转过来
        ans.reverse();
        return ans.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        String result = addStrings2(s1, s2);
        System.out.println(result);
    }
}
