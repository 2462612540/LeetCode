/**
 * Copyright (C), 2018-2020
 * FileName: longestCommonPrefix
 * Author:   xjl
 * Date:     2020/2/29 12:30
 * Description: 编写一个函数来查找字符串数组中的最长公共前缀
 */
package Leetcode_simple_difficulty;

import org.junit.Test;

import java.util.Arrays;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀
 */
public class longestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        //取第一个个数为来时
        String prefix = strs[0];
        for (String s : strs) {
            //indexOf(String str) ：返回第一次出现的指定子字符串在此字符串中的索引。
            while (s.indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }

    public static String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        Arrays.sort(strs);
        String world1 = strs[0];
        String world2 = strs[strs.length - 1];
        while (world2.indexOf(world1) != 0) {
            world1 = world1.substring(0, world1.length() - 1);
        }
        return world1;
    }

    @Test
    public void test() {
        System.out.println(longestCommonPrefix2(new String[]{"flower", "flow", "flight"}));
    }
}
