/**
 * Copyright (C), 2018-2020
 * FileName: isPalindrome2
 * Author:   xjl
 * Date:     2020/3/1 15:34
 * Description: 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 */
package simple_difficulty;

/**
 * 数组顺序遍历和道路遍历能够全部走完表示回文
 * 利用双指针来做
 */
public class isPalindrome2 {
    public static  boolean isPalindrome(String s) {
        char[] char1=s.toLowerCase().toCharArray();
        int i=char1.length-1;
        int j=0;
        while (i<j){
            if(char1[i]==char1[j]){
                i++;
                j--;
            }else {
                i++;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s="A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }
}
