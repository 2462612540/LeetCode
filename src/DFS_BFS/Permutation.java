/**
 * Copyright (C), 2018-2020
 * FileName: Permutation
 * Author:   xjl
 * Date:     2020/7/15 15:51
 * Description: 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */
package DFS_BFS;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class Permutation {

    public static void main(String[] args) {
        //数据的输入
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        //函数的调用
        ArrayList<String> list = permutationtest(str);
        //结果的打印
        for (String s : list) {
            System.out.print(s + " ");
        }

    }

    private static ArrayList<String> permutationtest(String str) {
        if (str == null || str.length() < 1) {
            return new ArrayList<>();
        }
        //存放所有的元素
        ArrayList<Character> chars = new ArrayList<>();
        //定义一个去重的
        TreeSet<String> result = new TreeSet<>();
        for (char c : str.toCharArray()) {
            chars.add(c);
        }
        Compose(chars, 0, new StringBuffer(), str.length(), result);
        return new ArrayList<>(result);
    }

    private static void Compose(ArrayList<Character> chars, int index, StringBuffer buffer, int length, TreeSet<String> result) {
        //递归结束的条件
        if (index == length) {
            result.add(buffer.toString());
            return;
        }
        for (int i = 0; i < chars.size(); i++) {
            char c = chars.get(i);
            buffer.append(c);
            chars.remove(i);
            //递归
            Compose(chars, index + 1, buffer, length, result);
            //回溯
            chars.add(i, c);
            buffer.deleteCharAt(buffer.length() - 1);
        }
    }
}
