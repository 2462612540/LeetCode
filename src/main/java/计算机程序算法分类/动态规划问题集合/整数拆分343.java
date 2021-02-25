/**
 * Copyright (C), 2018-2020
 * FileName: 整数拆分343
 * Author:   xjl
 * Date:     2020/9/7 14:04
 * Description:
 */
package 计算机程序算法分类.动态规划问题集合;

public class 整数拆分343 {
    /**
     * 分割两个部分 这是一个递归问题 时间hi超过限制  可能需要采用的记忆化递归的算法
     *
     * @param n
     * @return
     */
    static int[] array;

    public static int integerBreak(int n) {
        array = new int[n + 1];
        return test(n);
    }

    /**
     * 这个超过时间限制 也是使用了记忆化搜索的
     *
     * @param n
     * @return
     */
    public static int test(int n) {
        if (n == 1) {
            return 1;
        }
        if (array[n] != 0) {
            return array[n];
        }
        int res = -1;
        //能分割多少的中的方法嗯？
        for (int i = 1; i <= n - 1; i++) {
            res = Math.max(res, Math.max(i * (n - i), i * test(n - i)));
        }
        return res;
    }

    /**
     * 记忆化搜索
     *
     * @param n
     * @return
     */
    public static int integerBreak1(int n) {
        array = new int[n + 1];
        array[1] = 1;
        for (int i = 2; i <= n; i++) {
            //求解array[i] 将 i 进行分割 j i-j这的两个
            for (int j = 1; j <= i - 1; j++) {
                // j+(i-j)
                //计算 i的分割的最大的值保留  array[i - j]前面已经计算出来了所以是
                array[i] = Math.max(Math.max(j * (i - j), j * array[i - j]), array[i]);
            }
        }
        return array[n];
    }

    public static void main(String[] args) {
        int i = integerBreak1(30);
        System.out.println(i);
    }
}
