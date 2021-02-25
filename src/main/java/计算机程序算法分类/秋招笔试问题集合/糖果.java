/**
 * Copyright (C), 2018-2020
 * FileName: Main
 * Author:   xjl
 * Date:     2020/7/29 8:40
 * Description: 考试函数框架
 */
package 计算机程序算法分类.秋招笔试问题集合;

import java.util.Scanner;

public class 糖果 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] res = test11(n, m);
        System.out.print("[");
        for (int i = 0; i < res.length; i++) {
            if (i!=res.length-1){
                System.out.print(res[i]);
                System.out.print(",");
            }else {
                System.out.print(res[i]);
            }
        }
        System.out.print("]");
    }

    private static int[] test11(int candies, int num_people) {
        int n = num_people;
        int p = (int) (Math.sqrt(2 * candies + 0.25) - 0.5);
        int remaining = (int) (candies - (p + 1) * p * 0.5);
        int rows = p / n, clos = p % n;
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = (i + 1) * rows + (int) (rows * (rows - 1) * 0.5) * n;
            if (i < clos) d[i] += i + 1 + rows * n;
        }
        d[clos] += remaining;
        return d;
    }
}
