/**
 * Copyright (C), 2018-2020
 * FileName: subtractProductAndSum
 * Author:   xjl
 * Date:     2020/3/4 15:11
 * Description: 给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。
 */
package leetcode练习题;

public class subtractProductAndSum {
    public static int subtractProductAndSum(int n) {
        int sum = 0, and = 1;
        while (n > 0) {
            sum += n % 10;
            and *= n % 10;
            n = n / 10;
        }
        return and - sum;
    }

    public static void main(String[] args) {
        System.out.println(subtractProductAndSum(4421));
    }
}
