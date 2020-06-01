/**
 * Copyright (C), 2018-2020
 * FileName: findString
 * Author:   xjl
 * Date:     2020/3/4 14:29
 * Description: 稀疏数组搜索。有个排好序的字符串数组，其中散布着一些空字符串，编写一种方法，找出给定字符串的位置
 */
package leetcode;

public class findString {
    public static int findString(String[] words, String s) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(s)) {
                return i ;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] words = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
        String s = "ball";
        System.out.println(findString(words, s));
    }
}
