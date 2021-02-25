/**
 * Copyright (C), 2018-2020
 * FileName: 最长连续子序列1004
 * Author:   xjl
 * Date:     2020/9/4 19:38
 * Description:
 */
package 计算机程序算法分类.秋招笔试问题集合;

public class 最长连续子序列1004 {

    public int GetMaxConsecutiveOnes(int[] A, int k) {
        int res = 0, i = 0, j = 0;
        for (; i < A.length; i++) {
            if (A[i] == 0) {
                if (k > 0) {
                    k--;
                } else {
                    res = Math.max(res, i - j);
                    while (A[j++] == 1) ;
                }
            }
        }
        return Math.max(res, i - j);
    }
}
