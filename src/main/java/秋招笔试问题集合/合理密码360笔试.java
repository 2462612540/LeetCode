/**
 * Copyright (C), 2018-2020
 * FileName: Main
 * Author:   xjl
 * Date:     2020/7/29 8:40
 * Description: 考试函数框架
 */
package 秋招笔试问题集合;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 合理密码360笔试 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> ans = new ArrayList<>();
        do {
            String str = sc.nextLine();
            if (str.equals("")) {
                break;
            }
            if (str.length() < 8) {
                ans.add("lrregal password");
            } else {
                if (test(str)) {
                    ans.add("ok");
                } else {
                    ans.add("lrregal password");
                }
            }
        } while (true);
        for (String s : ans) {
            System.out.println(s);
        }
    }

    private static boolean test(String password) {
        int[] dircty = new int[4];
        Arrays.fill(dircty, -1);
        for (int i = 0; i < password.length(); i++) {
            char curr = password.charAt(i);
            if ('0' <= curr && curr <= '9') {
                dircty[0]++;
                continue;
            } else if ('a' <= curr && curr <= 'z') {
                dircty[1]++;
                continue;
            } else if ('A' <= curr && curr <= 'Z') {
                dircty[2]++;
                continue;
            } else {
                dircty[3]++;
                continue;
            }
        }
        for (int i = 0; i < 4; i++) {
            if (dircty[i] == -1) {
                return false;
            }
        }
        return true;
    }
}
