/**
 * Copyright (C), 2018-2020
 * FileName: containsNearbyDuplicate
 * Author:   xjl
 * Date:     2020/3/3 13:50
 * Description: 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 */
package simple_difficulty;

import java.util.HashMap;
import java.util.Map;

/**
 * 遍历的数组：记录刺客的第一个位置的数据，在遍历在一次的时候创记录第二次的位置，并记录的j 再利用i-j<K
 */
public class containsNearbyDuplicate {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    if (Math.abs(j - i) <= k) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean containsNearbyDuplicate2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            } else {
                //这里时候有相同的了
                if ((i - map.get(nums[i]) <= k)) {
                    return true;
                }else {
                    map.put(nums[i], i);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,1,1};
        int k = 1;
        System.out.println(containsNearbyDuplicate2(nums, k));
    }
}
