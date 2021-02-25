/**
 * Copyright (C), 2018-2020
 * FileName: 找到字符串中所有字母异位词438
 * Author:   xjl
 * Date:     2020/9/4 15:59
 * Description:
 */
package 计算机程序算法分类.滑动窗口问题集合;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class 找到字符串中所有字母异位词438 {

    public List<Integer> findAnagrams(String s, String p) {
        int start = 0, left = 0, right = 0;
        int macth = 0;
        List<Integer> res = new ArrayList<>();
        //表示窗口和当前的须的条件
        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> needs = new HashMap<>();

        for (char c : p.toCharArray()) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }
        //右指针移动
        while (right < s.length()) {
            char c1 = s.charAt(right);
            if (needs.containsKey(c1)) {
                window.put(c1, window.getOrDefault(c1, 0) + 1);
                if (window.get(c1).equals(needs.get(c1)))
                    macth++;
            } else {
                //如果是不在里面将左指针跳到右指重新开始的窗口 并计数为0
                left = right + 1;
                window = new HashMap<>();
                macth = 0;
            }
            right++;
            //左指针开始移动
            while (macth == needs.size()) {
                start = left;
                if (window.equals(needs))
                    res.add(start);
                char c2 = s.charAt(left);
                if (window.containsKey(c2)) {
                    window.put(c2, window.get(c2) - 1);
                    if (window.get(c2) < (needs.get(c2)))
                        macth--;
                }
                left++;
            }
        }
        return res;
    }
}
