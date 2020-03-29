/**
 * Copyright (C), 2018-2020
 * FileName: Merge
 * Author:   xjl
 * Date:     2020/3/6 11:27
 * Description: 归并排序
 */
package JAVA_sort_arithmetic.src.high_sort;

public class Merge {
    private static Comparable[] assist;

    /**
     * 对数组a进行排序
     *
     * @param a
     */
    public static void sort(Comparable[] a) {
        //初始化一个辅助数组assist
        Comparable[] assist = new Comparable[a.length];
        //定义一个lo变量 和hi分量 分别记录数组最小的和最大的数的索引
        int lo = 0;
        int hi = a.length - 1;
        //调用的sort的重载的方法从索引的lo的索引到hi的元素的排序
        sort(a, lo, hi);
    }

    /**
     * 对数组a中的lo到hi元素进行排序
     *
     * @param a
     * @param lo
     * @param hi
     */
    public static void sort(Comparable[] a, int lo, int hi) {
        //安全性的校验
        if (lo < hi) {
            return;
        }
        //对数据lo和hi的数据进行分组
        int mid = lo + (hi - lo) / 2;
        //分别对每一组的数据进行排序
        sort(a, lo, mid);
        sort(a, mid, hi);
        //在把排序的数组进行归并
        merge(a, lo, mid, hi);
    }

    /**
     * 对数组的从lo到hi为一组 从mid到hi的为一组 对两组的数据记性归并
     *
     * @param a
     * @param lo
     * @param mid
     * @param hi
     */
    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        //定义三个指针
        int i = lo;
        int p1 = lo;
        int p2 = mid + 1;

        //遍历的移动的p1和p2指针 比较对应的索引的值 找出最小的放入辅助数组中
        while (p1 <= mid && p2 <= hi) {
            //比较对应的大小值
            if (greater(a[p1], a[p2])) {
                assist[i++] = a[p1++];
            } else {
                assist[i++] = a[p2++];
            }

        }
        //如果是p1的指针的没有走完那么就是顺序移动的p1的指针 把对应的元素的放入到对应的辅助数组中对应大索引处
        while (p1 <= mid) {
            assist[i++] = a[p1++];
        }
        //其他的一样的遍历
        while (p2 <= hi) {
            assist[i++] = a[p2++];
        }
        //把辅助数组拷贝到原数组中
        for (int index = lo; index <= hi; index++) {
            a[index] = assist[index];
        }
    }

    /**
     * 比较大小
     *
     * @param v
     * @param w
     * @return
     */
    public static boolean greater(Comparable v, Comparable w) {
        return v.compareTo(w) > 0;
    }

    /**
     * 交换位置
     *
     * @param a
     * @param i
     * @param j
     */
    public static void exch(Comparable[] a, int i, int j) {
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
