/**
 * Copyright (C), 2018-2020
 * FileName: BubboSort
 * Author:   xjl
 * Date:     2020/3/19 14:50
 * Description: 冒泡排序原理
 */
package Sort;

import org.junit.Test;

import java.util.Arrays;

public class BubboSort {
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

    public static void main(String[] args) {
        int count = 200000;
        int[] number = new int[count];
        for (int i = 0; i < count; i++) {
            number[i] = (int) (Math.random() * 100);
        }
        long st = System.currentTimeMillis();
        int[] number2 = BubboSort(number);
        long end = System.currentTimeMillis();
        for (int i = 0; i < number2.length; i++) {
            System.out.println(number2[i]);
        }
        System.out.println(end - st);
    }

    @Test
    public void test() {
        int[] array = {1, 2, 14, 6, 8, 7, 9, 2};
        int[] ints = BubboSort2(array);
        System.out.println(Arrays.toString(ints).toString());
    }
}
