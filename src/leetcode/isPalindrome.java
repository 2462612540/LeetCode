/**
 * Copyright (C), 2018-2020
 * FileName: isPalindrome
 * Author:   xjl
 * Date:     2020/2/29 10:29
 * Description: 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */
package leetcode;

/**
 * 思路1 如果是负数直接返回false
 *     2 如果大于0则表示
 */
public class isPalindrome {
    public static boolean isPalindrome(int x) {
        int a=x;
        int result=0;
        if(x<0){
            return false;
        }else {
            while(x != 0) {
                result = result*10 + x%10;
                x = x/10;
            }
            return result==a;
        }
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome(-1210));
    }
}
