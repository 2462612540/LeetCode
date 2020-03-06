/**
 * Copyright (C), 2018-2020
 * FileName: Select
 * Author:   xjl
 * Date:     2020/3/6 8:56
 * Description: 选择排序算法
 */
package JAVA_sort_arithmetic.src.base_sort;

/**选择排序就是每一次遍历都选择最小的哪一个放置最前面
 * 选择排序的原理是：设置最小的位置的下标，minindex(1-----n-i)
 * 找到其次最小的位置的下标
 * 然后在交换最小位置的数和第一个小的数进行交换
 * 数据的比较次数是：n-1^……1
 * 数据的交换次数是n-1的次数
 * 实际上这个选择排序和冒泡排序基本是一样的，都是将最小的（最大值）每一次遍历后都是固定在
 * 第一位置不过是放在最前的位置冒泡是将其放在最后的一个位置
 */
public class Select {
    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int minindex = i;//设置记录最小的元素的位置
            for (int j = i + 1; j < a.length; j++) {
                if (greater(a[minindex], a[j])) {
                    minindex = j;
                }
            }
            //交换最小的元素
            exch(a, i, minindex);
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
