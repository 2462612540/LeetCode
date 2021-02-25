/**
 * Copyright (C), 2018-2020
 * FileName: Main
 * Author:   xjl
 * Date:     2020/7/29 8:40
 * Description: 考试函数框架
 */
package 计算机程序算法分类.秋招笔试问题集合;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str1 = sc.nextLine().split(" ");
        String[] str2 = sc.nextLine().split(" ");
        //数组
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        //数据
        for (int i = 0; i < str1.length; i++) {
            list1.add(Integer.valueOf(str1[i]));
        }
        for (int i = 0; i < str2.length; i++) {
            list2.add(Integer.valueOf(str2[i]));
        }

        for (int i = 0; i < list2.size(); i++) {
            if (!list1.contains(list2.get(i))) {
                list2.remove(i);
            }
        }

        ArrayList<Integer> list3 = new ArrayList<>();
        ArrayList<Integer> list4 = new ArrayList<>();

        //如果是的list2为空的话
        if (list2.size() == 0) {
            Collections.sort(list1);
            for (int va : list1) {
                System.out.print(va + " ");
            }
        } else {
            for (int V : list2) {
                for (int j = 0; j < list1.size(); j++) {
                    if (!list2.contains(list1.get(j)) ) {
                        list4.add(list1.get(j));
                        list1.remove((Object)list1.get(j));
                    } else if (list1.get(j) == V && list2.contains(list1.get(j))) {
                        list3.add(list1.get(j));
                    }
                }
            }
            Collections.sort(list4);
            for (int i = 0; i < list4.size(); i++) {
                list3.add(list4.get(i));
            }
            for (int Va : list3) {
                System.out.print(Va + " ");
            }
        }
    }
}

