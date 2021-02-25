/**
 * Copyright (C), 2018-2020
 * FileName: merge
 * Author:   xjl
 * Date:     2020/3/4 14:08
 * Description: 合并数组
 */
package 牛客网练习题;

import java.util.Arrays;

public class merge {
    public static void merge(int[] A, int m, int[] B, int n) {
        for (int i = 0; i < n; i++) {
            A[m + i] = B[i];
        }
        Arrays.sort(A);
        for(int value:A){
            System.out.println(value);
        }
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 0, 0, 0};
        int[] B = {2, 5, 6};
        merge(A, 3, B, 3);
    }
}
