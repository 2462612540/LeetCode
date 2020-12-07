/**
 * Copyright (C), 2018-2020
 * FileName: 求m和n的最小公倍数
 * Author:   xjl
 * Date:     2020/9/6 9:49
 * Description:
 */
package 数学问题;

public class 求m和n的最小公倍数 {

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
}
