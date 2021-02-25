/**
 * Copyright (C), 2018-2020
 * FileName: firstMissingPositive
 * Author:   xjl
 * Date:     2020/3/2 9:29
 * Description: 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 */
package leetcode练习题;

import java.util.HashMap;
import java.util.Map;

public class firstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        if(nums.length==0){
            return 1;
        }else {
            Map<Integer,Integer> map=new HashMap<>();
            for(int i=0;i<nums.length;i++){
                map.put(nums[i],nums[i]);
            }
            for(int i=1;i<nums.length+2;i++){
                if(!map.containsValue(i)){
                    return i;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums={0};
        System.out.println(firstMissingPositive(nums));
    }
}
