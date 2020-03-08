/**
 * Copyright (C), 2018-2020
 * FileName: factorial
 * Author:   xjl
 * Date:     2020/3/6 11:16
 * Description: 递归调用的算法
 */
package JAVA_sort_arithmetic.src.high_sort;

public class factorial {
    public static void main(String[] args) {
        System.out.println(factorial2(20));
    }

    public static long factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            //递归的调用
            return n * factorial(n - 1);
        }
    }

    public static int factorial2(int n) {
        long sum = 1;
        for (int i = n; i > 0; i--) {
            sum *= i;
        }
        return (int) sum;
    }

}
