/**
 * Copyright (C), 2018-2020
 * FileName: Bignumber
 * Author:   xjl
 * Date:     2020/7/28 16:25
 * Description: 大整数
 */
package Math;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 相加：add(BigInteger val);
 * 相减：subtract(BigInteger val);
 * 相乘：multiply43(BigInteger val);
 * 相除：divide(BigInteger val);
 * 最大公约数：gcd(BigInteger val);
 * 取模：mod(BigInteger val);
 * N次方：pow(int exponent);
 */
public class Bignumber {
    public static void main(String[] args) {
        //相加
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().trim().replace("\"", "").split(",");
        BigInteger x1 = new BigInteger(str[0]);
        BigInteger x2 = new BigInteger(str[1]);
        //相乘
        BigInteger and = x1.multiply(x2);
        System.out.println(and);
    }

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int n = num1.length();
        int m = num2.length();
        int[] res = new int[n + m];
        for (int i = n - 1; i >= 0; i--) {
            int a = num1.charAt(i) - '0';
            for (int j = m - 1; j >= 0; j--) {
                int b = num2.charAt(j) - '0';
                res[i + j + 1] += a * b;
                res[i + j] += res[i + j + 1] / 10;
                res[i + j + 1] %= 10;
            }
        }
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (res[i] == 0) {
            i++;
        }
        for (; i < res.length; i++) {
            result.append(res[i]);
        }
        return result.toString();
    }
}
