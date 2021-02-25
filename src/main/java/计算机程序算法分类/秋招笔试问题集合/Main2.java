/**
 * Copyright (C), 2018-2020
 * FileName: Main
 * Author:   xjl
 * Date:     2020/7/29 8:40
 * Description: 考试函数框架
 */
package 计算机程序算法分类.秋招笔试问题集合;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        double[] array = new double[20000];
        for (int i = 0; i < N; i++) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            for (int j=m;j<n;j++){
                array[j]+=1;
            }
        }
        double result=0;
        //遍历或者最大的元素
        for (int i=0;i<array.length;i++){
            result=result>array[i]?result:array[i];
        }
        System.out.println((int)result);
    }
}
