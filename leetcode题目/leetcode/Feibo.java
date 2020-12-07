/**
 * Copyright (C), 2018-2020
 * FileName: Feibo
 * Author:   xjl
 * Date:     2020/7/23 21:39
 * Description: 给出一个整数 n，代表台阶数，一次可以跨 2 个或者 1 个台阶，请输出有多少种走法。
 */
package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Feibo {
    static long mod = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.valueOf(bf.readLine());
        if (n == 0)
            System.out.println(0);
        if (n == 1 || n == 2)
            System.out.println(1);
        long[][] base = {{1, 1}, {1, 0}};
        long[][] res = fib(base, n - 2);

        System.out.println((2 * res[0][0] + res[1][0]) % mod);
    }

    //求一个矩阵的n次方
    private static long[][] fib(long[][] m, long n) {
        long[][] res = new long[m.length][m[0].length];
        for (int i = 0; i < m.length; i++)
            res[i][i] = 1;
        long[][] temp = m;
        for (; n > 0; n = n >> 1) {
            if ((n & 1) == 1) {
                res = matMultiply(res, temp);
            }
            temp = matMultiply(temp, temp);
        }
        return res;
    }

    public static long[][] matMultiply(long[][] mat1, long[][] mat2) {
        long[][] res = new long[mat1.length][mat2[0].length];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                for (int k = 0; k < mat1[0].length; k++) {
                    res[i][j] += mat1[i][k] * mat2[k][j];
                    res[i][j] %= mod;
                }
            }
        }
        return res;
    }
}
