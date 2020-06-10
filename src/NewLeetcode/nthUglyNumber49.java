/**
 * Copyright (C), 2018-2020
 * FileName: nthUglyNumber49
 * Author:   xjl
 * Date:     2020/6/10 14:01
 * Description: 丑数
 */
package NewLeetcode;

import org.junit.Test;

public class nthUglyNumber49 {
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
            a[i] = Math.min(Math.min(a[index1] * 2, a[index2] * 3), a[index3] * 5);
            //更新遍历三个对队列的下标
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

    public boolean isugly(int n) {
        while (n % 2 == 0)
            n /= 2;
        while (n % 3 == 0)
            n /= 3;
        while (n % 5 == 0)
            n /= 5;
        return n == 1;
    }

    @Test
    public void test() {
        //nthUglyNumber(10);
        boolean isugly = isugly(10);
        System.out.println(isugly);
    }
}
