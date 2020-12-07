/**
 * Copyright (C), 2018-2020
 * FileName: compressString
 * Author:   xjl
 * Date:     2020/3/4 11:55
 * Description: 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）
 */
package leetcode;

public class compressString {
    public static String compressString(String S) {
        if(S.length()==0){
            return S;
        }
        String s = "";
        int count = 1;
        for (int i = 1; i <S.length(); i++) {
            if (S.charAt(i) == S.charAt(i - 1)) {
                count++;
            } else {
                s += S.charAt(i - 1) + String.valueOf(count);
                count = 1;
            }
        }
        s += S.charAt(S.length()-1) + String.valueOf(count);
        if (s.length()>= S.length()) {
            return S;
        }else {
            return s;
        }
    }

    public static void main(String[] args) {
        System.out.println(compressString("aabcccccaa"));
    }
}
