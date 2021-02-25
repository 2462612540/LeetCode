package 牛客网名企高频面试题143; /**
 * Copyright (C), 2018-2020
 * FileName: 名企高频面试题143.大数相乘
 * Author:   xjl
 * Date:     2020/10/1 8:50
 * Description:
 */


import org.junit.Test;

import java.math.BigDecimal;

public class 大数相乘 {

    @Test
    public void test() {
        String s = solve1("3", "555");
        System.out.println(s);
    }

    public String solve1(String s, String t) {
        if (s.equals("0") || t.equals("0"))
            return "0";
        int len1 = s.length();
        int len2 = t.length();
        //两个数字相乘的结果的位数的是两个数的和
        int[] ans = new int[len1 + len2];
        //计算的是每一个的位置的上的结果
        for (int i = len1 - 1; i >= 0; i--) {
            int x = s.charAt(i) - '0';
            for (int j = len2 - 1; j >= 0; j--) {
                int y = t.charAt(j) - '0';
                ans[i + j + 1] += x * y;
            }
        }
        //计算统一来进行的进位计算
        for (int i = len1 + len2 - 1; i > 0; i--) {
            ans[i - 1] += ans[i] / 10;
            ans[i] %= 10;
        }

        StringBuilder res = new StringBuilder();
        int index = ans[0] == 0 ? 1 : 0;
        while (index < len1 + len2) {
            res.append(ans[index]);
            index++;
        }
        return res.toString();
    }

    /**
     * 利用的系统的函数
     *
     * @param s
     * @param t
     * @return
     */
    public String solve(String s, String t) {
        return new BigDecimal(s).multiply(new BigDecimal(t)).toString();
    }
}
