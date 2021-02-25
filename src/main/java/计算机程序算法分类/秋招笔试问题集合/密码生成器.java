/**
 * Copyright (C), 2018-2020
 * FileName: 密码生成器
 * Author:   xjl
 * Date:     2020/9/8 18:46
 * Description:
 */
package 计算机程序算法分类.秋招笔试问题集合;

import java.util.ArrayList;
import java.util.Scanner;

public class 密码生成器 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String password = sc.nextLine();
        int[] res = test(password);
        for (int i : res) {
            System.out.println(i);
        }
    }

    private static int[] test(String password) {
        String[] split = password.split(" ");
        ArrayList<Integer> list = new ArrayList<>();
        for (String s : split) {
            if (s.length() < 8 || s.length() > 120) {
                list.add(1);
                continue;
            }
            int[] dirty = new int[4];
            for (int i = 0; i < s.length(); i++) {
                char cur = s.charAt(i);
                if ('0' <= cur && cur <= '9') {
                    dirty[0]++;
                } else if ('a' <= cur && cur <= 'z') {
                    dirty[1]++;
                } else if ('A' <= cur && cur <= 'Z') {
                    dirty[2]++;
                } else {
                    dirty[3]++;
                }
            }
            boolean t = true;
            for (int i = 0; i < 4; i++) {
                if (dirty[i] == 0) {
                    t = false;
                }
            }
            if (t) {
                list.add(0);
            } else {
                list.add(2);
            }
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
