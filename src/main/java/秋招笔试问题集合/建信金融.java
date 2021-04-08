/**
 * Copyright (C), 2018-2020
 * FileName: Main
 * Author:   xjl
 * Date:     2020/7/29 8:40
 * Description: 考试函数框架
 */
package 秋招笔试问题集合;

import java.util.*;

public class 建信金融 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        String ss1 = "";
        String ss2 = "";
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != '"') {
                ss1 += str1.charAt(i);
            }
        }
        for (int i = 0; i < str2.length(); i++) {
            if (str2.charAt(i) != '"') {
                ss2 += str2.charAt(i);
            }
        }
        String[] str11 = ss1.split(" ");
        String[] str22 = ss2.split(" ");
        HashMap<String, Integer> map = new HashMap<>();

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < str11.length; i++) {
            if (!map.containsKey(str11[i])) {
                map.put(str11[i], 1);
            } else {
                map.put(str11[i], map.get(str11[i]) + 1);
            }
        }

        for (int i = 0; i < str22.length; i++) {
            if (!map.containsKey(str22[i])) {
                map.put(str22[i], 1);
            } else {
                map.put(str22[i], map.get(str22[i]) + 1);
            }
        }

        for (String key : map.keySet()) {
            if (map.get(key) == 1) {
                list.add(key);
            }
        }
        System.out.print("[");
        for (int i = 0; i < list.size(); i++) {
            if (i != list.size() - 1) {
                System.out.print("\"");
                System.out.print(list.get(i));
                System.out.print("\"");
                System.out.print(",");
            } else {
                System.out.print("\"");
                System.out.print(list.get(i));
                System.out.print("\"");
            }
        }
        System.out.print("]");
    }

    public static void test(String[] args) {
        Scanner sc = new Scanner(System.in);
        //输入
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        String ss1 = "";
        String ss2 = "";
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != '"') {
                ss1 += str1.charAt(i);
            }
        }
        for (int i = 0; i < str2.length(); i++) {
            if (str2.charAt(i) != '"') {
                ss2 += str2.charAt(i);
            }
        }
        String[] str11 = ss1.split(" ");
        String[] str22 = ss2.split(" ");
        List<String> list1 = Arrays.asList(str11);
        List<String> list2 = Arrays.asList(str22);
        List<String> list = new ArrayList<>();
        for (String s : list1) {
            if (!list2.contains(s)) {
                list.add(s);
            }
        }
        for (String s : list2) {
            if (!list1.contains(s)) {
                list.add(s);
            }
        }

        //结果的输出
        System.out.print("[");
        for (int i = 0; i < list.size(); i++) {
            if (i != list.size() - 1) {
                System.out.print("\"");
                System.out.print(list.get(i));
                System.out.print("\"");
                System.out.print(",");
            } else {
                System.out.print("\"");
                System.out.print(list.get(i));
                System.out.print("\"");
            }
        }
        System.out.print("]");
    }

}
