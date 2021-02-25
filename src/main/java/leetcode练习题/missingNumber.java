/**
 * Copyright (C), 2018-2020
 * FileName: missingNumber
 * Author:   xjl
 * Date:     2020/3/2 8:56
 * Description: 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 */
package leetcode练习题;

import java.util.HashMap;
import java.util.Map;

/**
 * 对应的将数据存入map中，
 */
public class missingNumber {
    public static int missingNumber(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
           map.put(nums[i],nums[i]);
        }
        for(int i=0;i<nums.length+1;i++){
            if(!map.containsValue(i)){
                return i;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        int[] nums={0,1};
        System.out.println(missingNumber(nums));
    }
}
