package 牛客网名企高频面试题143; /**
 * Copyright (C), 2018-2020
 * FileName: 名企高频面试题143.数字的全部排列去重复
 * Author:   xjl
 * Date:     2020/9/29 21:23
 * Description:
 */


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 数字的全部排列去重复 {
    /**
     * 采用的是结果去重的方法
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique2(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        test2(nums, 0, vis, list, lists);
        return lists;
    }

    private void test2(int[] nums, int index, boolean[] vis, List<Integer> list, List<List<Integer>> lists) {
        if (index == nums.length && !lists.contains(list)) {
            lists.add(new ArrayList<>(list));
            return;
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!vis[i]) {
                    list.add(nums[i]);
                    vis[i] = true;
                    test2(nums, index + 1, vis, list, lists);
                    list.remove(list.size() - 1);
                    vis[i] = false;
                }
            }
        }
    }

    /**
     * 采用的是的一种方式的是在递归遍历的时候在选择删除
     */
    @Test
    public void test() {
        List<List<Integer>> lists = permuteUnique(new int[]{1, 2, 3});
        for (List<Integer> list : lists) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        boolean[] vis = new boolean[nums.length];
        Arrays.sort(nums);
        test(nums, lists, 0, list, vis);
        return lists;
    }

    public void test(int[] nums, List<List<Integer>> lists, int index, List<Integer> list, boolean[] vis) {
        if (index == nums.length) {
            lists.add(new ArrayList<Integer>(list));
            return;
        }
        /**
         * 这里面实现的去重
         */
        for (int i = 0; i < nums.length; ++i) {
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue;
            }
            list.add(nums[i]);
            vis[i] = true;
            test(nums, lists, index + 1, list, vis);
            vis[i] = false;
            list.remove(index);
        }
    }
}
