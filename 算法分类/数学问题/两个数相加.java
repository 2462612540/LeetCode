/**
 * Copyright (C), 2018-2020
 * FileName: 两个数相加
 * Author:   xjl
 * Date:     2020/9/5 20:38
 * Description:
 */
package 数学问题;

import org.junit.Test;

public class 两个数相加 {

    @Test
    public void test() {
        String s = addStrings("99", "99");
        System.out.println(s);
    }

    public String addStrings(String num1, String num2) {
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
