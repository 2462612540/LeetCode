/**
 * Copyright (C), 2018-2020
 * FileName: cuttingRope
 * Author:   xjl
 * Date:     2020/4/5 11:11
 * Description: 剪绳子
 */
package Leetcode_Medium_difficulty;

import org.junit.Test;

public class cuttingRope {
    public int cuttingRope(int n) {
        if (n <= 3) return n - 1;
        int a = n / 3;
        int b = n % 3;
        if (b == 0) return (int) Math.pow(3, a);
        if (b == 1) return (int) Math.pow(3, a - 1) * 4;
        return (int) Math.pow(3, a) * 2;
    }

    @Test
    public void test() {
        System.out.println(cuttingRope(8));
    }

}
