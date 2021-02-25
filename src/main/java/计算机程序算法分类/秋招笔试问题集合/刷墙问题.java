/**
 * Copyright (C), 2018-2020
 * FileName: Main
 * Author:   xjl
 * Date:     2020/7/29 8:40
 * Description: 考试函数框架
 */
package 计算机程序算法分类.秋招笔试问题集合;

import java.util.Scanner;

public class 刷墙问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//大小
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int[] array1 = new int[m];
            int[] array2 = new int[m];
            for (int j = 0; j < m; j++) {
                array1[j] = sc.nextInt();
            }
            for (int j = 0; j < m; j++) {
                array2[j] = sc.nextInt();
            }
            boolean res = test11(array1, array2);
            if (res) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean test11(int[] array1, int[] array2) {
        //array1表示的是原来的   array2表示的新的
        for (int i = 0; i < array2.length; i++) {
            if (array1[i] == array2[i]) {
                continue;
            } else {
                int index = -1;
                //找到这个位置
                for (int k = 0; k < array1.length; k++) {
                    if (array1[k] == array2[i]) {
                        index = k;
                        break;
                    }
                }
                if (index < 0) {
                    return false;
                }
                //只能是从倒置回来
                if (index > i) {
                    while (index >= i) {
                        array1[index] = array2[i];
                        //控制的这个确定的数的不能发生变化
                        if (array2[index]!=array1[index]){
                            return false;
                        }
                        index--;
                    }
                } else {
                    while (index <= i) {
                        array1[index] = array2[i];
                        //控制的这个确定的数的不能发生变化
                        if (array1[index]!=array2[index]){
                            return false;
                        }
                        index++;
                    }
                }
            }
        }
        return true;
    }
}
