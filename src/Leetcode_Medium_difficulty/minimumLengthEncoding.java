/**
 * Copyright (C), 2018-2020
 * FileName: minimumLengthEncoding
 * Author:   xjl
 * Date:     2020/3/28 7:44
 * Description: 给定一个单词列表，我们将这个列表编码成一个索引字符串 S 与一个索引列表 A。
 */
package Leetcode_Medium_difficulty;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class minimumLengthEncoding {
    public int minimumLengthEncoding(String[] words) {
        if (words.length == 1) {
            return words[0].length() + 1;
        }
        String S = "";
        for (String ss : words) {
            if (S == "") {
                //S为空的时候
                S += ss;
            } else {
                S = test2(S, ss);
                System.out.println(S);
            }
        }
        return S.length();
    }

    public String test2(String SS, String ss) {
        //判断最后一个是否为# 如果是的话那么取点
        if (SS.charAt(SS.length() - 1) == '#') {
            SS = SS.substring(0, SS.length() - 1);
        }
        //如果不是则进行判断
        for (int i = 0; i < SS.length(); i++) {
            String sub = SS.substring(SS.length() - i, SS.length());
            if (sub.equals(ss)) {
                return SS + "#";
            }
        }
        //匹配完成的后还是没有找到
        return SS + "#" + ss + "#";
    }

    /**
     * set中是不允许出现重复的元素
     *
     * @param words
     * @return
     */
    public int minimumLengthEncoding2(String[] words) {
        Set<String> goods = new HashSet(Arrays.asList(words));
        for (String good : goods) {
            //获取该单词的后缀 去除其他的子串
            for (int i = 1; i < good.length(); i++) {
                String sub = good.substring(i);
                goods.remove(sub);
            }
        }
        int sum = 0;
        for (String s : goods) {
            sum += s.length() + 1;
        }
        return sum;
    }

    @Test
    public void test() {
        String[] words = {"me", "time", "me"};
        System.out.println("resilt=" + minimumLengthEncoding2(words));
    }
}
