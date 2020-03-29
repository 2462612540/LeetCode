/**
 * Copyright (C), 2018-2020
 * FileName: huibing
 * Author:   xjl
 * Date:     2020/3/24 16:07
 * Description: 归并排序
 */
package JAVA_sort_arithmetic.src.high_sort;

public class huibing {
    private static Comparable[] assit;

    //初始化临时数组和排序
    public static void sort(Comparable[] a) {
        assit = new Comparable[a.length];
        int lo = 0;
        int hi = a.length-1;
        sort(a, lo, hi);
    }

    //检查、分组递归
    public static void sort(Comparable[] a, int lo, int hi) {
        //判断时候不符合递归的条件
        if (lo >= hi) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo;
        int p1 = lo;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= hi) {
            if (less(a[p1], a[p2])) {
                assit[i++] = a[p1++];
            } else {
                assit[i++] = a[p2++];
            }
        }
        while (p1 <= mid) {
            assit[i++] = a[p1++];
        }
        while (p2 <= mid) {
            assit[i++] = a[p2++];
        }
        //再将辅助数组赋值到原来的数组中
        for (int index = lo; index <= hi; index++) {
            a[index] = assit[index];
        }
    }

    //比较两个元素的大小
    public static Boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
}
