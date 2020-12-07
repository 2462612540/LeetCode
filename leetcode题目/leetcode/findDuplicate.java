/**
 * Copyright (C), 2018-2020
 * FileName: findDuplicate
 * Author:   xjl
 * Date:     2020/3/2 9:17
 * Description: 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 */
package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 在遍历数组的时候将数据放入map中，如果是遇见有相同的那么久直接返回即可
 */
public class findDuplicate {
    public static int findDuplicate(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsValue(nums[i])){
                return nums[i];
            }else {
                map.put(i,nums[i]);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums={1,3,4,2,2};
        System.out.println(findDuplicate(nums));
    }
}
