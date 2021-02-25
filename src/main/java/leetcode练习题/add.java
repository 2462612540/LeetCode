/**
 * Copyright (C), 2018-2020
 * FileName: add
 * Author:   xjl
 * Date:     2020/4/2 15:04
 * Description: 面试题65. 不用加减乘除做加法
 */
package leetcode练习题;

import org.junit.Test;

public class add {
    public int add(int a, int b) {
        while (a != 0) {
            /**
             *
             *与运算符用符号“&”表示，其使用规律如下：
             * 两个操作数中位都为1，结果才为1，否则结果为0，例如下面的程序段。
             *
             * 或运算符用符号“|”表示，其运算规律如下：
             * 两个位只要有一个为1，那么结果就是1，否则就为0，下面看一个简单的例子。
             *
             * 非运算符用符号“~”表示，其运算规律如下：
             * 如果位为0，结果是1，如果位为1，结果是0，下面看一个简单例子。
             *
             * 异或运算符是用符号“^”表示的，其运算规律是：
             * 两个操作数的位中，相同则结果为0，不同则结果为1。
             *
             */
            int temp = a ^ b;
            a = (a & b) << 1;
            b = temp;
        }
        return b;
    }

    @Test
    public void test() {
        add(3,41);
    }
}
