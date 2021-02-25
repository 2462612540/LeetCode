/**
 * Copyright (C), 2018-2020
 * FileName: 柱状图中的最大矩形
 * Author:   xjl
 * Date:     2020/9/20 22:53
 * Description:
 */
package 计算机程序算法分类.栈问题;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class 柱状图中的最大矩形 {
    public int largestRectangArea(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return heights[0];
        }
        int Area = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            //当栈顶的元素大于当前的元素
            while (!stack.isEmpty() && heights[stack.peekLast()] > heights[i]) {
                //栈顶的高度
                int height = heights[stack.removeLast()];
                //弹出栈
                while (!stack.isEmpty() && heights[stack.peekLast()] == height) {
                    stack.removeLast();
                }
                int width;
                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peekLast() - 1;
                }
                Area = Math.max(Area, width * height);
            }
            stack.add(i);
        }
        while (!stack.isEmpty()) {
            //栈顶的高度
            int height = heights[stack.removeLast()];
            //弹出栈
            while (!stack.isEmpty() && heights[stack.peekLast()] == height) {
                stack.removeLast();
            }
            int width;
            if (stack.isEmpty()) {
                width = len;
            } else {
                width = len - stack.peekLast() - 1;
            }
            Area = Math.max(Area, width * height);
        }
        return Area;
    }

    public int largestRectangArea1(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return heights[0];
        }
        int Area = 0;
        int[] newHeights = new int[len + 2];
        for (int i = 0; i < len; i++) {
            newHeights[i + 1] = heights[i];
        }
        len += 2;
        heights = newHeights;
        //栈中存放的是一个宽度的位置 当前位置的最高下标值
        Deque<Integer> stack = new ArrayDeque<>();
        stack.add(0);
        for (int i = 1; i < len; i++) {
            //当栈顶的元素大于当前的元素
            while (heights[stack.peekLast()] > heights[i]) {
                //栈顶的高度
                int height = heights[stack.removeLast()];
                //弹出栈
                int width = i - stack.peekLast() - 1;
                Area = Math.max(Area, width * height);
            }
            stack.add(i);
        }
        return Area;
    }

    /**
     * 暴力的解法
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        // 特判
        if (len == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            // 找左边最后 1 个大于等于 heights[i] 的下标
            int left = i;
            int curHeight = heights[i];
            while (left > 0 && heights[left - 1] >= curHeight) {
                left--;
            }
            // 找右边最后 1 个大于等于 heights[i] 的索引
            int right = i;
            while (right < len - 1 && heights[right + 1] >= curHeight) {
                right++;
            }
            int width = right - left + 1;
            res = Math.max(res, width * curHeight);
        }
        return res;
    }

    @Test
    public void test() {
        int[] array = {2, 1, 5, 6, 2, 3};
        int i = largestRectangArea1(array);
        System.out.println(i);
    }
}
