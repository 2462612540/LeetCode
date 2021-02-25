/**
 * Copyright (C), 2018-2020
 * FileName: Main
 * Author:   xjl
 * Date:     2020/7/29 8:40
 * Description: 考试函数框架
 */
package 计算机程序算法分类.秋招笔试问题集合;

import java.util.Scanner;

public class 简单公式计算 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().trim().split(" ");
        int[] array = new int[3];
        for (int i = 0; i < 3; i++) {
            array[i] = Integer.valueOf(s[i]);
        }
        int a=array[0];
        int b=array[1];
        int c=array[2];
        double max1 = (double) Math.max(Math.max(a+b, b), c);
        double max2 = (double) Math.max(Math.max(a, b+c), c);
        double max3 = (double) Math.max(Math.max(a, b), b+c);
        if ((max3 + max2) == 0) {
            System.out.println("ERROR");
            return;
        }
        System.out.println(String.format("%.2f", max1 / (max2 + max3)));
    }
}
