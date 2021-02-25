/**
 * Copyright (C), 2018-2020
 * FileName: Main
 * Author:   xjl
 * Date:     2020/7/29 8:40
 * Description: 考试函数框架
 */
package 计算机程序算法分类.秋招笔试问题集合;

import java.util.ArrayList;

public class 素数 {
    static class ListNode {
        Character val;
        ListNode next;

        public ListNode(Character val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 5, 11, 12};
        int[] res = test12(array);
        for (int i : res) {
            System.out.println(i);
        }
    }

    private static int[] test12(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int j = 0; j < nums.length; j++) {
            boolean flag = true;
            for (int i = 2; i <= nums[j] / 2; i++) {
                if (nums[j] % i == 0)
                    flag = false;
            }
            if (flag == true) {
                list.add(nums[j]);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
