/**
 * Copyright (C), 2018-2020
 * FileName: isHappy
 * Author:   xjl
 * Date:     2020/3/3 12:43
 * Description: 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 */
package leetcode练习题;

public class isHappy {
    public static boolean isHappy(int n) {
        int s=n;
        while (n != 1) {
            char[] c = String.valueOf(n).toCharArray();
            int number = 0;
            for (int i = 0; i < c.length; i++) {
                number += (c[i] - '0') * (c[i] - '0');
            }
            if(number==s){
                return false;
            }else {
                n=number;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(2));
    }
}
