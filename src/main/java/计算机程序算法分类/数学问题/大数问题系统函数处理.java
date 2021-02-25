/**
 * Copyright (C), 2018-2020
 * FileName: 大数问题系统函数处理
 * Author:   xjl
 * Date:     2020/9/6 9:42
 * Description:
 */
package 计算机程序算法分类.数学问题;

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
public class 大数问题系统函数处理 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        BigInteger x1 = new BigInteger(str1);
        BigInteger x2 = new BigInteger(str2);
        //相加
        BigInteger sum = x1.add(x2);
        System.out.println(x1.add(x2));
        //相乘
        BigInteger and = x1.multiply(x2);
        System.out.println(and);
    }
}
