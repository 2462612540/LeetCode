/**
 * Copyright (C), 2018-2020
 * FileName: qiucksort
 * Author:   xjl
 * Date:     2020/3/24 16:45
 * Description: 快速排序原理
 */
package JAVA_sort_arithmetic.src.high_sort;

public class qiucksort {
    //对数组的元素进行排序
    public static void sort(Comparable[] a) {
        int low = 0;
        int hi = a.length - 1;
        sort(a, low, hi);
    }

    //对数组a中lo到hi之间的元素进行排序
    public static void sort(Comparable[] a, int lo, int hi) {
        //安全索引
        if (hi <= lo) {
            return;
        }
        //从lo到hi进行分组为2组
        int partition = partition(a, lo, hi);//分界值的位置变换后的索引
        //让左边有序
        sort(a, lo, partition - 1);
        //让右边有序
        sort(a, partition + 1, hi);
    }

    //对数组a中lo到hi之间的元素进行分组 并但会对应的分组界限的索引
    public static int partition(Comparable[] a, int lo, int hi) {
        //确定分界值设定第一个为分界值
        Comparable key = a[lo];
        //定义两个指针
        int left = lo;
        int right = a.length - 1;
        while (true) {
            //先从右向左扫描移动right 找到一个比分界值小的元素 停止
            while (less(key, a[--right])) {
                if (right == lo) {
                    break;
                }
            }
            //在从左边想右边移动left  找到一个比分界值大的元素 停止
            while (less(a[++left],key)) {
                if (left == hi) {
                    break;
                }
            }
            //判断left>=right 如果是那就证明元素扫描完毕，如果不是的话则需要交换元素1
            if (left >= right) {
                break;
            } else {
                exch(a, left, right);
            }
        }
        //交换分界的值
        exch(a, lo, right);
        return right;
    }

    //比较元素
    private static Boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    //交换元素
    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
