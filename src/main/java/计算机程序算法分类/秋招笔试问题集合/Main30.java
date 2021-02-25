/**
 * Copyright (C), 2018-2020
 * FileName: Main
 * Author:   xjl
 * Date:     2020/7/29 8:40
 * Description: 考试函数框架
 */
package 计算机程序算法分类.秋招笔试问题集合;

import java.util.ArrayList;
import java.util.Scanner;

public class Main30 {

    public static void main(String[] args) {
        IO1();
    }

    /**
     * 有异常的输入结果  1, 2, 3
     */
    private static void IO() {

        Scanner sc = new Scanner(System.in);
        String oldstr = sc.nextLine().trim();
        String str = "";
        for (int i = 0; i < oldstr.length(); i++) {
            if (oldstr.charAt(i) != ' ') {
                str += oldstr.charAt(i);
            }
        }
        System.out.println(str);
    }

    /**
     * 输入的是 [1,2,3,4,5],[5,6,7,8,9]
     */
    private static void IO1() {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().trim();
        String ans = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ']' || str.charAt(i) == '[') {
                continue;
            }
            ans += str.charAt(i);
        }
        String[] split = ans.split(",");
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < split.length / 2; i++) {
            list1.add(Integer.valueOf(split[i]));
        }
        for (int i = split.length / 2; i < split.length; i++) {
            list2.add(Integer.valueOf(split[i]));
        }
        System.out.println(list1.toString());
        System.out.println(list2.toString());
    }
}

