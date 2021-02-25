/**
 * Copyright (C), 2018-2020
 * FileName: validPalindrome680
 * Author:   xjl
 * Date:     2020/5/19 10:29
 * Description: 验证回文字符串 Ⅱ
 */
package leetcode练习题;

import org.junit.Test;

public class validPalindrome680 {
    public boolean validPalindrome1(String s) {
        return validPalindrome(s, 0, s.length() - 1, 1);
    }

    private boolean validPalindrome(String s, int left, int right, int chance) {
        if (left > right) {
            return true;
        }
        if (s.charAt(left) == s.charAt(right)) {
            return validPalindrome(s, left + 1, right - 1, chance);
        } else {
            if (chance == 0) {
                return false;
            }
            return validPalindrome(s, left, right - 1, chance - 1) || validPalindrome(s, left + 1, right, chance - 1);
        }

    }

    public boolean validPalindrome(String s) {
        int low = 0, high = s.length() - 1;
        while (low < high) {
            char c1 = s.charAt(low), c2 = s.charAt(high);
            if (c1 == c2) {
                low++;
                high--;
            } else {
                //删除左边和删除右边的两个不同的方法
                boolean flag1 = true, flag2 = true;
                for (int i = low, j = high - 1; i < j; i++, j--) {
                    char c3 = s.charAt(i), c4 = s.charAt(j);
                    if (c3 != c4) {
                        flag1 = false;
                        break;
                    }
                }
                for (int i = low + 1, j = high; i < j; i++, j--) {
                    char c3 = s.charAt(i), c4 = s.charAt(j);
                    if (c3 != c4) {
                        flag2 = false;
                        break;
                    }
                }
                return flag1 || flag2;
            }
        }
        return true;
    }

    @Test
    public void test() {
        boolean result = validPalindrome("abacd");
        System.out.println(result);
    }
}
