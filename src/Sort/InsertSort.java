/**
 * Copyright (C), 2018-2020
 * FileName: InsertSort
 * Author:   xjl
 * Date:     2020/3/19 15:28
 * Description: c插入排序
 */
package Sort;

import org.junit.Test;

public class InsertSort {
    public static int[] Insertsort(int[] number) {
        for (int i = 1; i < number.length; i++) {
            for (int j = i; j >0; j--) {
                if (number[j-1]>number[j]) {
                    int temp = number[j];
                    number[j - 1] = number[j];
                    number[j] = temp;
                } else {
                    break;
                }
            }
        }
        return number;
    }

    @Test
    public void test() {
        int count = 5;
        int[] number = new int[count];
        for (int i = 0; i < count; i++) {
            System.out.println(number[i] = (int) (Math.random() * 10));
        }
        int[] number2 = Insertsort(number);
        System.out.println("*******************************************");
        for (int value : number2) {
            System.out.println(value);
        }
    }
}
