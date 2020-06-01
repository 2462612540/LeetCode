/**
 * Copyright (C), 2018-2020
 * FileName: exchange
 * Author:   xjl
 * Date:     2020/3/5 12:54
 * Description: 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 */
package leetcode;

public class exchange {
    public static int[] exchange(int[] nums) {
        int[] n = new int[nums.length];
        int x = 0, y = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0) {
                n[x] = nums[i];
                x++;
            } else {
                n[y] = nums[i];
                y--;
            }
        }
        return n;
    }

    public static void main(String[] args) {

    }
}
