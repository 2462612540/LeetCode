/**
 * Copyright (C), 2018-2020
 * FileName: permutation0807
 * Author:   xjl
 * Date:     2020/7/15 21:34
 * Description: 无重复字符串的排列组合
 */
package leetcode练习题;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class permutation0807 {

    public static void main(String[] args) {
        //数据的输入
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        //函数的调用
        String[] result = permutation(str);
        //结果
        for (String s : result) {
            System.out.print(s + " ");
        }
    }

    public static String[] permutation(String S) {
        Set<String> set = new HashSet<>();
        char[] chars = S.toCharArray();
        boolean[] visit = new boolean[S.length()];
        slove(chars, 0, "", set, visit);
        String[] result = new String[set.size()];
        int index = 0;
        for (String s : set) {
            result[index++] = s;
        }
        return result;
    }

    private static void slove(char[] chars, int index, String str, Set<String> set, boolean[] visit) {
        if (index == chars.length) {
            set.add(str);
        } else {
            for (int i = 0; i < chars.length; i++) {
                if (!visit[i]) {
                    visit[i] = true;
                    str += chars[i];
                    slove(chars, index + 1, str, set, visit);
                    //回溯
                    str = str.substring(0,str.length() - 1);
                    visit[i] = false;
                }
            }
        }
    }
}
