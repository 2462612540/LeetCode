/**
 * Copyright (C), 2018-2020
 * FileName: Mergetest
 * Author:   xjl
 * Date:     2020/3/24 14:35
 * Description: 归并测试
 */
package JAVA_sort_arithmetic.test;

import JAVA_sort_arithmetic.src.high_sort.Merge_new;
import JAVA_sort_arithmetic.src.high_sort.huibing;

import java.util.Arrays;

public class Mergetest {

    public static void main(String[] args) {
        Comparable[] numbers = {5, 1, 8, 9, 4, 5, 8, 6};
        Merge_new.sort(numbers);
        System.out.println(Arrays.toString(numbers));
        System.out.println("************************************************");
        Comparable[] numbers1 = {1,8,7,5,9,7,8,3,4,0,6};
        huibing.sort(numbers1);
        System.out.println("新的结果=" + Arrays.toString(numbers1));
    }

}
