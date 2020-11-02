/**
 * Copyright (C), 2018-2020
 * FileName: 大数字相加
 * Author:   xjl
 * Date:     2020/9/30 22:32
 * Description:
 */
package 牛客面试必会100题;

import java.math.BigDecimal;

public class 大数字相加 {
    /**
     * 使用的是的一一个系统的函数
     *
     * @param s
     * @param t
     * @return
     */
    public String solve(String s, String t) {
        BigDecimal a = new BigDecimal(s);
        BigDecimal b = new BigDecimal(t);
        return a.add(b).toString();
    }

    /**
     * 利用的字串串的相加
     */

    public String solve1(String num1, String num2) {
        String result = "";
        int curr = 0;
        int n1 = num1.length() - 1;
        int n2 = num2.length() - 1;
        int x = 0, y = 0;
        while (n1 >= 0 || n2 >= 0) {
            if (n1 < 0) {
                x = 0;
            } else {
                x = num1.charAt(n1) - '0';
            }
            if (n2 < 0) {
                y = 0;
            } else {
                y = num2.charAt(n2) - '0';
            }
            result += String.valueOf((x + y + curr) % 10);
            curr = (x + y + curr) / 10;
            n1--;
            n2--;
        }
        if (curr == 1) {
            result += "1";
        }
        return new StringBuffer(result).reverse().toString();
    }

}
