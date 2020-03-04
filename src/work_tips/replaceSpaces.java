/**
 * Copyright (C), 2018-2020
 * FileName: replaceSpaces
 * Author:   xjl
 * Date:     2020/3/4 9:06
 * Description: URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。（注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
 */
package work_tips;

/**
 * length是空壳的长度
 */

public class replaceSpaces {
    public static String replaceSpaces(String S, int length) {
        String s1 = "";
        char[] c = S.toCharArray();
        if (S.length() <= 500000) {
            for (int i = 0; i < length; i++) {
                if (c[i] == ' ') {
                    s1 += "%20";
                } else {
                    s1 += c[i];
                }
            }
        }
        return s1;
    }

    public static String replaceSpaces2(String S, int length) {

        return null;
    }

    public static String replaceSpaces3(String S, int length) {

        return null;
    }

    public static void main(String[] args) {
        String s = "               ";
        replaceSpaces3(s, 5);

    }
}
