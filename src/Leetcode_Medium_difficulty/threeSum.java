/**
 * Copyright (C), 2018-2020
 * FileName: threeSum
 * Author:   xjl
 * Date:     2020/3/5 10:21
 * Description: 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组  来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/3sum 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package Leetcode_Medium_difficulty;

import java.util.ArrayList;
import java.util.List;

public class threeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = 1; j < nums.length; j++) {
                for (int k = 2; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        if (!res.contains(list)) {
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            res.add(list);
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        for (List<Integer> list : threeSum(nums)) {
            for (Integer i : list) {
                System.out.println(i);
            }
        }
        threeSum(nums);
    }
}
