/**
 * Copyright (C), 2018-2020
 * FileName: isFlipedString
 * Author:   xjl
 * Date:     2020/3/4 12:28
 * Description: 字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）
 */
package leetcode;

public class isFlipedString {
    public static boolean isFlipedString(String s1, String s2) {
        if (s1.length()!=s2.length()) return false;
        String ss = s2+s2;
        return ss.contains(s1);
    }
    public static void main(String[] args) {
        String s1="waterbottle",s2="erbottlewat";
        System.out.println(isFlipedString(s1,s2));
    }
}
