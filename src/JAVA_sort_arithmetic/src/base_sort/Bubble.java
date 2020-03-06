/**
 * Copyright (C), 2018-2020
 * FileName: Bubble
 * Author:   xjl
 * Date:     2020/3/6 7:59
 * Description: 冒泡排序的过程
 */
package JAVA_sort_arithmetic.src.base_sort;

public class Bubble {
    /**
     * 重点是就是在每一个的排序中将最大或者是最小的放在第一个或者是最后一个
     * 比较和排序的两个重要
     * 比较的个数是越来越少的所以是从a.length-1 ----0的个数比较。j 是需要进行的比较的个数
     * Integer 是实现了Comparable的接口的
     * 最坏的比较的次数是n-1 n-2 n-3……1的次数
     * 最坏的比较次数是n-1,n-2,n-3^……1的次数
     *
     * @param a
     */
    public static void sort(Comparable[] a) {
        long start = System.currentTimeMillis();
        for (int i = a.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                //比较的是索引的j 和i+1的值
                if (greater(a[j], a[j + 1])) {
                    exch(a, j, j + 1);
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println("======================================");
        long start1 = System.currentTimeMillis();
        for (int i = 0; i < a.length - 1; i--) {
            for (int j = 0; j < i; j++) {
                //比较的是索引的j 和i的值
                if (greater(a[i], a[j])) {
                    exch(a, i, j);
                }
            }
        }
        long end1 = System.currentTimeMillis();
        System.out.println(end1 - start1);

    }

    public static boolean greater(Comparable v, Comparable w) {
//        int i = v.compareTo(w);
//        return i > 0 ? true : false;
        return v.compareTo(w) > 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
