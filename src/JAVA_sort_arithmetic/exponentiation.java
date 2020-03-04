/**
 * Copyright (C), 2018-2020
 * FileName: exponentiation
 * Author:   xjl
 * Date:     2020/3/4 17:29
 * Description: 求解一个数2的整数的幂
 */
package JAVA_sort_arithmetic;

/**
 * 求解一个数2的整数的幂
 */
public class exponentiation {

    public static void main(String[] args) {
        int n = 1025;
        //这是利用了与的运算符的法则 这是二进制的法则
        System.out.println(n & (n - 1));
    }

}
