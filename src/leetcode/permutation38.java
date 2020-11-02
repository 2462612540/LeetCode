/**
 * Copyright (C), 2018-2020
 * FileName: permutation38
 * Author:   xjl
 * Date:     2020/7/15 19:23
 * Description: 剑指 Offer 38. 字符串的排列
 */
package leetcode;

import org.junit.Test;

import java.util.*;

public class permutation38 {

    Set<String> result = new HashSet<>();

    public ArrayList<String> permutation(String str) {
        if (str == null||str.length()<1) {
            return new ArrayList();
        }
        boolean[] visited = new boolean[str.length()];
        process(str, "", visited);
        ArrayList<String> ans = new ArrayList<>(result);
        Collections.sort(ans);
        return ans;
    }

    private void process(String s, String letter, boolean[] visted) {
        if (s.length() == letter.length()) {
            result.add(letter);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (visted[i]) continue;
            visted[i] = true;
            process(s, letter + String.valueOf(temp), visted);
            visted[i] = false;
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    List<String> res = new ArrayList<>();

    public String[] permutation1(String s) {
        char[] chars = s.toCharArray();
        boolean[] visit = new boolean[chars.length];

        List<Character> list = new ArrayList<>();

        help(chars, 0, list, visit);
        //去重复
        List<String> res1 = new ArrayList<>();
        for (int i = 0; i < res.size(); i++) {
            if (!res1.contains(res.get(i))) {
                res1.add(res.get(i));
            }
        }
        //返回的结果
        String[] result = new String[res1.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = res1.get(i);
        }
        return result;
    }

    private void help(char[] chars, int index, List<Character> list, boolean[] visit) {
        if (list.size() == chars.length) {
            res.add(test1(list));
            return;
        } else {
            for (int i = 0; i < chars.length; i++)
                if (!visit[i]) {
                    //访问
                    visit[i] = true;
                    list.add(chars[i]);
                    help(chars, index + 1, list, visit);
                    //回溯
                    visit[i] = false;
                    list.remove(list.size() - 1);
                }
        }
    }

    private String test1(List<Character> list) {
        String s = "";
        for (char c : list) {
            s += c;
        }
        return s;
    }

    @Test
    public void test() {
        ArrayList<String> res = permutation("abc");
        for (String s : res) {
            System.out.println(s);
        }
    }
}
