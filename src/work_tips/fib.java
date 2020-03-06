/**
 * Copyright (C), 2018-2020
 * Filename: fib
 * Author:   xjl
 * Date:     2020/3/5 12:04
 * Description: 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
 */
package work_tips;

public class fib {
    public static int fib2(int n) {
        if (n == 1) {
            return 1;
        }
        int a = 0, b = 1;
        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(fib2(5));
    }
}
