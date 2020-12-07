/**
 * Copyright (C), 2018-2020
 * FileName: 最长无重复字串
 * Author:   xjl
 * Date:     2020/9/14 14:26
 * Description:
 */
package 牛客面试必会100题;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class 最长无重复字串 {

    public int maxLength(int[] arr) {
        int maxnum = 0;
        for (int i = 0; i < arr.length; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i; j >= 0; j--) {
                if (!set.contains(arr[j])) {
                    set.add(arr[j]);
                } else {
                    break;
                }
            }
            maxnum = maxnum < set.size() ? set.size() : maxnum;
        }
        return maxnum;
    }

    public int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> set = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                set.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !set.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                set.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

    public int maxLength2(int[] arr) {
        int[] last = new int[100000];
        int n = arr.length;
        int res = 0;

        int start = 0; // 窗口开始位置
        for (int i = 0; i < n; i++) {
            int index = arr[i];
            start = Math.max(start, last[index]);
            res = Math.max(res, i - start + 1);
            last[index] = i + 1;
        }
        return res;
    }

    /**
     * 也是可以使用的的滑动窗口的识别
     */

    @Test
    public void test() {
        int[] array = {2, 3, 4, 5};
        int i = maxLength2(array);
        System.out.println(i);
    }
}
