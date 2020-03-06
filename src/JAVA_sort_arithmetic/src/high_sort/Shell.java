/**
 * Copyright (C), 2018-2020
 * FileName: Shell
 * Author:   xjl
 * Date:     2020/3/6 10:53
 * Description: 希尔排序的原理
 */
package JAVA_sort_arithmetic.src.high_sort;

/**
 * 希尔排序的原理：
 */
public class Shell {
    public static void sort(Comparable[] a) {
        //根据数组a的长度来决定的增涨的量
        int h = 1;
        while (h < a.length / 2) {
            h = 2 * h + 1;
        }
        while (h >= 1) {
            //等待插入的元素
            for (int i = h; i < a.length; i++) {
                //将把带插入的元素插入到有序的数列中
                for (int j = i; j >= h; j = h) {
                    //等待插入的元素是a[j]和a[j-h]
                    if (greater(a[j - h], a[j])) {
                        //交换元素
                        exch(a, j - h, j);
                    } else {
                        //带插入的元素已经找到了合适的位置结束循环。
                        break;
                    }
                }
            }
            //减小h的值
            h = h / 2;
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
