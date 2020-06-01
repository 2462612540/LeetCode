/**
 * Copyright (C), 2018-2020
 * FileName: maximum
 * Author:   xjl
 * Date:     2020/3/4 15:20
 * Description: 最大值
 */
package leetcode;

public class maximum {
    public static int maximum(int a, int b) {
        int n = a + b + Math.abs(a - b) / 2;
        return n;
    }

    public static int maximum1(int a, int b) {
        Math.max(a,b);/**/
        return a > b ? a : b;
    }

    public static void main(String[] args) {
        maximum(1, 2);
    }
}
