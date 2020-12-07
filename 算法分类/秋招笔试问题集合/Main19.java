/**
 * Copyright (C), 2018-2020
 * FileName: Main
 * Author:   xjl
 * Date:     2020/7/29 8:40
 * Description: 考试函数框架
 */
package 秋招笔试问题集合;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main19 {

    /**
     * 已知这个4行
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //输入的行数
        int m = sc.nextInt();
        sc.nextLine();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            list.add(sc.nextLine());
        }
        //函数的调用
        String result = test(list);
        System.out.println(result);
    }

    private static String test(ArrayList<String> list) {
        Collections.sort(list);
        //记录一下最长的字符
        String maxlength = "";
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            for (int j = 0; j < list.size(); j++) {
                //判断是否可以拼接
                if (list.get(j).charAt(0) >= str.charAt(str.length() - 1) && i != j) {
                    str += list.get(j);
                }
                if (maxlength.length() <= str.length()) {
                    maxlength = str;
                }
            }
        }
        return maxlength;
    }
}

