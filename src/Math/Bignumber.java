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
 *    相减：subtract(BigInteger val);
 *    相乘：multiply(BigInteger val);
 *    相除：divide(BigInteger val);
 *    最大公约数：gcd(BigInteger val);
 *    取模：mod(BigInteger val);
 *    N次方：pow(int exponent);
 *
 */
public class Bignumber {
    public static void main(String[] args) {
        //相加
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        BigInteger x1 = new BigInteger(str1);
        BigInteger x2 = new BigInteger(str2);
        //相加
        BigInteger sum = x1.add(x2);
        System.out.println(x1.add(x2));
        //相乘
        BigInteger and=x1.multiply(x2);
        System.out.println(and);
    }
}
