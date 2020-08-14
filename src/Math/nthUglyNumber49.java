/**
 * Copyright (C), 2018-2020
 * FileName: nthUglyNumber49
 * Author:   xjl
 * Date:     2020/8/14 14:41
 * Description: 丑数
 */
package Math;

public class nthUglyNumber49 {

    /**
     * 第三题目：给定一个正整数 问能否有多个 2 5 7 相乘得到 如果可以表示的返回为1 如果不行范围为0
     */
    public int test3(int N) {
        if (N < 2) {
            return 0;
        }
        while (N % 2 == 0)
            N /= 2;
        while (N % 3 == 0)
            N /= 3;
        while (N % 5 == 0)
            N /= 5;
        if (N == 1) {
            return 1;
        } else {
            return 0;
        }
    }

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

    public int nthUglyNumber(int n, int a, int b, int c) {
        long ab = zuixiaogongbei((long) a, (long) b);
        long bc = zuixiaogongbei((long) b, (long) c);
        long ac = zuixiaogongbei((long) a, (long) c);
        long abc = zuixiaogongbei(ab, (long) c);
        //二分法
        long zuo = 1;
        long you = 2000000000;
        while (zuo < you) {
            long mid = zuo + (you - zuo) / 2;
            long p = mid / a + mid / b + mid / c - mid / ab - mid / ac - mid / bc + mid / abc;
            if (p > n) {
                you = mid - 1;
            } else if (p < n) {
                zuo = mid + 1;
            } else {
                you = mid;
            }
        }
        return (int) zuo;
    }

    public long zuixiaogongbei(long m, long n) {
        //求m和n的最小公倍数
        long max = Math.max(m, n);
        long min = m + n - max;
        if (m > 1 && n > 1 && m != n) {
            while (max % min != 0) {
                long yu = max % min;
                max = min;
                min = yu;
            }
            //上面最终的除数是最大公约数，最小公倍数等于乘积除以最大公约数
            return m * n / min;
        }
        return (long) Math.max(m, n);
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
