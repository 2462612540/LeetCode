/**
 * Copyright (C), 2018-2020
 * FileName: sumNums64
 * Author:   xjl
 * Date:     2020/6/2 8:18
 * Description: 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
 */
package NewLeetcode;

import org.junit.Test;

public class sumNums64 {
    public int sumNums(int n) {
        return n * (n + 1) / 2;
    }

    public int sumNums1(int n) {
        //使用了while关键字
        int sum = 0;
        while (n >= 1) {
            sum = test(sum, n--);
        }
        return sum;
    }

    public int test(int a, int b) {
        /**
         * 其中的<<1 表示的是的左移以为  例如：  0111 010<<2 表示的是的1101 0100
         */
        while (a != 0) {
            int temp = a ^ b;
            a = (a & b) << 1;
            b = temp;
        }
        return b;
    }

    //采用的是递归的手段来实现 但是最好是不采用这样一种手法避免栈溢出的一种方式
    public int sumNums2(int n) {
        return n == 0 ? 0 : n + sumNums(n - 1);
    }

    public int sumNums3(int n) {
        boolean x = n > 1 && (n += sumNums3(n - 1)) > 0;
        return n;
    }


    @Test
    public void test() {
        int count = sumNums3(9);
        System.out.println(count);
    }
}
