/**
 * Copyright (C), 2018-2020
 * FileName: strStr
 * Author:   xjl
 * Date:     2020/2/29 18:07
 * Description: 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 */
package 牛客网练习题;

/**
 * 分别遍历needle的数字 再去遍历haystack的位置，并记录好第一个相同的位置的值
 *  这个题目还没有实现
 */
public class strStr {

    public static int strStr(String haystack, String needle) {
        if(needle==""){
            return 0;
        }else {
            //将两个字符转化为字符数字
            char[] char1=haystack.toCharArray();
            char[] char2=needle.toCharArray();
            int index=0;//记录第一次出现的位置
            //分别遍历他们的数据
            for(int i=0;i<char1.length;i++) {
                for (int j = 0; j < char2.length; j++) {
                    if (char2[j] == char1[i]) {
                        index = i;
                        i++;
                    }else {
                        i++;
                        j=0;
                    }
                    //判断结束偶匹配了
                    if (j + 1 == char2.length) {
                        return index - char2.length+1;
                    }
                }
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        String haystack = "aaaaa", needle = "bba";
        System.out.println(strStr(haystack,needle));
    }
}
