package leetcode;

/**
 * Copyright (C), 2018-2019
 * FileName: leetcode.strStr
 * Author:   xjl
 * Date:     2019/10/28 10:47
 * Description: 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1
 */

public class strStr {
    public static int strStr(String haystack, String needle) {
        if(haystack.length()==0||needle.length()==0){return -1;};
        char[] list1=haystack.toCharArray();
        char[] list2=needle.toCharArray();
        for (int i=0;i<list1.length;i++){
            for(int j=0;j<list2.length;j++){

            }
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(strStr("hello","ll"));
    }
}
