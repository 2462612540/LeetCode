/**
 * Copyright (C), 2018-2020
 * FileName: 两个数之和1
 * Author:   xjl
 * Date:     2020/11/2 16:32
 * Description:
 */
package 计算机程序算法分类.数组问题;

import org.junit.Test;

import java.util.HashMap;

public class 两个数之和1 {
    /**
     * 将里面的元素存储在hasmap中的 然后保证的key不相同就好key-value :nums[i] index
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        //存储
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i) {
                return new int[]{i, map.get(target - nums[i])};
            }
        }
        return null;
    }

    @Test
    public void test() {
        int[] ints = twoSum(new int[]{4,4, 11, 11, 15}, 8);
        System.out.println(ints[0]+"--"+ints[1]);
    }

    /**
     * 暴力的方法：最容易想到的方法是枚举数组中的每一个数 x，寻找数组中是否存在 target - x。
     * 当我们使用遍历整个数组的方式寻找 target - x 时，需要注意到每一个位于 x 之前的元素都已经和 x 匹配过，因此不需要再进行匹配。
     * 而每一个元素不能被使用两次，所以我们只需要在 x 后面的元素中寻找 target - x。
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

}
