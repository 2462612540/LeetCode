/**
 * Copyright (C), 2018-2020
 * FileName: twonumber_big_sum
 * Author:   xjl
 * Date:     2020/7/23 21:21
 * Description: 一个栈依次压入1,2,3,4,5，那么从栈顶到栈底分别为5,4,3,2,1。将这个栈转置后，从栈顶到栈底为1,2,3,4,5，也就是实现栈中元素的逆序，但是只能用递归函数来实现，不能用其他数据结构。
 */
package leetcode;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //数据的读取
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        sc.nextLine();
        String[] s = sc.nextLine().split(" ");
        //函数的调用
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            sb.append(s[i] + " ");
        }
        //结果的输出
        System.out.println(sb.toString().trim());
    }
}
