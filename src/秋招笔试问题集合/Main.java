/**
 * Copyright (C), 2018-2020
 * FileName: Main
 * Author:   xjl
 * Date:     2020/7/29 8:40
 * Description: 考试函数框架
 */
package 秋招笔试问题集合;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int num = 0;
        while (list.size() != 1) {
            for (int i = 0; i < list.size(); i++) {
                if (++num == m) {
                    list.remove(list.get(i));
                    num = 1;
                }
            }
            for (int i = list.size() - 1; i >= 0; i--) {
                if (++num == m) {
                    list.remove(list.get(i));
                    num = 1;
                }
            }
        }
        System.out.println(list.get(0));
    }
}
