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

public class permutation38 {
    public String[] permutation(String s) {
        return null;
    }

    public ArrayList<String> Permutation(String str) {
        char[] a = str.toCharArray();
        ArrayList<String> ans = new ArrayList<>();
        slove(ans, a, 0, str.length());
        ans = new ArrayList<String>(new HashSet<String>(ans));
        Collections.sort(ans);
        return ans;
    }

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
}
