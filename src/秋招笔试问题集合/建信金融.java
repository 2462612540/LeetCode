/**
 * Copyright (C), 2018-2020
 * FileName: Main
 * Author:   xjl
 * Date:     2020/7/29 8:40
 * Description: 考试函数框架
 */
package 秋招笔试问题集合;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

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
        for (int i=0;i<list.size();i++){
            if (i!=list.size()-1){
                System.out.print("\"");
                System.out.print(list.get(i));
                System.out.print("\"");
                System.out.print(",");
            }else {
                System.out.print("\"");
                System.out.print(list.get(i));
                System.out.print("\"");
            }
        }
        System.out.print("]");
    }
}
