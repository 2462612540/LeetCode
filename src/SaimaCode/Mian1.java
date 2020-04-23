/**
 * Copyright (C), 2018-2020
 * FileName: Mian1
 * Author:   xjl
 * Date:     2020/4/22 13:50
 * Description: 案例测试
 */
package SaimaCode;

import java.util.Scanner;
import java.util.TreeSet;

class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            TreeSet<Integer> set = new TreeSet<>();
            //输入数据
            int n = sc.nextInt();
            int m = sc.nextInt();
            //设置两个数组
            int[] number1 = new int[n];
            int[] number2 = new int[m];
            //存入两个数组
            for (int i = 0; i < n; ++i) {
                number1[i] = sc.nextInt();
            }
            for (int i = 0; i < m; ++i) {
                number2[i] = sc.nextInt();
            }
            //函数的整理
            for (int i = 0; i < n; ++i) {
                if (!set.contains(number1[i])) {
                    set.add(number1[i]);
                }
            }
            for (int i = 0; i < m; ++i) {
                if (!set.contains(number2[i])) {
                    set.add(number2[i]);
                }
            }
//            String str = "";
//            for (Integer va : set) {
//                str += String.valueOf(va) + " ";
//            }
//            System.out.println(str.trim());
            for (Integer va:set){
                System.out.println(va+" ");
            }
        }
        sc.close();
    }
}

