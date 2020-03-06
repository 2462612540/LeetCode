/**
 * Copyright (C), 2018-2020
 * FileName: Insert
 * Author:   xjl
 * Date:     2020/3/6 9:50
 * Description: 插入排序算法
 */
package JAVA_sort_arithmetic.src.base_sort;

/**
 * * 将数组分为两组：一组是已经排序的,一组是没有排序的
 * 找到未排序的数组中的第一个元素，向已经插入的数组中进行插入
 * 倒序遍历已经排序的元素 一次的和待插入的元素进行比较，一直等找到最小的一个元素的额等待插入，那么久将待插入的元素放到这个位置中
 * 然后在向后移动一位元素
 *bijiao
 *
 *
 */
public class Insert {
    public static void sort(Comparable[] a) {
        //等待排序的数字
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                //j和j-1的位置的值
                if (greater(a[j - 1], a[j])) {
                    exch(a, j-1, j);
                } else {
                    break;
                }
            }
        }
    }

    public static boolean greater(Comparable v, Comparable w) {
        return v.compareTo(w) > 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
