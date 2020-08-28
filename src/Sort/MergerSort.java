/**
 * Copyright (C), 2018-2020
 * FileName: MergerSort
 * Author:   xjl
 * Date:     2020/6/4 16:24
 * Description: 归并的排序的原理
 */
package Sort;

import java.util.Arrays;

public class MergerSort {
    //完成归并排序需要设置的辅助数组
    private static int[] assit;

    //归并排序的调用函数
    public static void sort(int[] a) {
        //初始化数组assit
        assit = new int[a.length];
        //定义一个lo变量和hi变量 分别是记录数组中最小的索引和最大的索引
        int lo = 0;
        int hi = a.length - 1;
        //调用的sort的重载方法到lo 和hi的元素进行排序
        sort(a, lo, hi);

    }

    //归并排序的分割函数
    public static void sort(int[] a, int lo, int hi) {
        //做个安全的校验
        if (hi <= lo) {
            return;
        }
        //对数据lo 和hi的数据进行分组
        int mind = lo + (hi - lo) / 2;
        //分别是对每一个数据进行排序
        sort(a, lo, mind);
        sort(a, mind + 1, hi);
        //在将两个组中的数据进行归并
        merge(a, lo, mind, hi);
    }

    //归并排序的合并函数
    public static void merge(int[] a, int lo, int mid, int hi) {
        //定义三个指针
        int i = lo;
        int p1 = lo;
        int p2 = mid + 1;
        //遍历 移动平p1指针和p2指针 比较对应的索引的值，找出最小的那个 放置到辅助的数组的对应的索引的处
        while (p1 <= mid && p2 <= hi) {
            if (less(a[p1], a[p2])) {
                assit[i++] = a[p1++];
            } else {
                assit[i++] = a[p2++];
            }
        }
        //遍历 如果是p1的指针没有走完，那么继续针移动p1指针，对应的元素带放到辅助数组的对应的索引
        while (p1 <= mid) {
            assit[i++] = a[p1++];
        }
        //遍历 如果是p2的指针没有走完，那么继续激动p2指针，将对应的元素放到辅助数组的对应的索引处
        while (p2 <= hi) {
            assit[i++] = a[p2++];
        }
        //把辅助数组的元素拷贝的原数组中
        for (int index = lo; index <= hi; index++) {
            a[index] = assit[index];
        }
    }

    //函数的比较函数
    public static boolean less(int v, int w) {
        return v - w < 0;
    }

    //交换函数
    public static void excht(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {9, 1, 2, 5, 7, 4, 8, 6, 3, 5};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
