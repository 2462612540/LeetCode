/**
 * Copyright (C), 2018-2020
 * FileName: climbStairs
 * Author:   xjl
 * Date:     2020/3/1 13:55
 * Description: 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。  每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
package leetcode练习题;

/**
 * 典型的斐波拉西数列的问题
 */
public class climbStairs {
    public static int climbStairs(int n) {
        int sum = 0;
        int a = 0, b = 1;
        for (int i = 0; i < n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(1));
    }

}
