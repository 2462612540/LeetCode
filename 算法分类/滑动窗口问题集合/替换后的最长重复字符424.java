/**
 * Copyright (C), 2018-2020
 * FileName: 替换后的最长重复字符424
 * Author:   xjl
 * Date:     2020/9/4 13:50
 * Description:
 */
package 滑动窗口问题集合;

public class 替换后的最长重复字符424 {
    public static void main(String[] args) {

    }

    public int test(String s, int k) {
        //设置窗口的左右
        int left = 0;
        int right = 0;

        int result = 0;
        //最多的重复字母的个数
        int maxlen = -1;
        //设置元素的个数
        char[] chars = new char[256];
        //当有边界小于的最后的时候结束循环
        while (right < s.length()) {
            //获取当前元素
            char cur = s.charAt(right);
            //表示的是的A的元素的个数+1
            chars[cur]++;
            //获取最多元素的个数和
            maxlen = Math.max(maxlen, chars[cur]);
            //如果是超过的k个数的不同
            while ((right - left + 1 - maxlen) > k) {
                //左边开始++ 并将元素个数减1
                chars[s.charAt(left++)]--;
            }
            //表示替换后的数组可以实现的一种最多
            result = Math.max(result, right - left + 1);
            right++;
        }
        return result;
    }
}
