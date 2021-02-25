/**
 * Copyright (C), 2018-2020
 * FileName: Main2
 * Author:   xjl
 * Date:     2020/7/24 10:04
 * Description: 给定一个整型数组arr，代表数值不同的纸牌排成一条线，玩家A和玩家B依次拿走每张纸牌，规定玩家A先拿，玩家B后拿，但是每个玩家每次只能拿走最左和最右的纸牌，玩家A和玩家B绝顶聪明。请返回最后的获胜者的分数。
 */
package leetcode练习题;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        //数据的读取
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        sc.nextLine();
        double[] array = new double[m];
        for (int i = 0; i < m; i++) {
            array[i] = sc.nextDouble();
        }
        // 函数的调用
        double result = get(array, m);
        //打印结果
        System.out.print(String.format("%.2f", result));
    }

    public static double get(double[] arr, int n) {
        if (arr.length == 0 || arr == null) {
            return 0;
        }
        double small = 0;
        double big = 0;
        double dpSmall = 0;
        double dpBig = 0;
        double max = 0;
        //-------------------------------------------
        for (int i = 0; i < n; i++) {
            if (arr[i] >= 0) {
                small = dpSmall * arr[i];
                big = dpBig * arr[i];
                dpSmall = Math.min(arr[i], small);
                dpBig = Math.max(arr[i], big);
            } else {
                small = dpBig * arr[i];
                big = dpSmall * arr[i];
                dpBig = Math.max(arr[i], big);
                dpSmall = Math.min(arr[i], small);
            }
            max = Math.max(max, dpBig);
        }
        //-------------------------------------------
        return max;
    }
}
