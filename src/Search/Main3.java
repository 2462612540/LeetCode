/**
 * Copyright (C), 2018-2020
 * FileName: Main3
 * Author:   xjl
 * Date:     2020/7/9 10:38
 * Description: 测试的结果
 */
package Search;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //输入
        int m = sc.nextInt();
        int[] array = new int[m];

        sc.nextLine();
        for (int i = 0; i < m; i++) {
            array[i] = sc.nextInt();
        }
        //函数调用
        int test = test(array);
        //结果的输出
        System.out.println(test);
    }

    private static int test(int[] array) {
        if (array.length == 1) {
            return 0;
        }

        for (int i = 0; i < array.length; i++) {
            //位置为0
            if (i == 0) {
                if (array[i] < array[i + 1]) {
                    return i;
                }
                continue;
            }
            //位置在最后的时候
            if (i == array.length - 1) {
                if (array[i] > array[i - 1]) {
                    return i-1;
                }
                continue;
            }

            if (array[i] < array[i - 1] && array[i] < array[i + 1]) {
                return i;
            }
        }
        return 0;
    }
}
