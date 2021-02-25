/**
 * Copyright (C), 2018-2020
 * FileName: maxnumber
 * Author:   xjl
 * Date:     2020/4/20 13:16
 * Description: 最大数字
 */
package leetcode练习题;

import org.junit.Test;

public class maxnumber {
    public int maxnumber(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }

    @Test
    public void test() {
        System.out.println(maxnumber(3, 5, 8));
    }
}
