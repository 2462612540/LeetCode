/**
 * Copyright (C), 2018-2020
 * FileName: singleNumber
 * Author:   xjl
 * Date:     2020/3/1 16:00
 * Description: 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 */
package Leetcode_simple_difficulty;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 遍历数组将map中的没有的数据存放 如则删除map中的
 * 这样的方法效率比较低
 */
public class singleNumber {

    public static int singleNumber(int[] nums) {
        int result=0;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!map.containsValue(nums[i])){
                map.put(nums[i],nums[i]);
            }else {
                map.remove(nums[i]);
            }
        }
        for(int key:map.keySet()){
            result=map.get(key);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums={4,1,2,1,2,4,5};
        System.out.println(singleNumber(nums));
    }
}
