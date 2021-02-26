package 牛客网名企高频面试题2020; /**
 * Copyright (C), 2018-2020
 * FileName: 名企高频面试题143.翻转数字
 * Author:   xjl
 * Date:     2020/9/29 10:46
 * Description:
 */

import org.junit.Test;

public class 翻转数字 {
    public int reverse(int x) {
        StringBuilder s = new StringBuilder(String.valueOf(x));
        if (s.charAt(0) == '-') {
            return -1 * Integer.valueOf(new StringBuilder(String.valueOf(x).substring(1, String.valueOf(x).length())).reverse().toString());
        } else {
            return Integer.valueOf(s.reverse().toString());
        }
    }

    @Test
    public void test() {
        int reverse = reverse(-281050);
        System.out.println(reverse);
    }
}
