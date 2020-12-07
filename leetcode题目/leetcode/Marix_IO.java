/**
 * Copyright (C), 2018-2020
 * FileName: Marix_IO
 * Author:   xjl
 * Date:     2020/7/16 10:56
 * Description: 二维矩阵的输入
 */
package leetcode;

import java.util.Scanner;

public class Marix_IO {

    public static void main(String[] args) {
        IO3();
    }

    public static void IO3() {
        /**
         * 2   4
         * 4 8 9 7
         * 8 7 8 1
         */
        //数据的输入
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();
        //定义二维数据
        int[][] martix = new int[m][n];

        //遍历
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                martix[i][j] = sc.nextInt();
            }
            sc.nextLine();
        }
        //输出结果
        for (int[] arr : martix) {
            for (int v : arr) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }

    public static void IO2() {
        /**
         * 2   4
         * 4 8 9 7
         * 8 7 8 1
         */
        //数据的输入
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();
        //定义二维数据
        int[][] martix = new int[m][n];

        for (int i = 0; i < m; i++) {
            String[] array = sc.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                martix[i][j] = Integer.valueOf(array[j]);
            }
        }
        //输出结果
        for (int[] arr : martix) {
            for (int v : arr) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }

    public static void IO1() {
        /**
         * 5   4
         * 4,8,9,7
         * 8,7,8,1
         * 9,8,7,8
         * 8,7,3,1
         * 8,7,7,9
         */
        //数据的输入
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();
        //定义二维数据
        int[][] martix = new int[m][n];

        for (int i = 0; i < m; i++) {
            String[] array = sc.nextLine().split(",");
            for (int j = 0; j < n; j++) {
                martix[i][j] = Integer.valueOf(array[j]);
            }
        }
        //输出结果
        for (int[] arr : martix) {
            for (int v : arr) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }
}
