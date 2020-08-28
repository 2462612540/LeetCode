/**
 * Copyright (C), 2018-2020
 * FileName: ShellSort
 * Author:   xjl
 * Date:     2020/6/4 15:56
 * Description: 希尔排序原理
 */
package Sort;

import java.util.Arrays;

/**
 * 希尔排序的原理
 * 1 选定一个增长量 按照增长量h作为数据的分组的依据 对数据进行分组
 * 2 按照分好组的每一个组的数据完成的插入的排序
 * 3 减少增长量 最下减少为1 重复第二步骤
 * 增长量的确定：增长量的h的值的选择规则是：
 * <p>
 * int h=1;
 * while(h<数组的长度/2){ * h=2*h+1; }
 * <p>
 * h的减少的规则是
 * h=h/2;
 */
public class ShellSort {
    /**
     * 希尔排序的原理
     *
     * @param a
     */
    public static void sort(int[] a) {
        //根据数据的a 的长度确定的增长量
        int h = 1;
        while (h < a.length / 2) {
            h = 2 * h + 1;
        }
        //希尔排序
        while (h >= 1) {
            //找到带插入的元素
            for (int i = h; i < a.length; i++) {
                //把带插入的元素插入到有序的数列中
                for (int j = i; j >= h; j -= h) {
                    //带插入的元素是的啊a[j] 比较 a[j-h]
                    if (generate(a[j - h], a[j])) {
                        exch(a, j - h, j);
                    } else {
                        break;
                    }
                }
            }
            for (int V : a) {
                System.out.print(V + " ");
            }
            System.out.println();
            //减少hd的值
            h = h / 2;
        }
    }

    /**
     * 比较大小的函数
     *
     * @param v
     * @param w
     * @return
     */
    private static boolean generate(int v, int w) {
        return v - w > 0;
    }

    /**
     * 交换的函数
     *
     * @param a
     * @param i
     * @param j
     */
    private static void exch(int[] a, int i, int j) {
        int temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {25, 84, 21, 47, 15, 27, 68, 35, 20};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

}
