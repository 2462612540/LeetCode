package 名企高频面试题143; /**
 * Copyright (C), 2018-2020
 * FileName: 名企高频面试题143.大数字相加
 * Author:   xjl
 * Date:     2020/9/30 22:32
 * Description:
 */


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

    public String solve2(String num1, String num2) {
        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;
        int carry = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (index1 >= 0 && index2 >= 0) {
            int sum = (num1.charAt(index1) - '0') + (num2.charAt(index2) - '0') + carry;
            carry = sum / 10;
            stringBuilder.append(sum % 10);
            index1--;
            index2--;
        }
        while (index1 >= 0) {
            int sum = (num1.charAt(index1) - '0') + carry;
            carry = sum / 10;
            stringBuilder.append(sum % 10);
            index1--;
        }
        while (index2 >= 0) {
            int sum = (num2.charAt(index2) - '0') + carry;
            carry = sum / 10;
            stringBuilder.append(sum % 10);
            index2--;
        }
        if (carry == 1) {
            stringBuilder.append(1);
        }
        return stringBuilder.reverse().toString();
    }
}
