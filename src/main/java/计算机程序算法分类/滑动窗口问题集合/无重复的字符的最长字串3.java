/**
 * Copyright (C), 2018-2020
 * FileName: 无重复的字符的最长字串3
 * Author:   xjl
 * Date:     2020/9/4 20:54
 * Description:
 */
package 计算机程序算法分类.滑动窗口问题集合;

import java.util.HashSet;
import java.util.Set;

public class 无重复的字符的最长字串3{
    /**
     * 相当于是的暴力的求解相关方法
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        //用来记录的这个不重复的字符
        for (int i = 0; i < s.length(); i++) {
            Set<Character> set = new HashSet<>();
            //这还是采用的遍历的全部的数据的方式
            for (int j = i; j < s.length(); j++) {
                if (!set.contains(s.charAt(j))) {
                    res = Math.max(res, j - i + 1);
                    set.add(s.charAt(j));
                } else {
                    break;
                }
            }
        }
        return res;
    }

    /**
     * 采用的是双指针的一种方式来实现的窗口的不重复性的元素  利用的set 维护了一个窗口
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        int res = 0;
        int l = 0;
        int r = 0;
        Set<Character> set = new HashSet<>();
        //开始有指针开始移动
        while (r < s.length()) {
            //如果右一直走 一直到遇见重复的元素
            while (r < s.length() && !set.contains(s.charAt(r))) {
                set.add(s.charAt(r));
                r++;
            }
            //比较当前的res 和 r-l的就是滑动窗口的大小
            res = Math.max(res, set.size());
            //如果右边走到最后了 整个就结束
            if (r == s.length()) {
                break;
            }
            //当l<r 就开始l++ 并且set中删除重复的元素
            while (l < r) {
                set.remove(s.charAt(l));
                l++;
                //如果是左边等于右边的就是滑动窗口为0 就是表示的是为0 开始移动右边的指针了
                if (s.charAt(l - 1) == s.charAt(r)) {
                    break;
                }
            }
        }
        return res;
    }

}
