package 名企高频面试题143; /**
 * Copyright (C), 2018-2020
 * FileName: 名企高频面试题143.两个数的和
 * Author:   xjl
 * Date:     2020/9/24 12:58
 * Description:
 */


import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class 两个数的和 {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (i != j && numbers[j] == target - numbers[i]) {
                    return new int[]{i+1, j+1};
                }
            }
        }
        return null;
    }

    public int[] twoSum1(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for(int i = 0;i<nums.length;i++){
            int tmp = target - nums[i];
            if(map.containsKey(tmp) && map.get(tmp) != i){
                return new int[]{i,map.get(tmp)};
            }
        }
        throw new RuntimeException("No two sum solution");
    }

    @Test
    public void test() {
        int[] numbers = {2,8,2,15};
        int[] ints = twoSum1(numbers, 4);
        for (int i : ints) {
            System.out.println(i);
        }

    }
}
