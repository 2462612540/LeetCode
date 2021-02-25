/**
 * Copyright (C), 2018-2020
 * FileName: 丑数判断
 * Author:   xjl
 * Date:     2020/9/6 9:48
 * Description:
 */
package 计算机程序算法分类.数学问题;

public class 丑数判断 {

    public int nthUglyNumber(int n) {
        if (n == 0) {
            return 0;
        }
        int[] a = new int[n];
        a[0] = 1;
        int index1 = 0;   //遍历丑数的*2的队列
        int index2 = 0;   //遍历*3的队列
        int index3 = 0;   //遍历*5的队列
        for (int i = 1; i < n; i++) {
            //选择最小的一个
            a[i] = Math.min(Math.min(a[index1] * 2, a[index2] * 3), a[index3] * 5);
            //更新遍历三个对队列的下标 根据放置在第i个位置的时候
            if (a[i] == a[index1] * 2) {
                index1++;
            }
            if (a[i] == a[index2] * 3) {
                index2++;
            }
            if (a[i] == a[index3] * 5) {
                index3++;
            }
        }
        return a[n - 1];
    }

    /**
     * 判断一个数字是否为丑数
     *
     * @param n
     * @return
     */
    public boolean isugly(int n) {
        if (n <= 0) return false;
        while (n % 2 == 2) {
            n = n / 2;
        }
        while (n % 2 == 3) {
            n = n / 3;
        }
        while (n % 2 == 5) {
            n = n / 5;
        }
        return n == 1;
    }

}
