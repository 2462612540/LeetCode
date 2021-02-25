/**
 * Copyright (C), 2018-2020
 * FileName: 字符串的排列567
 * Author:   xjl
 * Date:     2020/9/5 16:20
 * Description:
 */
package 计算机程序算法分类.滑动窗口问题集合;

import java.util.Arrays;

public class 字符串的排列567 {

    public boolean checkInclusion(String s1, String s2) {
        //记录好两个长度
        int l1 = s1.length();
        int l2 = s2.length();
        //定义好这个数组的表示的a-z的个数
        int[] c1 = new int[26];
        int[] c2 = new int[26];
        //记录好s1的每一个字母的个数
        for (char c : s1.toCharArray()) {
            c1[c - 'a']++;
        }
        //开始遍历新的l2的长度 这时候开始右至指针
        for (int i = 0; i < l2; i++) {
            if (i >= l1) {
                --(c2[s2.charAt(i - l1) - 'a']);
            }
            c2[s2.charAt(i) - 'a']++;
            //判断两个数组时候相同 知识统计个数而不是统计顺序的什么的 应为是子序列
            if (Arrays.equals(c1, c2)) {
                return true;
            }
        }
        return false;
    }
}
