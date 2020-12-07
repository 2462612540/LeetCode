/**
 * Copyright (C), 2018-2020
 * FileName: 容器的盛水的面积
 * Author:   xjl
 * Date:     2020/9/30 22:18
 * Description:
 */
package 牛客面试必会100题;

import org.junit.Test;

public class 容器的盛水的面积 {
    /**
     * 采用一个双指针的方法来实现的判断的
     *
     * @param height
     * @return
     */

    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);
            if (height[l] <= height[r]) {
                ++l;
            } else {
                --r;
            }
        }
        return ans;
    }

    public int maxArea2(int[] height) {
        int res = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int ans = Math.min(height[left], height[right]) * (right - left);
            ans = Math.max(ans, res);
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return res;
    }

    @Test
    public void test() {
        int i = maxArea(new int[]{1,8,6,2,5,4,8,3,7});
        System.out.println(i);
    }
}
