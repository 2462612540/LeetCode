/**
 * Copyright (C), 2018-2020
 * FileName: searchInsert
 * Author:   xjl
 * Date:     2020/2/29 15:05
 * Description: 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 */
package leetcode练习题;

import java.util.HashMap;
import java.util.Map;

/**
 * 1遍历依次所有的数组；
 * 如果在遍历的过程中遇见目标值则返回这个下标
 * 如果没有的话
 */
public class searchInsert {
    public static int searchInsert(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            if(target==nums[i]){
                return i;
            }else {
                if(nums[i]>target){
                    return i;
                }
            }
        }
        return nums.length;
    }
    public static void test(){
        //测试map
        Map<Integer,Integer> map=new HashMap<>();
        map.put(1,1);
        map.put(1,2);
        map.put(1,30);
        System.out.println(map.get(1));//由此可以知道获取的是最后的一个的下标

    }
    public static void main(String[] args) {
        int[] nums={1,3,5,6};
        int target=7;
        int res=searchInsert(nums,target);
        System.out.println(res);
//        test20200430();
    }
}
