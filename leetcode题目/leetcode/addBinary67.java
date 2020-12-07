/**
 * Copyright (C), 2018-2020
 * FileName: addBinary67
 * Author:   xjl
 * Date:     2020/6/23 8:52
 * Description: 67. 二进制求和
 */
package leetcode;

import org.junit.Test;

/**
 * 二进制求和
 */
public class addBinary67 {
    public String addBinary(String a, String b) {
        int n1 = a.length() - 1;
        int n2 = b.length() - 1;
        int carry = 0;
        StringBuilder result = new StringBuilder();
        while (n1 >= 0 && n2 >= 0) {
            int sum = a.charAt(n1) - '0' + b.charAt(n2) - '0' + carry;
            carry = sum / 2;
            sum %= 2;
            result.append(sum);
            n1--;
            n2--;
        }
        while (n1 >= 0) {
            int sum = a.charAt(n1) - '0' + carry;
            carry = sum / 2;
            sum %= 2;
            result.append(sum);
            n1--;
        }
        while (n2 >= 0) {
            int sum = b.charAt(n2) - '0' + carry;
            carry = sum / 2;
            sum %= 2;
            result.append(sum);
            n2--;
        }
        if (carry > 0) {
            result.append(carry);
        }
        return result.reverse().toString();
    }

    @Test
    public void test() {
        String s = addBinary("1010", "1011");
        System.out.println(s);
    }

}
