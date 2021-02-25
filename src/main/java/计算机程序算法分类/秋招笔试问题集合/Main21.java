/**
 * Copyright (C), 2018-2020
 * FileName: Main
 * Author:   xjl
 * Date:     2020/7/29 8:40
 * Description: 考试函数框架
 */
package 计算机程序算法分类.秋招笔试问题集合;

import java.util.Scanner;

public class Main21 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //输入的数量
        int m = sc.nextInt();//4
        int res = test(m);
        System.out.println(res);
    }

    private static int test(int n) {
       int count=0;
       for (int i=1;i<=n;i++){
           int N=i;
           while (N>0){
               if (N%5==0){
                   count++;
                   N/=5;
               }else {
                   break;
               }
           }
       }
       return count;
    }
}

