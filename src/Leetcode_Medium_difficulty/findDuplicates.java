/**
 * Copyright (C), 2018-2020
 * FileName: findDuplicates
 * Author:   xjl
 * Date:     2020/3/2 12:50
 * Description: 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。  找到所有出现两次的元素。  你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
 */
package Leetcode_Medium_difficulty;

import java.util.ArrayList;
import java.util.List;

public class findDuplicates {
    /**
     * 算法的可行性是可以的但是负载度不符合我要求
     * @param nums
     * @return
     */
    public static List<Integer> findDuplicates(int[] nums) {
        List list = new ArrayList();
        if(nums.length==0){return list;}
        //利用冒泡排序 将数字快速排序
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[i]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        for(int i=0;i<nums.length;i++){
            //如果是到最后一个时候就返回
            if(i+1==nums.length){
                return list;
            }
            if(nums[i]==nums[i+1]){
                list.add(nums[i]);
                i++;
            }
        }
        return list;
    }

    public static List<Integer> findDuplicates2(int[] nums){
        List list = new ArrayList();
        if(nums.length==0){return list;}

        return list;
    }
    public static void main(String[] args) {
        int[] nums={4,3,2,7,8,2,3,1,5,8,8,9};
        List list=findDuplicates(nums);
        System.out.println(list);

    }
}
