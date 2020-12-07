/**
 * Copyright (C), 2018-2020
 * FileName: myAtoi
 * Author:   xjl
 * Date:     2020/3/15 15:07
 * Description: 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 */
package leetcode;

import org.junit.Test;

public class myAtoi {
    public int myAtoi(String str) {
        int flag = 0;
        String s1 = "";
        float sum = 0;
        for (int i = 0; i < str.length(); i++) {
            //除去空格
            if (str.charAt(i) != ' ') {
                s1 += str.charAt(i);
            }
        }
        if (s1.length() == 0) {
            return 0;
        }
        if (s1.charAt(0) >= 'a' && s1.charAt(0) <= 'z') {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == '-') {
                flag = 1;
                count++;
                continue;
            }
            if (s1.charAt(i) == '+') {
                count++;
                flag = 0;
                continue;
            }
            if (count == 2) {
                break;
            }
            if (s1.charAt(i) >= 'a' && s1.charAt(i) <= 'z' || s1.charAt(i) == '.') {
                break;
            } else {
                sum = sum * 10 + (s1.charAt(i) - '0');
            }
        }
        if (flag == 1) {
            sum = sum * -1;
        }
        if (sum < Integer.MIN_VALUE) {
            sum = Integer.MIN_VALUE;
        }
        return (int) sum;
    }

    public int myAtoi2(String str) {
        if (str == null) {
            return 0;
        }
        int n = str.length();
        int i = 0;
        int res = 0;
        boolean is_negative = false;
        //第一步，跳过前面若干个空格
        while (i < n && str.charAt(i) == ' ') {
            ++i;
        }
        //如果字符串全是空格直接返回
        if (i == n) {
            return 0;
        }
        //第二步，判断正负号
        if (str.charAt(i) == '-') {
            is_negative = true;
        }
        //如果是正负号，还需要将指针i，跳过一位
        if (str.charAt(i) == '-' || str.charAt(i) == '+') {
            ++i;
        }
        while (i < n && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            //'0'的ASCII码是48，'1'的是49，这么一减就从就可以得到真正的整数值
            int tmp = str.charAt(i) - '0';
            //判断是否大于 最大32位整数
            if (!is_negative && (res > Integer.MAX_VALUE || (res == Integer.MAX_VALUE && tmp >= 7))) {
                return Integer.MAX_VALUE;
            }
            //判断是否小于最小32位整数
            if (is_negative && (-res < Integer.MIN_VALUE || (-res == Integer.MIN_VALUE && tmp >= 8))) {
                return Integer.MIN_VALUE;
            }
            res = res * 10 + tmp;
            ++i;
        }
        //如果有负号标记则返回负数
        if(is_negative) {
            return -res;
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(myAtoi("+-2"));
    }
}
