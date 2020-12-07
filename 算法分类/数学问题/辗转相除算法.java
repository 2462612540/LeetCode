/**
 * Copyright (C), 2018-2020
 * FileName: 辗转相除算法
 * Author:   xjl
 * Date:     2020/9/6 9:51
 * Description:
 */
package 数学问题;

import java.util.Scanner;

public class 辗转相除算法 {
    // 最大公约数
    public static int get_gcd(int m, int n) {
        int result = 0;
        while (n != 0) {
            result = m % n;
            m = n;
            n = result;
        }
        return m;
    }

    // 最小公倍数
    public static int get_lcm(int n1, int n2) {
        return n1 * n2 / get_gcd(n1, n2);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入第一个整数：");
        int n1 = input.nextInt();
        System.out.print("请输入第二个整数：");
        int n2 = input.nextInt();
        if (n1 > n2) {
            get_gcd(n1, n2);
            get_lcm(n1, n2);
        } else {
            get_gcd(n2, n1);
            get_lcm(n2, n1);
        }
        System.out.println("(" + n1 + "," + n2 + ")" + "=" + get_gcd(n1, n2));
        System.out.println("[" + n1 + "," + n2 + "]" + "=" + get_lcm(n1, n2));
    }
}
