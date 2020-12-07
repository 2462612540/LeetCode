/**
 * Copyright (C), 2018-2020
 * FileName: 归并基本实现
 * Author:   xjl
 * Date:     2020/9/10 21:24
 * Description:
 */
package 双指针问题;

import org.junit.Test;

public class 归并基本实现 {

    public int[] arrayMerge(int[] array1, int n, int[] array2, int m) {
        int[] result = new int[m + n];
        int index = 0;
        int p1 = 0;
        int p2 = m - 1;

        while (p1 < n && p2 >= 0) {
            if (array1[p1] <= array2[p2]) {
                result[index++] = array1[p1++];
            } else {
                result[index++] = array2[p2--];
            }
        }

        while (p1 < n) {
            result[index++] = array1[p1++];
        }
        while (p2 >= 0) {
            result[index++] = array2[p2--];
        }

        return result;
    }

    @Test
    public void test1() {
        int[] array1 = {1, 3, 5, 8};
        int[] array2 = {9, 6, 4};
        int[] ints = arrayMerge(array1, 4, array2, 3);
        for (int i : ints) {
            System.out.print(i+" ");
        }
    }
}
