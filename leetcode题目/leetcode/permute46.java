/**
 * Copyright (C), 2018-2020
 * FileName: permute46
 * Author:   xjl
 * Date:     2020/6/5 15:15
 * Description: 全排列
 */
package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class permute46 {
    List<List<Integer>> lists = new ArrayList<>();
    boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null) {
            return lists;
        }
        List<Integer> list = new ArrayList<>();
        used = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            used[i] = false;
        }
        slove(nums, 0, list);
        return lists;
    }

    private void slove(int[] nums, int index, List<Integer> list) {
        //递归的终止条件
        if (index == nums.length) {
            lists.add(list);
            return;
        }
        //递归函数
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                list.add(nums[i]);
                used[i] = true;
                slove(nums, index + 1, list);
                list.remove(list.size() - 1);
                used[i] = false;
            }
        }
    }

    @Test
    public void test() {
        int[] array = {1, 2, 3};
        List<List<Integer>> permute = permute(array);
        for (List lists : permute) {
            System.out.println(lists.toArray().toString());
        }
    }
}
