/**
 * Copyright (C), 2018-2020
 * FileName: isSubsequence392
 * Author:   xjl
 * Date:     2020/7/27 9:04
 * Description: 392. 判断子序列
 */
package leetcode练习题;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class isSubsequence392 {

    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }

    public boolean isSubsequence1(String s, String t) {
        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            if (!map.containsKey(t.charAt(i))) {
                //如果是不存在的话
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(t.charAt(i), list);
            } else {
                //如果是存在的话
                ArrayList<Integer> list = map.get(t.charAt(i));
                list.add(i);
                map.put(t.charAt(i), list);
            }
        }
        int index = -1;

        for (int i = 0; i < s.length(); i++) {
            int flag = 0;
            ArrayList<Integer> list = map.get(s.charAt(i));
            if (list == null) {
                return false;
            }
            for (int V : list) {
                if (V > index) {
                    flag = 1;
                    index = V;
                    break;
                }
            }
            if (flag == 0) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        boolean subsequence = isSubsequence1("acb","ahbgdc");
        System.out.println(subsequence);
    }
}
