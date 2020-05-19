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

public class Permutation46 {
    List<List<Integer>> lists = new ArrayList<>();
    Boolean[] used;

    public void generatepermuation(int[] nums, int index, List<Integer> list) {
        //递归的终止
        if (index == nums.length) {
            //lists.add(list); 如果是这样的话list这里是做的是值的传递，那从都到位都是用的是一个list ,所以在的这里需要时的创建新的list 再将这个list复制给他。
            lists.add(new ArrayList<>(list));
            return;
        }
        //递归
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                list.add(nums[i]);
                used[i] = true;
                generatepermuation(nums, index + 1, list);
                //回溯的过程
                list.remove(list.size()-1);
                used[i] = false;
            }
        }
        return;
    }

    public List<List<Integer>> permute(int[] nums) {
        System.out.println(nums.length);
        if (nums.length == 0) {
            return lists;
        }
        List<Integer> list = new ArrayList();
        used = new Boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            used[i] = false;
        }
        generatepermuation(nums, 0, list);
        return lists;
    }

    @Test
    public void test() {
        int[] numbers={1,2,3};
        System.out.println(permute(numbers).toString());
    }
}
