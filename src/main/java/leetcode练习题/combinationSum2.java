/**
 * Copyright (C), 2018-2020
 * FileName: combinationSum2
 * Author:   xjl
 * Date:     2020/3/31 11:42
 * Description: 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 */
package leetcode练习题;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        int sum = 0;

        return lists;
    }

    @Test
    public void test() {
        int[] can = {10, 1, 2, 7, 6, 1, 5};
        combinationSum2(can, 8);
    }

}
