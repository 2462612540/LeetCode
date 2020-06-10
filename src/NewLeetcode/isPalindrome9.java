/**
 * Copyright (C), 2018-2020
 * FileName: isPalindrome9
 * Author:   xjl
 * Date:     2020/6/10 7:49
 * Description: 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */
package NewLeetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class isPalindrome9 {
    public boolean isPalindrome(int x) {
        int a = x;
        int result = 0;
        if (x < 0) {
            return false;
        } else {
            while (x != 0) {
                result = result * 10 + x % 10;
                x = x / 10;
            }
            return result == a;
        }
    }

    public boolean isPalindrome1(int x) {
        String s = String.valueOf(x);
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void resves() {
        List<Character> list = new ArrayList();
        list.add('-');
        list.add('1');
        list.add('5');
        list.add('6');
        list.add('+');
        Collections.reverse(list);
        for (char v : list) {
            System.out.println(v);
        }
    }

    @Test
    public void test() {
        boolean palindrome = isPalindrome(-121);
        System.out.println(palindrome);
    }
}
