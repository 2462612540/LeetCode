/**
 * Copyright (C), 2018-2020
 * FileName: Main
 * Author:   xjl
 * Date:     2020/7/29 8:40
 * Description: 考试函数框架
 */
package Test_Pricate;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        boolean res = test(s1, s2);

        System.out.println(res);

    }

    private static boolean test(String A, String B) {

        int lenA = A.length();
        int lenB = B.length();
        if (lenA != lenB || lenA < 2 || lenB < 2) {
            return false;
        }
        if (A.equals(B)) {
            HashSet<Character> set = new HashSet<>();
            for (int i = 0; i < lenA; i++) {
                if (set.contains(A.charAt(i))) {
                    return true;
                } else {
                    set.add(A.charAt(i));
                }
            }
            return false;
        }

        int count = 0;
        int pre = -1, post = -1;
        for (int i = 0; i < lenA; i++) {
            if (count > 2) {
                return false;
            }
            if (A.charAt(i) == B.charAt(i)) {
                continue;
            }
            else {
                ++count;
                if (pre == -1) {
                    pre = i;
                } else {
                    post = i;
                }
            }
        }
        return count == 2 && A.charAt(pre) == B.charAt(post) && A.charAt(post) == B.charAt(pre);
    }
}

