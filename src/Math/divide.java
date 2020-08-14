/**
 * Copyright (C), 2018-2020
 * FileName: divide
 * Author:   xjl
 * Date:     2020/8/14 13:20
 * Description: 相除
 */
package Math;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class divide {

    public int divide(int dividend, int divisor) {
        long d1 = dividend;
        long d2 = divisor;
        //首先将这个值全部变成正数
        if (d1 < 0) d1 = -d1;
        if (d2 < 0) d2 = -d2;
        //设置为被除数
        long cur = d2;

        List<Long> list1 = new ArrayList<>();
        List<Long> list2 = new ArrayList<>();

        long bei = 1;
        while (cur <= d1) {
            list1.add(cur);
            list2.add(bei);
            cur += cur;
            bei += bei;
        }
        long res = 0;

        for (int i = list1.size() - 1; i >= 0; i--) {
            if (list1.get(i) <= d1) {
                res += list2.get(i);
                d1 -= list1.get(i);
            }
        }
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) res = -res;
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return Integer.MAX_VALUE;
        return (int) res;
    }

    @Test
    public void test(){
        int divide = divide(10, 3);
        System.out.println(divide);
    }
}
