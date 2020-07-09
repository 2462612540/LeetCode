/**
 * Copyright (C), 2018-2020
 * FileName: Main
 * Author:   xjl
 * Date:     2020/7/8 10:31
 * Description: 测试
 */
package second_category;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        //开始下一行读取
        sc.nextLine();
        //建立数组
        int[] array = new int[m];
        for (int i = 0; i < m; i++) {
            array[i] = sc.nextInt();
        }
        //调用函数执行
        int i = test2(array);

        //输入结果
        System.out.println(i);

    }

    private static int test1(int[] array) {
        int sum = 0;
        for (int i = 1; i < array.length; i++) {
            int start = 0;
            int end = i-1 ;
            while (start < end) {
                if (array[start] < array[i] || array[end] < array[i]) {
                    sum += array[start] + array[end];
                }
                start++;
                end--;
            }
        }
        return sum;
    }

    private static int test2(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[j] <= array[i]) {
                    sum += array[j];
                }
            }
        }
        return sum;
    }
}
