/**
 * Copyright (C), 2018-2020
 * FileName: Main2
 * Author:   xjl
 * Date:     2020/7/9 10:18
 * Description: 查找测试
 */
package Search;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        //输入
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int[] array1 = new int[m];
        int[] array2 = new int[m];
        for (int i = 0; i < 2; i++) {
            array1[i] = sc.nextInt();
        }
        sc.nextLine();
        for (int i = 0; i < 2; i++) {
            array1[i] = sc.nextInt();
        }
        //函数的调用
        int test = test(array1, array2);
        //结果的输出
        System.out.println(test);

    }

    private static int test(int[] array1, int[] array2) {


        return 0;
    }
}
