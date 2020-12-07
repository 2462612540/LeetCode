/**
 * Copyright (C), 2018-2020
 * FileName: Main1
 * Author:   xjl
 * Date:     2020/7/15 9:55
 * Description: kaoshi
 */
package 秋招笔试问题集合;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        //数据的读入
        Scanner sc = new Scanner(System.in);
        //输入的第一行
        int m = sc.nextInt();
        int n = sc.nextInt();

        //调用
        int result = test(m);
        //结果
        System.out.println(result);
    }

    private static int test(int target) {
        if (target <= 2) {
            return target;
        }
        int a = 1;
        int b = 2;
        for (int i = 3; i <= target; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}
