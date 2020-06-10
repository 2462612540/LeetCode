/**
 * Copyright (C), 2018-2020
 * FileName: permutation38
 * Author:   xjl
 * Date:     2020/6/5 10:41
 * Description: 面试题38. 字符串的排列
 */
package NewLeetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class permutation38 {

    List<String> res = new ArrayList<>();

    private void slove(ArrayList<String> ans, char[] a, int index, int length) {
        if (index == length - 1) {
            String res = change(a);
            ans.add(res);
        } else {
            //就是说明index的位置的字符
            for (int i = index; i < length; i++) {
                char temp = a[i];
                a[i] = a[index];
                a[index] = temp;
                //当前的index的位置的字符已经通过交换找到了，那么递归就找到下一个位置的字符
                slove(ans, a, index + 1, length);
                //其实就是为了递归的时候进行交换字符的影响
                temp = a[i];
                a[i] = a[index];
                a[index] = temp;
            }
        }
    }

    private String change(char[] a) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char v : a) {
            stringBuilder.append(v);
        }
        return stringBuilder.toString();
    }

    @Test
    public void test() {
        ArrayList<String> abc = Permutation("abc");
        for (String s : abc) {
            System.out.println(s);
        }
    }

    public ArrayList<String> Permutation(String str) {
        char[] a = str.toCharArray();
        ArrayList<String> ans = new ArrayList<>();
        slove(ans, a, 0, str.length());
        ans = new ArrayList<String>(new HashSet<String>(ans));
        Collections.sort(ans);
        String[] result = new String[ans.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = ans.get(i);
        }
        return ans;
    }

    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        boolean[] visit = new boolean[chars.length];

        List<Character> list = new ArrayList<>();

        help(chars, 0, list, visit);
        //处重复
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
    public void test1() {
        String[] abcs = permutation("aab");
        for (String s : abcs) {
            System.out.println(s);
        }
    }

}
