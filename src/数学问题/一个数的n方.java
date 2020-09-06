/**
 * Copyright (C), 2018-2020
 * FileName: 一个数的n方
 * Author:   xjl
 * Date:     2020/9/6 9:45
 * Description:
 */
package 数学问题;

import org.junit.Test;

public class 一个数的n方 {

    double quickMul(double x, long N) {
        double ans = 1.0;
        // 贡献的初始值为 x
        double x_contribute = x;
        // 在对 N 进行二进制拆分的同时计算答案
        while (N > 0) {
            if (N % 2 == 1) {
                // 如果 N 二进制表示的最低位为 1，那么需要计入贡献
                ans *= x_contribute;
            }
            // 将贡献不断地平方
            x_contribute *= x_contribute;
            // 舍弃 N 二进制表示的最低位，这样我们每次只要判断最低位即可
            N /= 2;
        }
        return ans;
    }

    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    double mypowhand(double x, long n) {
        //递归的出口
        if (n == 1) {
            return x;
        }
        //分为奇和偶数的情况去递归的实现
        if (n % 2 != 0) {
            double half = mypowhand(x, n / 2);
            return half * half * x;
        } else {
            double half = mypowhand(x, n / 2);
            return half * half;
        }
    }

    //主要的函数
    double mypow(double x, int n) {
        if (n == 0 || x == 1) {
            return 1;
        }
        if (n < 0) {
            return 1 / mypowhand(x, Math.abs(n));
        }
        return mypowhand(x, n);
    }

    @Test
    public void test() {
        double mypow = mypow(2, -2147483648);
        System.out.println(mypow);
    }
}
