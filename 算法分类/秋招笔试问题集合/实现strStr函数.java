/**
 * Copyright (C), 2018-2020
 * FileName: Main
 * Author:   xjl
 * Date:     2020/7/29 8:40
 * Description: 考试函数框架
 */
package 秋招笔试问题集合;

import java.util.Scanner;

public class 实现strStr函数 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().trim().split(" ");
        String haystack = str[0];
        String needle = str[1];
        int i = test11(haystack, needle);
        System.out.println(i);


    }

    private static int test11(String haystack, String needle) {
        if (needle.equals(" ")){
            return 0;
        }
        int L=needle.length(),n=haystack.length();
        for (int start=0;start<n-L+1;++start){
            if (haystack.substring(start,start+L).equals(needle)){
                return start;
            }
        }
        return -1;
    }
}
