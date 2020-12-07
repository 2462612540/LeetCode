/**
 * Copyright (C), 2018-2020
 * FileName: Permutation46
 * Author:   xjl
 * Date:     2020/4/23 14:53
 * Description: 全排列的组合
 */
package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * <p>
 * 输入: [1,1,2]
 * 输出:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 */
public class Permutation47 {

    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums.length == 0) return lists;
        List<Integer> list = new ArrayList<>();
        solve(nums, 0, list);
        return lists;
    }

    private void solve(int[] nums, int index, List<Integer> list) {
        if (index == nums.length) {
            if (!lists.contains(new ArrayList<>(list))) {
                lists.add(new ArrayList<>(list));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
                solve(nums, index + 1, list);
            }
        }
    }

    @Test
    public void test() {
        int[] array = {1, 1, 2};
        List<List<Integer>> lists = permuteUnique(array);

    }
}
