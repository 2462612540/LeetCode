package 牛客网名企高频面试题143; /**
 * Copyright (C), 2018-2020
 * FileName: 名企高频面试题143.合并两个有序的数组
 * Author:   xjl
 * Date:     2020/9/24 9:52
 * Description:
 */


import org.junit.Test;

import java.util.Arrays;

/**
 * 采用的是的数组的归并的思想
 */
public class 合并两个有序的数组 {
    /**
     * 利用的是的系统函数的这样的一个效果
     *
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public void merge(int A[], int m, int B[], int n) {
        for (int i = 0; i < n; i++) {
            A[i + m] = B[i];
        }
        Arrays.sort(A);
    }

    /**
     * 采用的是归并的一个思想
     *
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public void merge2(int A[], int m, int B[], int n) {
        if (A.length==0) {
            A=B;
            return;
        }
        int[] array = new int[m + n];
        int i = 0;
        int j = 0;
        int index = 0;
        while (i < A.length && j < B.length) {
            if (A[i] >= B[j]) {
                array[index++] = B[j++];
            } else {
                array[index++] = A[i++];
            }
        }
        while (i < A.length) {
            array[index++] = A[i++];
        }
        while (j < B.length) {
            array[index++] = B[j++];
        }
        //最后的结果
        A = array;

        for (int k : A) {
            System.out.print(k + " ");
        }
    }

    @Test
    public void test() {
        int[] A = {};
        int[] B = {1};
        merge2(A, A.length, B, B.length);
    }

}
