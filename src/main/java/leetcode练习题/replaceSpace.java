/**
 * Copyright (C), 2018-2020
 * FileName: replaceSpace
 * Author:   xjl
 * Date:     2020/3/5 11:56
 * Description: 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 */
package leetcode练习题;

public class replaceSpace {
    public static String replaceSpace(String s) {
        String S="";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                S+="%20";
            }else {
                S+=s.charAt(i);
            }
        }
        return S;
    }

    public static void main(String[] args) {

    }
}
