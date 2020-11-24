/**
 * Copyright (C), 2018-2020
 * FileName: Main
 * Author:   xjl
 * Date:     2020/7/29 8:40
 * Description: 考试函数框架
 */
package 秋招笔试问题集合;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String newstr = "";
        for (int i = 0; i < str.length(); i++) {
            newstr += str.charAt(i) - 'A';
        }
        System.out.println(newstr);
        int result = test(newstr);
        System.out.println(result);
    }

    private static int test(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int hlep = 1;
        int res = 1;
        if (s.charAt(len - 1) != '0') {
            return 1;
        }
        for (int i = len - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                hlep = res;
                res = 0;
                continue;
            }
            if ((s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0') < 26) {
                res += hlep;
                hlep = res - hlep;
            } else {
                hlep = res;
            }
        }
        return res;
    }
}
