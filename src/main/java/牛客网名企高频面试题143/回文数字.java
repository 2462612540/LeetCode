package 牛客网名企高频面试题143;

import org.junit.Test;

/**
 * @Classname 回文数字
 * @Description TODO
 * @Date 2020/12/11 19:47
 * @Created by xjl
 */
public class 回文数字 {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else {
            if (x == Double.valueOf(new StringBuilder(String.valueOf(x)).reverse().toString())) {
                return true;
            } else {
                return false;
            }
        }
    }

    @Test
    public void test() {
        boolean palindrome = isPalindrome(2147483647);
        System.out.println(palindrome);
    }
}
