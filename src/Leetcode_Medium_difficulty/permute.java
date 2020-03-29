/**
 * Copyright (C), 2018-2020
 * FileName: permute
 * Author:   xjl
 * Date:     2020/3/28 12:00
 * Description: 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 */
package Leetcode_Medium_difficulty;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class permute {
    public void backtrack(int n, ArrayList<Integer> nums, List<List<Integer>> output, int first) {
        // if all integers are used up
        if (first == n)
            output.add(new ArrayList<Integer>(nums));
        for (int i = first; i < n; i++) {
            // place i-th integer first
            // in the current permutation
            Collections.swap(nums, first, i);
            // use next integers to complete the permutations
            backtrack(n, nums, output, first + 1);
            // backtrack
            Collections.swap(nums, first, i);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        // init output list
        List<List<Integer>> output = new LinkedList();
        // convert nums into list since the output is a list of lists
        ArrayList<Integer> nums_lst = new ArrayList<Integer>();
        for (int num : nums)
            nums_lst.add(num);
        int n = nums.length;
        backtrack(n, nums_lst, output, 0);
        return output;
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }
}
