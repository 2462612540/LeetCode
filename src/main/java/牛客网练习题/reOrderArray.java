/**
 * Copyright (C), 2018-2020
 * FileName: reOrderArray
 * Author:   xjl
 * Date:     2020/5/8 19:26
 * Description: 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
package 牛客网练习题;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class reOrderArray {

    public void reOrderArray2(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] % 2 == 0 && array[j + 1] % 2 == 1) {
                    int t = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = t;
                }
            }
        }
    }

    public void reOrderArray(int[] array) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                //偶数存放
                list2.add(array[i]);
            } else {
                list1.add(array[i]);
            }
        }
        for (int value : list2) {
            list1.add(value);
        }
        Object[] array1 = list1.toArray();
        for (int i = 0; i < array1.length; i++) {
            array[i] = (int) array1[i];
        }
    }

    @Test
    public void test() {
        int[] number = {1, 2, 3, 4, 5, 6, 7};
        reOrderArray2(number);
    }
}
