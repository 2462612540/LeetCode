/**
 * Copyright (C), 2018-2020
 * FileName: 冒泡排序
 * Author:   xjl
 * Date:     2020/9/6 9:55
 * Description:
 */
package 计算机程序算法分类.排序算法;

public class 冒泡排序 {

    public static int[] BubboSort(int[] number) {
        //控制比较的排序的次数
        for (int i = number.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (number[j] > number[j + 1]) {
                    int temp = number[j];
                    number[j] = number[j + 1];
                    number[j + 1] = temp;
                }
            }
        }
        return number;
    }

    /**
     * 冒泡排序算法默写
     *
     * @param number
     * @return
     */
    public static int[] BubboSort2(int[] number) {
        for (int i = number.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (number[j] > number[j + 1]) {
                    int temp = number[j];
                    number[j] = number[j + 1];
                    number[j + 1] = temp;
                }
            }
        }
        return number;
    }

    public static int[] BubboSort3(int[] number) {
        for (int i = number.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                int[] res = swap(number[i], number[j]);
                number[j] = res[0];
                number[i] = res[1];
            }
        }
        return number;
    }

    public static int[] swap(int a, int b) {
        a = a + b;
        b = a - b;
        a = a - b;
        return new int[]{a, b};
    }
}
