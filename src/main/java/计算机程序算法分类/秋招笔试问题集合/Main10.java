/**
 * Copyright (C), 2018-2020
 * FileName: Main
 * Author:   xjl
 * Date:     2020/7/29 8:40
 * Description: 考试函数框架
 */
package 计算机程序算法分类.秋招笔试问题集合;

import java.util.Scanner;

public class Main10 {
    public static void main(String[] args) {
        //数据的输入
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        str.trim();
        String result = "";

        if (str != null && !"".equals(str)) {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) >= 48 && str.charAt(i) <= 57) {
                    result += str.charAt(i);
                }
            }
        }
        //结果的输出
        System.out.println(result);
    }
}
