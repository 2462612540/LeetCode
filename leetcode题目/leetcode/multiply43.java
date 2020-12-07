/**
 * Copyright (C), 2018-2020
 * FileName: multiply43
 * Author:   xjl
 * Date:     2020/8/13 16:07
 * Description:
 */
package leetcode;

import org.junit.Test;

import java.math.BigInteger;

public class multiply43 {

    public String multiply(String num1, String num2) {
        return new BigInteger(num1).multiply(new BigInteger(num2)).toString();
    }

    /**
     * 利用的数学的方法
     *
     * @param num1
     * @param num2
     * @return
     */
    public String multiply2(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        //num[i]* num2[j]:  res[i+j+1]      res[i+j]
        int n = num1.length();
        int m = num2.length();

        int[] res = new int[n + m];
        // 从右往左遍历乘数，将乘数的每一位与被乘数相乘得到对应的结果，再将每次得到的结果累加
        for (int i = n - 1; i >= 0; i--) {
            int a = num1.charAt(i) - '0';
            for (int j = m - 1; j >= 0; j--) {
                int b = num2.charAt(j) - '0';
                //计算两个数的结果 放置在最后的一个位置上
                res[i + j + 1] += a * b;
                // 这个时表示的求进位
                res[i + j] = res[i + j] + res[i + j + 1] / 10;
                //表示的进位
                res[i + j + 1] %= 10;
            }
        }
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (res[i] == 0) {
            i++;
        }
        for (; i < res.length; i++) {
            result.append(res[i]);
        }
        return result.toString();
    }

    @Test
    public void test() {
        String multiply = multiply2("1234", "567");
        System.out.println(multiply);
    }
}
