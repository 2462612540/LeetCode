/**
 * Copyright (C), 2018-2020
 * FileName: Merge_new
 * Author:   xjl
 * Date:     2020/3/24 12:46
 * Description: 归并排序
 */
package JAVA_sort_arithmetic.src.high_sort;

/**
 * 归并排序就是的： 递归+分离+双指针
 */
public class Merge_new {
    //需要一个辅助的数组
    private static Comparable[] assit;

    //对数组内的元素进行排序
    public static void sort(Comparable[] a) {
        //初始化数组assit
        assit = new Comparable[a.length];
        //定义一个lo变量 和hi变量 分别记录数组中最小的索引和最大的索引：
        int lo = 0;
        int hi = a.length - 1;
        //调用重载的sort方法完成数据a中，从索引库lo到hi的元素的排序
        sort(a, lo, hi);
    }

    //对数组的lo到hi之间进行排序
    public static void sort(Comparable[] a, int lo, int hi) {
        //安全校验
        if (lo >= hi) {
            return;
        }
        //对数据lo 到hi之间的分为两个数据
        int mid = lo + (hi - lo) / 2;
        //这里是递归的算法
        sort(a, lo, mid);//递归调用自己
        sort(a, mid + 1, hi);
        //在把两个组的数据进行归并
        merge(a, lo, mid, hi);
    }

    //从索引lo到mid为一个子数组 从mid+1到hi为一个数组 将a中的两个子数组数据合并成为一个大的有序的数组
    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        //定义三个指针
        int i = lo;//assit的指针
        int p1 = lo;//左数组
        int p2 = mid + 1;//右数组
        //遍历p1 p2的比较对应的索引的值 找到那个比较小的 放置到辅助的数组中
        while (p1 <= mid && p2 <= hi) {
            if (less(a[p1], a[p2])) {
                assit[i++] = a[p1++];
            } else {
                assit[i++] = a[p2++];
            }
        }
        //遍历，如果p1没有走完，那就移动p1指针，把对应的元素的放置到数组中找到对应的所引处
        while (p1 <= mid) {
            assit[i++] = a[p1++];
        }
        //遍历，如果p2没有走完，那就移动p2指针，把对应的元素的放置到数组中找到对应的所引处
        while (p2 <= hi) {
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




