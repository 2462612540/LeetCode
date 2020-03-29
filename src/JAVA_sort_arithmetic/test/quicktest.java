/**
 * Copyright (C), 2018-2020
 * FileName: Mergetest
 * Author:   xjl
 * Date:     2020/3/24 14:35
 * Description: 归并测试
 */
package JAVA_sort_arithmetic.test;

import JAVA_sort_arithmetic.src.high_sort.qiucksort;

import java.util.Arrays;

public class quicktest {

    public static void main(String[] args) {
        Comparable[] numbers = {5, 1, 8, 9, 4, 5, 8, 6};
        qiucksort.sort(numbers);
        System.out.println("Kaua排序的结果" + Arrays.toString(numbers));

    }

}
